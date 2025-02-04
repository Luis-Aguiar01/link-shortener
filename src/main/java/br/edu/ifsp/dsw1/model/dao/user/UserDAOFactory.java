package br.edu.ifsp.dsw1.model.dao.user;

import br.edu.ifsp.dsw1.model.dao.link.LinkDAOFactory;

public class UserDAOFactory {
	
	private UserDAOType userType;
	
	public UserDAOFactory() {
		this.userType = UserDAOType.DATABASE;
	}
	
	public UserDAOFactory(UserDAOType usertype) {
		this.userType = usertype;
	}
	
	public UserDAO factory() {
		switch (userType) {
			case DATABASE: {
				return new UserDAOImp(new LinkDAOFactory().factory());
			}
			default:
				throw new IllegalArgumentException("Tipo inválido.");
			}
	}
	
	public enum UserDAOType{
		DATABASE
	}
	
}
