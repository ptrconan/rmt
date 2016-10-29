package org.vpk.rmt.serviceproviders.buienradar.client.datamodel;

public class Buienradar {
	private String zononder;

	private String aantalonweer;

	private Icoonactueel icoonactueel;

	private String urlbackup;

	private String url;

	private String zonopkomst;

	private String aantalhagel;

	public String getZononder() {
		return zononder;
	}

	public void setZononder(String zononder) {
		this.zononder = zononder;
	}

	public String getAantalonweer() {
		return aantalonweer;
	}

	public void setAantalonweer(String aantalonweer) {
		this.aantalonweer = aantalonweer;
	}

	public Icoonactueel getIcoonactueel() {
		return icoonactueel;
	}

	public void setIcoonactueel(Icoonactueel icoonactueel) {
		this.icoonactueel = icoonactueel;
	}

	public String getUrlbackup() {
		return urlbackup;
	}

	public void setUrlbackup(String urlbackup) {
		this.urlbackup = urlbackup;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getZonopkomst() {
		return zonopkomst;
	}

	public void setZonopkomst(String zonopkomst) {
		this.zonopkomst = zonopkomst;
	}

	public String getAantalhagel() {
		return aantalhagel;
	}

	public void setAantalhagel(String aantalhagel) {
		this.aantalhagel = aantalhagel;
	}

	@Override
	public String toString() {
		return "ClassPojo [zononder = " + zononder + ", aantalonweer = " + aantalonweer + ", icoonactueel = "
				+ icoonactueel + ", urlbackup = " + urlbackup + ", url = " + url + ", zonopkomst = " + zonopkomst
				+ ", aantalhagel = " + aantalhagel + "]";
	}
}
