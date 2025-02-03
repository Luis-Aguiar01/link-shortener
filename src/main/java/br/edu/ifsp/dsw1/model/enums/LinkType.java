package br.edu.ifsp.dsw1.model.enums;

public enum LinkType {

	RANDOM("random"), 
	CUSTOM("custom");
	
	private String name;

	private LinkType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
