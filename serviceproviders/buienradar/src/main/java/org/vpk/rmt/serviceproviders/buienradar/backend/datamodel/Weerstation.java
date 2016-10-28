package org.vpk.rmt.serviceproviders.buienradar.backend.datamodel;

public class Weerstation {
	private String windsnelheidMS;

	private String windsnelheidBF;

	private String regenMMPU;

	private String lon;

	private String lonGraden;

	private String datum;

	private String url;

	private String luchtdruk;

	private String id;

	private String windrichting;

	private String luchtvochtigheid;

	private String zichtmeters;

	private String windstotenMS;

	private Icoonactueel icoonactueel;

	private String temperatuur10cm;

	private Stationnaam stationnaam;

	private String stationcode;

	private String temperatuurGC;

	private String lat;

	private String windrichtingGR;

	private String latGraden;

	public String getWindsnelheidMS() {
		return windsnelheidMS;
	}

	public void setWindsnelheidMS(String windsnelheidMS) {
		this.windsnelheidMS = windsnelheidMS;
	}

	public String getWindsnelheidBF() {
		return windsnelheidBF;
	}

	public void setWindsnelheidBF(String windsnelheidBF) {
		this.windsnelheidBF = windsnelheidBF;
	}

	public String getRegenMMPU() {
		return regenMMPU;
	}

	public void setRegenMMPU(String regenMMPU) {
		this.regenMMPU = regenMMPU;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getLonGraden() {
		return lonGraden;
	}

	public void setLonGraden(String lonGraden) {
		this.lonGraden = lonGraden;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLuchtdruk() {
		return luchtdruk;
	}

	public void setLuchtdruk(String luchtdruk) {
		this.luchtdruk = luchtdruk;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWindrichting() {
		return windrichting;
	}

	public void setWindrichting(String windrichting) {
		this.windrichting = windrichting;
	}

	public String getLuchtvochtigheid() {
		return luchtvochtigheid;
	}

	public void setLuchtvochtigheid(String luchtvochtigheid) {
		this.luchtvochtigheid = luchtvochtigheid;
	}

	public String getZichtmeters() {
		return zichtmeters;
	}

	public void setZichtmeters(String zichtmeters) {
		this.zichtmeters = zichtmeters;
	}

	public String getWindstotenMS() {
		return windstotenMS;
	}

	public void setWindstotenMS(String windstotenMS) {
		this.windstotenMS = windstotenMS;
	}

	public Icoonactueel getIcoonactueel() {
		return icoonactueel;
	}

	public void setIcoonactueel(Icoonactueel icoonactueel) {
		this.icoonactueel = icoonactueel;
	}

	public String getTemperatuur10cm() {
		return temperatuur10cm;
	}

	public void setTemperatuur10cm(String temperatuur10cm) {
		this.temperatuur10cm = temperatuur10cm;
	}

	public Stationnaam getStationnaam() {
		return stationnaam;
	}

	public void setStationnaam(Stationnaam stationnaam) {
		this.stationnaam = stationnaam;
	}

	public String getStationcode() {
		return stationcode;
	}

	public void setStationcode(String stationcode) {
		this.stationcode = stationcode;
	}

	public String getTemperatuurGC() {
		return temperatuurGC;
	}

	public void setTemperatuurGC(String temperatuurGC) {
		this.temperatuurGC = temperatuurGC;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getWindrichtingGR() {
		return windrichtingGR;
	}

	public void setWindrichtingGR(String windrichtingGR) {
		this.windrichtingGR = windrichtingGR;
	}

	public String getLatGraden() {
		return latGraden;
	}

	public void setLatGraden(String latGraden) {
		this.latGraden = latGraden;
	}

	@Override
	public String toString() {
		return "ClassPojo [windsnelheidMS = " + windsnelheidMS + ", windsnelheidBF = " + windsnelheidBF
				+ ", regenMMPU = " + regenMMPU + ", lon = " + lon + ", lonGraden = " + lonGraden + ", datum = " + datum
				+ ", url = " + url + ", luchtdruk = " + luchtdruk + ", id = " + id + ", windrichting = " + windrichting
				+ ", luchtvochtigheid = " + luchtvochtigheid + ", zichtmeters = " + zichtmeters + ", windstotenMS = "
				+ windstotenMS + ", icoonactueel = " + icoonactueel + ", temperatuur10cm = " + temperatuur10cm
				+ ", stationnaam = " + stationnaam + ", stationcode = " + stationcode + ", temperatuurGC = "
				+ temperatuurGC + ", lat = " + lat + ", windrichtingGR = " + windrichtingGR + ", latGraden = "
				+ latGraden + "]";
	}
}
