package br.edu.ifsp.dsw1.model.entity;

public class Access {
	private String ip;
	private Link link;
	
	public Access() {
		super();
	}

	public Access(String ip, Link link) {
		super();
		this.ip = ip;
		this.link = link;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Link getLink() {
		return link;
	}

	public void setLink(Link link) {
		this.link = link;
	}
}
