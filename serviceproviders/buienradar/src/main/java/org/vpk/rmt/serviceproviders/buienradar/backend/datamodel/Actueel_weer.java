package org.vpk.rmt.serviceproviders.buienradar.backend.datamodel;

public class Actueel_weer {
	private Buienradar buienradar;

	private Weerstations weerstations;

	private Buienindex buienindex;

	public Buienradar getBuienradar() {
		return buienradar;
	}

	public void setBuienradar(Buienradar buienradar) {
		this.buienradar = buienradar;
	}

	public Weerstations getWeerstations() {
		return weerstations;
	}

	public void setWeerstations(Weerstations weerstations) {
		this.weerstations = weerstations;
	}

	public Buienindex getBuienindex() {
		return buienindex;
	}

	public void setBuienindex(Buienindex buienindex) {
		this.buienindex = buienindex;
	}

	@Override
	public String toString() {
		return "ClassPojo [buienradar = " + buienradar + ", weerstations = " + weerstations + ", buienindex = "
				+ buienindex + "]";
	}
}
