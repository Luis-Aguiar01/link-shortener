package br.edu.ifsp.dsw1.controller;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = { "/disconnected.do", "/index.jsp", "/login-form.jsp", "/register-form.jsp", } )
public class LoggedFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        var httpRequest = (HttpServletRequest) request;
        var session = httpRequest.getSession(false);

        // Verificar se a URL tem o parâmetro "action" com valor "contacts-page" ou "questions-page"
        String action = httpRequest.getParameter("action");

        if (action != null && (action.equals("contact-page") || action.equals("questions-page"))) {
            // Permite a requisição para as páginas de contacts ou questions
            chain.doFilter(request, response);
        } else {
            // Se a sessão existir e não for uma das páginas permitidas, redireciona para index-logged.jsp
            if (session != null && session.getAttribute("user") != null) {
                var dispatcher = request.getRequestDispatcher("/logged.do?action=logged-page");
                dispatcher.forward(request, response);
            } else {
                // Se a sessão não existir, permite a requisição normalmente
                chain.doFilter(request, response);
            }
        }
    }

}
