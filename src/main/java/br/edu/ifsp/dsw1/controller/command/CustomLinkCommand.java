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

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		var custom_link = request.getParameter("custom-link");
		var full_link = request.getParameter("full-link");
		var success = true;
		var message = "";
		
		String regex = "^(https?|ftp):\\/\\/[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}.*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(full_link);
		
		if(matcher.matches()) {
			if(custom_link.length() >= 5 && custom_link.length() <= 12) {
				
				regex = "[a-zA-Z0-9_]{5,12}";
				pattern = Pattern.compile(regex);
				matcher = pattern.matcher(custom_link);
				
				if(matcher.matches()) {
					var dao = new LinkDAOFactory().factory();
					User user = (User) request.getSession(false).getAttribute("user");

					if(dao.findById(custom_link) == null) {
						dao.create(new Link(custom_link, full_link, LinkType.CUSTOM), user.getEmail());
						message = "Link Criado Com Sucesso!";
						
					} else {
						success = false;
						message = "Não foi Possível Inserir o Link.";
					}
				} else {
					success = false;
					message = "O Link Customizado Não Segue o Padrão.";
				}
			} else {
				success = false;
				message = "O Link Customizado Deve Ter De 5 a 12 Caracteres.";
			}
			
		} else {
			success = false;
			message = "O Link Completo Informado é Inválido.";
		}
		
		request.setAttribute("success", success);
		request.setAttribute("message", message);

		return "logged.do?action=custom-link-page";
	}
}
