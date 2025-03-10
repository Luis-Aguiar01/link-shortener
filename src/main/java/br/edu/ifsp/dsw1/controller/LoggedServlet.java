package br.edu.ifsp.dsw1.controller;

import java.io.IOException;

import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.controller.command.DeleteLinkCommand;
import br.edu.ifsp.dsw1.controller.command.EditLinkCommand;
import br.edu.ifsp.dsw1.controller.command.GetEditLinkPageCommand;
import br.edu.ifsp.dsw1.controller.command.ErrorCommand;
import br.edu.ifsp.dsw1.controller.command.GetCustomLinkPageCommand;
import br.edu.ifsp.dsw1.controller.command.CustomLinkCommand;
import br.edu.ifsp.dsw1.controller.command.GetInfoLinkPageCommand;
import br.edu.ifsp.dsw1.controller.command.GetLoggedPageCommand;
import br.edu.ifsp.dsw1.controller.command.GetMyLinksPageCommand;
import br.edu.ifsp.dsw1.controller.command.LogoutCommand;
import br.edu.ifsp.dsw1.controller.command.ShortenLinkCommand;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*Servlet responsável por processar as requisições feitas pelos usuários logados. 
 * Apenas pessoas cadastradadas no site poderão ter acesso a essas funcionalidades.
 * Essas funcionalides são: logout, visualização dos links, customizar, atualização, deletar e visualizar informações de links.*/
@WebServlet("/logged.do")
public class LoggedServlet extends HttpServlet {
	private final static long serialVersionUID = 1L;
	
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var action = request.getParameter("action");
		Command command = null;
		
		if ("logged-page".equals(action)) {
			command = new GetLoggedPageCommand();
		} else if ("logout".equals(action)) {
			command = new LogoutCommand();
		} else if ("my-links-page".equals(action)) {
			command = new GetMyLinksPageCommand();
		} else if ("custom-link-page".equals(action)) {
			command = new GetCustomLinkPageCommand();
		} else if ("shorten-link".equals(action)) {
			command = new ShortenLinkCommand();
		} else if ("custom-link".equals(action)) {
			command = new CustomLinkCommand();
		} else if ("delete-link".equals(action)) {
			command = new DeleteLinkCommand();
		} else if ("edit-link-page".equals(action)) {
			command = new GetEditLinkPageCommand();
		} else if ("edit-link".equals(action)) {
			command = new EditLinkCommand();
		}else if ("info-link".equals(action)) {
			command = new GetInfoLinkPageCommand();
		} else {
			command = new ErrorCommand();
		}
		
		var view = command.execute(request, response);
		var dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
}
