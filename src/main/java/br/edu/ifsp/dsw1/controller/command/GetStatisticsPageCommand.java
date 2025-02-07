package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.dao.access.AccessDAOFactory;
import br.edu.ifsp.dsw1.model.dao.link.LinkDAOFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetStatisticsPageCommand implements Command{
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*Método que a partir de uma instância dos bancos do Link e do Acesso consegue contabilizar o
		 *total de acesso e de links customizados no sistema e exibi-los na página de estatísticas.*/
		
		var linkDao = new LinkDAOFactory().factory();
		var accessDao = new AccessDAOFactory().factory();
		
		var countAccess = accessDao.count();
		var countLink = linkDao.count();
		
		request.setAttribute("countAccess", countAccess);
		request.setAttribute("countLink", countLink);
		
		return "statistics.jsp";
	}
}
