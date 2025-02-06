package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.dao.access.AccessDAO;
import br.edu.ifsp.dsw1.model.dao.access.AccessDAOFactory;
import br.edu.ifsp.dsw1.model.dao.link.LinkDAO;
import br.edu.ifsp.dsw1.model.dao.link.LinkDAOFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetStatisticsPageCommand implements Command{
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		LinkDAO databaseLink = new LinkDAOFactory().factory();
		AccessDAO databaseAccess = new AccessDAOFactory().factory();
		
		Long countAccess = databaseAccess.count();
		Long countLink = databaseLink.count();
		
		request.setAttribute("countAccess", countAccess);
		request.setAttribute("countLink", countLink);
		
		return "statistics.jsp";
	}

}
