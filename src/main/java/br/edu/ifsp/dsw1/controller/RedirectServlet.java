package br.edu.ifsp.dsw1.controller;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.dao.access.AccessDAOFactory;
import br.edu.ifsp.dsw1.model.dao.link.LinkDAOFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Pega a URL da aplicação
    	String path = request.getRequestURI();
	    String contextPath = request.getContextPath() + "/";
	    String shortCode = path.replaceFirst(contextPath, "");
	    var linkDao = new LinkDAOFactory().factory();
		
	    // Pega o link associado aquele link curto
	    String redirectTo;
	    var link = linkDao.findById(shortCode);
		
	    // Caso o link curto esteja associado a um link
	    // cadastra um novo acesso e pega o link longo para redirecionamento.
	    if (link != null) {
			var ip = request.getRemoteAddr();
			var accessDao = new AccessDAOFactory().factory();
			accessDao.create(link, ip);
			redirectTo = link.getFullLink();
		} else {
			redirectTo = "error-page.jsp";
		}
		
		response.sendRedirect(redirectTo);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
