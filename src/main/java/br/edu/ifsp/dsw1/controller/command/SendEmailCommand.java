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

public class SendEmailCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		
		String username = System.getenv("e_linkshortener");
		String password = System.getenv("p_linkshortener");

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

		String view;
		try {
			MimeMessage m = new MimeMessage(session);
			m.setFrom(new InternetAddress(username));
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(username));

			m.setSubject(subject);
			String content = "Nome: " + name + "\n\nEmail: " + email + "\n\nMensagem: " + message;
			m.setText(content, "utf-8");

			Transport.send(m);
			view = "contact.jsp?success=true";
		} catch (MessagingException e) {
			view = "contact.jsp?success=false";
		}
		
		return view;
	}
}
