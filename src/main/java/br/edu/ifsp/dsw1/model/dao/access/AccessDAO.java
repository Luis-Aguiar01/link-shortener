package br.edu.ifsp.dsw1.model.dao.access;

import java.util.List;

import br.edu.ifsp.dsw1.model.dao.link.LinkDAO;
import br.edu.ifsp.dsw1.model.entity.Access;
import br.edu.ifsp.dsw1.model.entity.Link;

public interface AccessDAO {
	
	public boolean create(Link link, String ip);
	public List<Access> findByLink(Link link, LinkDAO databaseLink);

}
