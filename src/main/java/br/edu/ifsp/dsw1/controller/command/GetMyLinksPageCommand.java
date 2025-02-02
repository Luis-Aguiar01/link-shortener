package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;
import java.util.List;

import br.edu.ifsp.dsw1.model.dao.link.LinkDAOFactory;
import br.edu.ifsp.dsw1.model.entity.Link;
import br.edu.ifsp.dsw1.model.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetMyLinksPageCommand implements Command {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		var userSession = request.getSession(false);
		var user = (User) userSession.getAttribute("user");
		
		var factoryDao = new LinkDAOFactory().factory();
		List<Link> listLinks = factoryDao.findyByUser(user);
		
		if (listLinks != null && !listLinks.isEmpty()) {
			userSession.setAttribute("listLinks", listLinks);
		}		
		return "/logged/my-links.jsp";
	}
}
