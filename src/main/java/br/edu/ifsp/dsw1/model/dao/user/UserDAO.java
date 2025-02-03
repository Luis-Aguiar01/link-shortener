package br.edu.ifsp.dsw1.model.dao.user;

import br.edu.ifsp.dsw1.model.entity.User;

public interface UserDAO {
	
	User findByEmail(String email);
	
	boolean create(User user);

}
