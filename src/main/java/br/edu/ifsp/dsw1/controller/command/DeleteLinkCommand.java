package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;
import java.util.List;

import br.edu.ifsp.dsw1.model.entity.Link;
import br.edu.ifsp.dsw1.model.entity.User;
import br.edu.ifsp.dsw1.model.dao.link.LinkDAO;
import br.edu.ifsp.dsw1.model.dao.link.LinkDAOFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteLinkCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		var short_link = request.getParameter("id");
		LinkDAO dao = new LinkDAOFactory().factory();
		dao.delete(short_link);
		
		User user = (User) request.getSession(false).getAttribute("user");
		List<Link> lista_nova = dao.findByUser(user);
		user.setLinks(lista_nova);
		request.getSession(false).setAttribute("user", user);
		
		return "logged.do?action=my-links-page";
	}

}
