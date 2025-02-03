package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.dao.link.LinkDAOFactory;
import br.edu.ifsp.dsw1.model.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetMyLinksPageCommand implements Command {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var userSession = request.getSession(false);
		var factoryDao = new LinkDAOFactory().factory();
		
		if (userSession != null && userSession.getAttribute("user") != null) {
			var user = (User) userSession.getAttribute("user");
			var links = factoryDao.findyByUser(user);
			userSession.setAttribute("links", links);
		}
		
		return "/logged/my-links.jsp";
	}
}
