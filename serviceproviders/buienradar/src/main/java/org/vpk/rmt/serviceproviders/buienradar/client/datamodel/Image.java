package org.vpk.rmt.serviceproviders.buienradar.client.datamodel;

public class Image {
	private String height;

	private String titel;

	private String link;

	private String width;

	private String url;

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "ClassPojo [height = " + height + ", titel = " + titel + ", link = " + link + ", width = " + width
				+ ", url = " + url + "]";
	}
}
