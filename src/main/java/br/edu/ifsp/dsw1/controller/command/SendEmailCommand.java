package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
	Nós queriamos encontrar uma forma de enviar emails pelo Java, que não fosse o mailto do formulário,
	porque isso apenas abre o aplicativo de envio de email do computador, queriamos algo mais automaticado.
	Pesquisando, encontramos essa API do Java, para envio dos emails, junto com explicações de como 
	poderiamos usá-la para enviar os emails. Deixamos o email no código, por ser mais fácil de testar.
	OBS: O método retorna null porque a requisição é feita por AJAX, ou seja, não vai retornar nada.
*/

public class SendEmailCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		
		String username = "linkshortener.dsw@gmail.com";
		String password = "jtac gnjo ryrp dzym";

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication(username, password);
		    }
		});

		try {
			MimeMessage m = new MimeMessage(session);
			m.setFrom(new InternetAddress(username));
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(username));

			m.setSubject(subject);
			String content = "Nome: " + name + "\n\nEmail: " + email + "\n\nMensagem: " + message;
			m.setText(content, "utf-8");

			Transport.send(m);
			response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        response.getWriter().write("{\"success\": true}");
		
		} catch (MessagingException e) {
			response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        response.getWriter().write("{\"success\": false}");
		}
		
		return null;
	}
}
