package br.edu.ifsp.dsw1.model.dao.link;

import br.edu.ifsp.dsw1.model.dao.access.AccessDAOFactory;
import br.edu.ifsp.dsw1.model.dao.access.AccessDAOImp;

public class LinkDAOFactory {
	private LinkDAOType linkType;
	
	public LinkDAOFactory() {
		this.linkType = LinkDAOType.DATABASE;
	}
	
	public LinkDAOFactory(LinkDAOType linkType) {
		this.linkType = linkType;
	}
	
	public LinkDAO factory() {
		switch (linkType) {
			case DATABASE: {
				return new LinkDAOImp(new AccessDAOFactory().factory());
			}
			default:
				throw new IllegalArgumentException("Tipo inválido.");
			}
	}
	
	public enum LinkDAOType{
		DATABASE
	}
}
