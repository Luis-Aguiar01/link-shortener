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
		
		if(shortLink.length() >= 5 && shortLink.length() <= 12) {
			Link link = new Link();
			link.setFullLink(fullLink);
			link.setShortLink(shortLink);
			
			LinkDAO dao = new LinkDAOFactory().factory();
			dao.update(id, link);
		}
		
		return "logged.do?action=my-links-page";	
	}

}
