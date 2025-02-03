package br.edu.ifsp.dsw1.model.entity;

import java.util.Objects;

public class Access {
	
	private int id;
	private String ip;
	private Link link;
	
	public Access() {}

	public Access(String ip, Link link) {
		this.ip = ip;
		this.link = link;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Access [id=" + id + ", ip=" + ip + ", link=" + link + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Access other = (Access) obj;
		return id == other.id;
	}
}
