package br.edu.ifsp.dsw1.model.entity;

import java.util.Objects;

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

	@Override
	public String toString() {
		return "Link [customLink=" + customLink + ", link=" + link + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customLink, link);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Link other = (Link) obj;
		return Objects.equals(customLink, other.customLink) && Objects.equals(link, other.link);
	}
}
