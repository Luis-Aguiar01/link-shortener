package br.edu.ifsp.dsw1.model.entity;

import java.util.Objects;

import br.edu.ifsp.dsw1.model.enums.LinkType;

public class Link {
	private String shortLink;
	private String fullLink;
	private LinkType type;
	
	public Link() {}
	
	public Link(String shortLink, String fullLink, LinkType type) {
		super();
		this.shortLink = shortLink;
		this.fullLink = fullLink;
		this.type = type;
	}

	public String getShortLink() {
		return shortLink;
	}

	public void setShortLink(String shortLink) {
		this.shortLink = shortLink;
	}

	public String getFullLink() {
		return fullLink;
	}

	public void setFullLink(String fullLink) {
		this.fullLink = fullLink;
	}
	
	public LinkType getType() {
		return type;
	}

	public void setType(LinkType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Link [shortLink=" + shortLink + ", fullLink=" + fullLink + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(shortLink);
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
		return Objects.equals(shortLink, other.shortLink);
	}
}
