package br.edu.ifsp.dsw1.model.dao.access;

import java.util.List;

import br.edu.ifsp.dsw1.model.entity.Access;
import br.edu.ifsp.dsw1.model.entity.Link;

public interface AccessDAO {
	
	boolean create(Link link, String ip);
	
	List<Access> findByLink(Link link);

}
