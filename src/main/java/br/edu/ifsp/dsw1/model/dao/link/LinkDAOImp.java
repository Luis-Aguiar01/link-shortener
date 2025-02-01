package br.edu.ifsp.dsw1.model.dao.link;

import br.edu.ifsp.dsw1.model.entity.Link;

public class LinkDAOImp implements LinkDAO{
	
	private static final String INSERT_LINK_SQL = "INSERT INTO link (link_curto, link_original, user) VALUES (?,?,?)";
	private static final String DELETE_LINK_SQL = "DELETE FROM link WHERE link_curto = ?";
	private static final String UPDATE_LINK_SQL = "UPDATE link SET link_curto = ? WHERE link_curto = ?";
	private static final String FIND_BY_ID_SQL = "SELECT link_curto, link_original FROM link WHERE link_curto = ?";
	private static final String FIND_BY_USER_SQL = "SELECT link_curto, link_original FROM link WHERE user = ?";

	@Override
	public boolean create(Link link) {
		return false;
	}
	
	@Override
	public boolean delete(Link link) {
		return false;
	}
	
	@Override
	public boolean update(Link link) {
		return false;
	}

	@Override
	public Link findyById() {
		return null;
	}

	@Override
	public Link findyByUser() {
		return null;
	}
}
