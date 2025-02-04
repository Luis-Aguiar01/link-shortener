package br.edu.ifsp.dsw1.model.dao.access;

import br.edu.ifsp.dsw1.model.dao.link.LinkDAOFactory;

public class AccessDAOFactory {
	
private AccessDAOType accessType;
	
	public AccessDAOFactory() {
		this.accessType = AccessDAOType.DATABASE;
	}
	
	public AccessDAOFactory(AccessDAOType accessType) {
		this.accessType = accessType;
	}
	
	public AccessDAO factory() {
		switch (accessType) {
			case DATABASE: {
				return new AccessDAOImp();
			}
			default:
				throw new IllegalArgumentException("Tipo inválido.");
			}
	}
	
	public enum AccessDAOType{
		DATABASE
	}
}
