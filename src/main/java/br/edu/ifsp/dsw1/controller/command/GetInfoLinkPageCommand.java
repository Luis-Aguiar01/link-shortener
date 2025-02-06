package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;
import java.util.List;

import br.edu.ifsp.dsw1.model.dao.access.AccessDAO;
import br.edu.ifsp.dsw1.model.dao.access.AccessDAOFactory;
import br.edu.ifsp.dsw1.model.dao.link.LinkDAO;
import br.edu.ifsp.dsw1.model.dao.link.LinkDAOFactory;
import br.edu.ifsp.dsw1.model.entity.Link;
import br.edu.ifsp.dsw1.model.entity.Access;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetInfoLinkPageCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		var short_link = request.getParameter("id");
		LinkDAO l_dao = new LinkDAOFactory().factory();
		AccessDAO a_dao = new AccessDAOFactory().factory();
		
		Link link = l_dao.findById(short_link);
		List<Access> list = a_dao.findByLink(link);
		link.setListAccess(list);
		
		if(link != null) {
			request.setAttribute("link", link);
			return "logged/link-details.jsp";
		} else {
			return "logged.do?action=my-links-page";
		}
	}

}
