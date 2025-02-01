package br.edu.ifsp.dsw1.model.dao.link;

import java.util.List;

import br.edu.ifsp.dsw1.model.entity.Link;

public interface LinkDAO {
	
	public boolean create(Link link);
	public boolean delete(Link link);
	public boolean update(String link_curto, Link link);
	public Link findyById();
	public List<Link> findyByUser();
	
}
