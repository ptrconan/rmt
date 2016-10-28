package org.vpk.rmt.serviceproviders.buienradar.backend.datamodel;

public class Icoon {
	private String content;

	private String ID;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	@Override
	public String toString() {
		return "ClassPojo [content = " + content + ", ID = " + ID + "]";
	}
}
