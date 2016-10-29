package org.vpk.rmt.serviceproviders.buienradar.client.datamodel;

public class Stationnaam {
	private String content;

	private String regio;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegio() {
		return regio;
	}

	public void setRegio(String regio) {
		this.regio = regio;
	}

	@Override
	public String toString() {
		return "ClassPojo [content = " + content + ", regio = " + regio + "]";
	}
}
