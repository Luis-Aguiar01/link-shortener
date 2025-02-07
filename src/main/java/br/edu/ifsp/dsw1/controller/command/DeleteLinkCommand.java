package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.dao.link.LinkDAOFactory;
import br.edu.ifsp.dsw1.model.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteLinkCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var short_link = request.getParameter("id");
		var dao = new LinkDAOFactory().factory();
		var success = dao.delete(short_link);
		var message = "";
		
		if (success) {
			var user = (User) request.getSession(false).getAttribute("user");
			var lista_nova = dao.findByUser(user);
			user.setLinks(lista_nova);
			request.getSession(false).setAttribute("user", user);
			message = "Link deletado com sucesso!";
		} else {
			message = "Não foi possível deletar o link selecionado.";
		}
		
		request.setAttribute("success", success);
		request.setAttribute("message", message);
		
		return "logged.do?action=my-links-page";
	}

}
