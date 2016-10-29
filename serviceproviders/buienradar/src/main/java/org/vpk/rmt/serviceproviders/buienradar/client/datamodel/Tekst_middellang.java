package org.vpk.rmt.serviceproviders.buienradar.client.datamodel;

public class Tekst_middellang {
	private String content;

	private String periode;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPeriode() {
		return periode;
	}

	public void setPeriode(String periode) {
		this.periode = periode;
	}

	@Override
	public String toString() {
		return "ClassPojo [content = " + content + ", periode = " + periode + "]";
	}
}
