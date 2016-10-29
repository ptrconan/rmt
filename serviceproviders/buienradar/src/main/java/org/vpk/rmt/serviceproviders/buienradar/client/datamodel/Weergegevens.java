package org.vpk.rmt.serviceproviders.buienradar.client.datamodel;

public class Weergegevens {
	private Actueel_weer actueel_weer;

	private String gebruik;

	private String titel;

	private String link;

	private Verwachting_meerdaags verwachting_meerdaags;

	private Image image;

	private String language;

	private String copyright;

	private String omschrijving;

	private Verwachting_vandaag verwachting_vandaag;

	public Actueel_weer getActueel_weer() {
		return actueel_weer;
	}

	public void setActueel_weer(Actueel_weer actueel_weer) {
		this.actueel_weer = actueel_weer;
	}

	public String getGebruik() {
		return gebruik;
	}

	public void setGebruik(String gebruik) {
		this.gebruik = gebruik;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Verwachting_meerdaags getVerwachting_meerdaags() {
		return verwachting_meerdaags;
	}

	public void setVerwachting_meerdaags(Verwachting_meerdaags verwachting_meerdaags) {
		this.verwachting_meerdaags = verwachting_meerdaags;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getOmschrijving() {
		return omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	public Verwachting_vandaag getVerwachting_vandaag() {
		return verwachting_vandaag;
	}

	public void setVerwachting_vandaag(Verwachting_vandaag verwachting_vandaag) {
		this.verwachting_vandaag = verwachting_vandaag;
	}

	@Override
	public String toString() {
		return "ClassPojo [actueel_weer = " + actueel_weer + ", gebruik = " + gebruik + ", titel = " + titel
				+ ", link = " + link + ", verwachting_meerdaags = " + verwachting_meerdaags + ", image = " + image
				+ ", language = " + language + ", copyright = " + copyright + ", omschrijving = " + omschrijving
				+ ", verwachting_vandaag = " + verwachting_vandaag + "]";
	}
}