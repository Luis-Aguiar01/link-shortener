package br.edu.ifsp.dsw1.model.dao.link;

import java.util.List;

import br.edu.ifsp.dsw1.model.entity.Link;
import br.edu.ifsp.dsw1.model.entity.User;

public interface LinkDAO {
	
	public boolean create(Link link, String email);
	public boolean delete(Link link);
	public boolean update(String link_curto, Link link);
	public long count();
	public Link findyById(String linkCustom);
	public List<Link> findyByUser(User user);
	
}
