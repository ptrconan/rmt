package org.vpk.rmt.serviceproviders.buienradar.backend.datamodel;

public class Buienindex {
	private String waardepercentage;

	private String datum;

	public String getWaardepercentage() {
		return waardepercentage;
	}

	public void setWaardepercentage(String waardepercentage) {
		this.waardepercentage = waardepercentage;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	@Override
	public String toString() {
		return "ClassPojo [waardepercentage = " + waardepercentage + ", datum = " + datum + "]";
	}
}
