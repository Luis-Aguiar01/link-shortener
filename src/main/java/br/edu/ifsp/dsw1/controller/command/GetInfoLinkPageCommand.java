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
		LinkDAO linkDao = new LinkDAOFactory().factory();
		AccessDAO accessDao = new AccessDAOFactory().factory();
		
		Link link = linkDao.findById(short_link);
		
		if(link != null) {
			List<Access> list = accessDao.findByLink(link);
			link.setListAccess(list);
			request.setAttribute("link", link);
			return "logged/link-details.jsp";
		} else {
			request.setAttribute("success", false);
			request.setAttribute("message", "Não Foi Possível Encontrar o Link Selecionado.");
			return "logged.do?action=my-links-page";
		}
	}

}
