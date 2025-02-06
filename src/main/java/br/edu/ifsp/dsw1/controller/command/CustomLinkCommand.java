package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.dao.link.LinkDAOFactory;
import br.edu.ifsp.dsw1.model.entity.Link;
import br.edu.ifsp.dsw1.model.entity.User;
import br.edu.ifsp.dsw1.model.enums.LinkType;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomLinkCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		var custom_link = request.getParameter("custom-link");
		var full_link = request.getParameter("full-link");
		var success = true;
		var message = "";
		
		if(custom_link.length() >= 5 && custom_link.length() <= 12) {
			var dao = new LinkDAOFactory().factory();
			User user = (User) request.getSession(false).getAttribute("user");

			if(dao.findById(custom_link) == null) {
				dao.create(new Link(custom_link, full_link, LinkType.CUSTOM), user.getEmail());
				message = "Link Criado Com Sucesso!";
				
			} else {
				success = false;
				message = "Não foi Possível Inserir o Link.";
			}
		} else {
			success = false;
			message = "O Link Customizado Deve Ter De 5 a 12 Caracteres.";
		}
		
		request.setAttribute("success", success);
		request.setAttribute("message", message);

		return "logged.do?action=custom-link-page";
	}
}
