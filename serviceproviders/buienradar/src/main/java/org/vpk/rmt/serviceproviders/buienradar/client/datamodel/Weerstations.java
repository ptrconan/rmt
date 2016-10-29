package org.vpk.rmt.serviceproviders.buienradar.client.datamodel;

public class Weerstations {
	private Weerstation[] weerstation;

	public Weerstation[] getWeerstation() {
		return weerstation;
	}

	public void setWeerstation(Weerstation[] weerstation) {
		this.weerstation = weerstation;
	}

	@Override
	public String toString() {
		return "ClassPojo [weerstation = " + weerstation + "]";
	}
}
