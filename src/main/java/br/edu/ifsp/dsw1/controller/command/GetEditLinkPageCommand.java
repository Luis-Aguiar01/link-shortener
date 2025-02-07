package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.dao.link.LinkDAOFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetEditLinkPageCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var short_link = request.getParameter("id");
		var linkDao = new LinkDAOFactory().factory();
		var link = linkDao.findById(short_link);
		
		if (link != null) {
			request.setAttribute("link", link);
			return "/logged/edit-link-form.jsp";
		} else {
			return "logged.do?action=my-links-page";
		}
	}

}
