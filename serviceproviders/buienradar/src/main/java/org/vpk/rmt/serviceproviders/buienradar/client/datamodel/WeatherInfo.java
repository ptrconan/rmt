package org.vpk.rmt.serviceproviders.buienradar.client.datamodel;

public class WeatherInfo {
	private Buienradarnl buienradarnl;

	public Buienradarnl getBuienradarnl() {
		return buienradarnl;
	}

	public void setBuienradarnl(Buienradarnl buienradarnl) {
		this.buienradarnl = buienradarnl;
	}

	@Override
	public String toString() {
		return "ClassPojo [buienradarnl = " + buienradarnl + "]";
	}
}
