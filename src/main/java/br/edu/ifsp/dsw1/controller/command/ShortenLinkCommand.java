package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;
import java.util.Random;

import br.edu.ifsp.dsw1.model.dao.link.CheckLinkListener;
import br.edu.ifsp.dsw1.model.dao.link.LinkDAOFactory;
import br.edu.ifsp.dsw1.model.entity.Link;
import br.edu.ifsp.dsw1.model.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ShortenLinkCommand implements Command {
	private static final String CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_";
	private static final Random RANDOM = new Random();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var dao = new LinkDAOFactory().factory();
		String resultLink = null;
		String link = request.getParameter("link");
		int length = CheckLinkListener.getUrlSize();

		while (resultLink == null) {
			String generatedLink = generateRandomString(length);
			if (dao.findyById(generatedLink) == null) { // Retorna se for único
				resultLink = generatedLink;
				dao.create(new Link(resultLink, link), null);
			}
		}
		request.setAttribute("result_link", resultLink);
		
		var session = request.getSession(false);
		
		String view;
		if(session != null) {
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
