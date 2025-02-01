package br.edu.ifsp.dsw1.model.entity;

public class Link {
	private String customLink;
	private String link;
	
	public Link() {}

	public Link(String customLink, String link) {
		this.customLink = customLink;
		this.link = link;
	}
	
	public String getCustomLink() {
		return customLink;
	}
	
	public void setCustomLink(String customLink) {
		this.customLink = customLink;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
}
