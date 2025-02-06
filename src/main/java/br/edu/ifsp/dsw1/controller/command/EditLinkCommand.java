package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.dao.link.LinkDAO;
import br.edu.ifsp.dsw1.model.dao.link.LinkDAOFactory;
import br.edu.ifsp.dsw1.model.entity.Link;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditLinkCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		var id = request.getParameter("id");
		var shortLink = request.getParameter("short-link");
		var fullLink = request.getParameter("full-link");
		LinkDAO dao = new LinkDAOFactory().factory();
		var success = true;
		var message = "";
		
		if(shortLink.length() >= 5 && shortLink.length() <= 12) {
			Link link = new Link();
			link.setFullLink(fullLink);
			link.setShortLink(shortLink);
			
			if(dao.update(id, link)) {
				message = "Link Editado Com Sucesso!";
				
			} else {
				success = false;
				message = "Não Foi Possível Editar o Link.";
			}
		} else {
			success = false;
			message = "O Link Curto Deve Ter De 5 a 12 Caracteres.";
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
