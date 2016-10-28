package org.vpk.rmt.serviceproviders.buienradar.backend.datamodel;

public class Icoonactueel {
	private String content;

	private String ID;

	private String zin;

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

	public String getZin() {
		return zin;
	}

	public void setZin(String zin) {
		this.zin = zin;
	}

	@Override
	public String toString() {
		return "ClassPojo [content = " + content + ", ID = " + ID + ", zin = " + zin + "]";
	}
}
