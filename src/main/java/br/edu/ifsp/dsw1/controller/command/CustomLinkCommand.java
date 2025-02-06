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

public class CustomLinkCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var dao = new LinkDAOFactory().factory();

		return "";
	}
}
