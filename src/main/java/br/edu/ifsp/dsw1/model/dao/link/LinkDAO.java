package br.edu.ifsp.dsw1.model.dao.link;

import java.util.List;

import br.edu.ifsp.dsw1.model.entity.Link;
import br.edu.ifsp.dsw1.model.entity.User;

public interface LinkDAO {
	
	boolean create(Link link, String email);
	
	boolean delete(Link link);
	
	boolean update(String shortLink, Link link);
	
	long count();
	
	Link findyById(String shortLink);
	
	List<Link> findyByUser(User user);
	
}
