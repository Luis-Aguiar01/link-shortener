package br.edu.ifsp.dsw1.model.dao.user;

import br.edu.ifsp.dsw1.model.entity.User;

public interface UserDAO {
	
	public User findByEmail(String email);
	public boolean create(User user);

}
