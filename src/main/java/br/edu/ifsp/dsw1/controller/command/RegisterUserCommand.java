package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.dao.user.UserDAOFactory;
import br.edu.ifsp.dsw1.model.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterUserCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		var name = request.getParameter("name");
		var email = request.getParameter("email");
		var passwd = request.getParameter("password");
		
		var dao = new UserDAOFactory().factory();
		var user = new User(name, email, passwd, false);
		var saved = dao.create(user);
		
		String mensagem;
		
		if (saved) {
			mensagem = "Usuário Cadastrado com Sucesso.";
		}else{
			mensagem = "Erro ao Cadastrar o Usuário.";
		}
		
		request.setAttribute("mensagem", mensagem);
		request.setAttribute("saved", saved);
		
		return "register-form.jsp";
	}

}
