package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.edu.ifsp.dsw1.model.dao.link.LinkDAO;
import br.edu.ifsp.dsw1.model.dao.link.LinkDAOFactory;
import br.edu.ifsp.dsw1.model.entity.Link;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditLinkCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var id = request.getParameter("id");
		var shortLink = request.getParameter("short-link");
		var fullLink = request.getParameter("full-link");
		LinkDAO dao = new LinkDAOFactory().factory();
		var success = true;
		var message = "";
		
		String regex = "^(https?|ftp):\\/\\/[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}.*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(fullLink);
		
		if (matcher.matches()) {
			if (shortLink.length() >= 5 && shortLink.length() <= 12) {
				regex = "[a-zA-Z0-9_]{5,12}";
				pattern = Pattern.compile(regex);
				matcher = pattern.matcher(shortLink);
				
				if (matcher.matches()) {
					Link link = new Link();
					link.setFullLink(fullLink);
					link.setShortLink(shortLink);
					
					if (dao.update(id, link)) {
						message = "Link editado com sucesso!";
					} else {
						success = false;
						message = "Não foi possível editar o link.";
					}
				}
				else {
					success = false;
					message = "O link customizado não segue o padrão.";
				}	
			} else {
				success = false;
				message = "O link curto deve ter de 5 a 12 caracteres.";
			}
			
		} else {
			success = false;
			message = "O link completo informado é inválido.";
		}
		
		request.setAttribute("success", success);
		request.setAttribute("message", message);
			
		if(success) {
			return "logged.do?action=my-links-page";
		} else {
			request.setAttribute("link", dao.findById(id)); // Mandar Link Novamente Para Pré-Preencher o Formulário Novamente.
			return "logged.do?action=edit-link-page";	
		}
	}

}
