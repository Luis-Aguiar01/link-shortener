package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;
import java.util.Random;

import br.edu.ifsp.dsw1.model.dao.link.CheckLinkListener;
import br.edu.ifsp.dsw1.model.dao.link.LinkDAOFactory;
import br.edu.ifsp.dsw1.model.entity.Link;
import br.edu.ifsp.dsw1.model.entity.User;
import br.edu.ifsp.dsw1.model.enums.LinkType;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ShortenLinkCommand implements Command {
	private static final String CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_";
	private static final Random RANDOM = new Random();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var dao = new LinkDAOFactory().factory();
		var session = request.getSession(false);
		User user = null;
		
		if (session != null && session.getAttribute("user") != null) {
			user = (User) session.getAttribute("user");
		}
		
		String resultLink = null;
		String link = request.getParameter("link");
		int length = CheckLinkListener.getUrlSize();

		while (resultLink == null) {
			String generatedLink = generateRandomString(length);
			if (dao.findById(generatedLink) == null) { // Retorna se for único
				resultLink = generatedLink;
				if (user != null) {
					dao.create(new Link(resultLink, link, LinkType.RANDOM), user.getEmail());
				} else {
					dao.create(new Link(resultLink, link, LinkType.RANDOM), null);
				}
			}
		}
		
		request.setAttribute("result_link", resultLink);
		
		String view;
		if (user != null) {
			view = "/logged/index-logged.jsp";
		} else {
			view = "index.jsp";
		}

		return view;
	}

	private String generateRandomString(int length) {
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			sb.append(CHARSET.charAt(RANDOM.nextInt(CHARSET.length())));
		}
		return sb.toString();
	}
}
