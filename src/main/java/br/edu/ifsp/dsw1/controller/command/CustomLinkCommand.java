package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.edu.ifsp.dsw1.model.dao.link.LinkDAOFactory;
import br.edu.ifsp.dsw1.model.entity.Link;
import br.edu.ifsp.dsw1.model.entity.User;
import br.edu.ifsp.dsw1.model.enums.LinkType;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomLinkCommand implements Command {

	//Command responsável pela validação dos links criados pelo usuário
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var custom_link = request.getParameter("custom-link");
		var full_link = request.getParameter("full-link");
		var success = false;
		var message = "";
		
		// Regex para validar se o usuário enviou um link válido.
		String regex = "^(https?|ftp):\\/\\/[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}.*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(full_link);
		
		// Caso a URL completa seja válida, é feita mais uma valiação, para ver se o link
		// curto também está no parão desejado.
		if (matcher.matches()) {
			if (custom_link.length() >= 5 && custom_link.length() <= 12) {
				
				regex = "[a-zA-Z0-9_]{5,12}";
				pattern = Pattern.compile(regex);
				matcher = pattern.matcher(custom_link);
				
				if (matcher.matches()) {
					var dao = new LinkDAOFactory().factory();
					User user = (User) request.getSession(false).getAttribute("user");
					
					// Adiciona, caso não exista o identificador.
					if (dao.findById(custom_link) == null) {
						dao.create(new Link(custom_link, full_link, LinkType.CUSTOM), user.getEmail());
						message = "Link criado com sucesso!";
						request.setAttribute("custom-link", custom_link);
						success = true;
					} else {
						message = "Link com esse identificador já cadastrao.";
					}
				} else {
					message = "O link customizado não segue o padrão (letras, números e _). ";
				}
			} else {
				message = "O link customizado deve ter de 5 a 12 caracteres.";
			}
		} else {
			message = "O link completo informado é inválido.";
		}
		
		request.setAttribute("success", success);
		request.setAttribute("message", message);

		return "logged.do?action=custom-link-page";
	}
}
