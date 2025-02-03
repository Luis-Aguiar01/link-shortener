package br.edu.ifsp.dsw1.model.dao.link;

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
				return new LinkDAOImp();
			}
			default:
				throw new IllegalArgumentException("Tipo inválido.");
			}
	}
	
	public enum LinkDAOType{
		DATABASE
	}
}
