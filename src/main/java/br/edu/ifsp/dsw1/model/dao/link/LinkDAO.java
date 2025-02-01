package br.edu.ifsp.dsw1.model.dao.link;

import br.edu.ifsp.dsw1.model.entity.Link;

public interface LinkDAO {
	
	public Link findyById();
	public Link findyByUser();
	public boolean create(Link link);

}
