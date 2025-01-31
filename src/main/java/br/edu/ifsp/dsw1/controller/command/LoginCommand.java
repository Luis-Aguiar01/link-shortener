package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.dao.user.UserDAOFactory;
import br.edu.ifsp.dsw1.model.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var email = request.getParameter("email");
		var passwd = request.getParameter("password");
		
		var dao = new UserDAOFactory().factory();
		var user = dao.findByEmail(email);
		var autorized = User.authenticate(user, email, passwd);

		String view;
		
		if (autorized) {
			var session = request.getSession(true);
			session.setAttribute("user", user);
			view = "logged.do?action=logged-page";
		} else {
			request.setAttribute("mensagem", "Usuário ou senha inválido.");
			view = "disconnected.do?action=login-page";
		}
		
		return view;
	}

}
