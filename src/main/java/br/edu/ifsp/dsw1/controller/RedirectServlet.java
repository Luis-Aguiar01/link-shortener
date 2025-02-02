package br.edu.ifsp.dsw1.controller;

import java.io.IOException;

import br.edu.ifsp.dsw1.controller.command.ErrorCommand;
import br.edu.ifsp.dsw1.model.dao.link.LinkDAOFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRequestURI();
	    String contextPath = request.getContextPath() + "/";
	    String shortCode = path.replaceFirst(contextPath, "");
	    var dao = new LinkDAOFactory().factory();
		
	    String link;
		if (dao.findyById(shortCode) != null) {
			link = (dao.findyById(shortCode)).getLink();
		} else {
			link = new ErrorCommand().execute(request, response);
		}
		
		response.sendRedirect(link);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
