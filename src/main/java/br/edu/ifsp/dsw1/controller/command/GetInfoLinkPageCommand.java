package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;
import java.util.List;

import br.edu.ifsp.dsw1.model.dao.access.AccessDAOFactory;
import br.edu.ifsp.dsw1.model.dao.link.LinkDAOFactory;
import br.edu.ifsp.dsw1.model.entity.Access;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetInfoLinkPageCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Command que a partir do id do link salvo na request, retorna uma lista com todos os acessos atrelados a ele.
		 * Caso o usuário tenha o link salvo e atrelado aos dados dele, o sistema direciona para a página link-details, exibindo essas informações.
		 * Caso não, o sistema retorna a página my-links-page e informa ao usuário que não foi possível encontrar o link selecionado.*/
		var short_link = request.getParameter("id");
		var linkDao = new LinkDAOFactory().factory();
		var accessDao = new AccessDAOFactory().factory();
		
		var link = linkDao.findById(short_link);
		
		if (link != null) {
			List<Access> list = accessDao.findByLink(link);
			link.setListAccess(list);
			request.setAttribute("link", link);
			return "logged/link-details.jsp";
		} else {
			request.setAttribute("success", false);
			request.setAttribute("message", "Não foi possível encontrar o link selecionado.");
			return "logged.do?action=my-links-page";
		}
	}
}
