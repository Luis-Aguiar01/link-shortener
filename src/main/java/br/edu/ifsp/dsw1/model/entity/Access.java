package br.edu.ifsp.dsw1.model.entity;

import java.util.Objects;

public class Access {
	private int id;
	private String ip;
	
	public Access() {}

	public Access(String ip, int id) {
		this.ip = ip;
		this.id = id;
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

	@Override
	public String toString() {
		return "Access [id=" + id + ", ip=" + ip  + "]";
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
