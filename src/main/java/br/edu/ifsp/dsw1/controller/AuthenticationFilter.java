package br.edu.ifsp.dsw1.controller;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = { "/logged.do", "/logged/*" } )
public class AuthenticationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		chain.doFilter(request, response);
//		var httpRequest = (HttpServletRequest) request;
//		var session = httpRequest.getSession(false);
//		
//		if (session != null && session.getAttribute("user") != null) {
//			chain.doFilter(request, response);
//		} else {
//			var dispatcher = request.getRequestDispatcher("/disconnected.do?action=home");
//			dispatcher.forward(request, response);
//		}
	}

}
