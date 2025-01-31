package br.edu.ifsp.dsw1.controller;

import java.io.IOException;

import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.controller.command.ErrorCommand;
import br.edu.ifsp.dsw1.controller.command.GetLoginPageCommand;
import br.edu.ifsp.dsw1.controller.command.GetRegisterPageCommand;
import br.edu.ifsp.dsw1.controller.command.HomeCommand;
import br.edu.ifsp.dsw1.controller.command.RegisterUserCommand;
import br.edu.ifsp.dsw1.controller.command.LoginCommand;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/disconnected.do")
public class DisconnectedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var action = request.getParameter("action");
		Command command = null;
		
		if ("home".equals(action)) {
			command = new HomeCommand();
		} else if ("login-page".equals(action)) {
			command = new GetLoginPageCommand();
		} else if ("register-page".equals(action)) {
			command = new GetRegisterPageCommand();
		} else if ("register-user".equals(action)) {
			command = new RegisterUserCommand();
		} else if ("login-user".equals(action)) {
			command = new LoginCommand();
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
