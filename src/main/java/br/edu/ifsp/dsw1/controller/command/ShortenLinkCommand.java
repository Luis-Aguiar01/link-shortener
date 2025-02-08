package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		// Primeiro verifica na sessão se o link foi criado por um usuário logado
		// ou deslogado.
		var linkDao = new LinkDAOFactory().factory();
		var session = request.getSession(false);
		User user = null;
		
		if (session != null && session.getAttribute("user") != null) {
			user = (User) session.getAttribute("user");
		}
		
		// Pega as informações necessárias
		String resultLink = null;
		String link = request.getParameter("link");
		int length = CheckLinkListener.getUrlSize();
		
		// Regex para valiar o link longo
		String regex = "^(https?|ftp):\\/\\/[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}.*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(link);
		
		if (matcher.matches()) {
			// Continua gerando até gerar um link curto ainda não cadastrado
			while (resultLink == null) {
				String generatedLink = generateRandomString(length);
				if (linkDao.findById(generatedLink) == null) { // Retorna nulo se não existe
					resultLink = generatedLink;
					// Cadastra para o usuário ou para o sistema.
					if (user != null) {
						linkDao.create(new Link(resultLink, link, LinkType.RANDOM), user.getEmail());
					} else {
						linkDao.create(new Link(resultLink, link, LinkType.RANDOM), null);
					}
				}
			}
			request.setAttribute("result_link", resultLink);
		} else {
			request.setAttribute("message", "O link completo informado é inválido.");
		}
		
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
