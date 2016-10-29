package org.vpk.rmt.serviceproviders.buienradar.client.datamodel;

public class Verwachting_vandaag {
	private String samenvatting;

	private String tijdweerbericht;

	private String formattedtekst;

	private String titel;

	private String tekst;

	private String urlbackup;

	private String url;

	public String getSamenvatting() {
		return samenvatting;
	}

	public void setSamenvatting(String samenvatting) {
		this.samenvatting = samenvatting;
	}

	public String getTijdweerbericht() {
		return tijdweerbericht;
	}

	public void setTijdweerbericht(String tijdweerbericht) {
		this.tijdweerbericht = tijdweerbericht;
	}

	public String getFormattedtekst() {
		return formattedtekst;
	}

	public void setFormattedtekst(String formattedtekst) {
		this.formattedtekst = formattedtekst;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getTekst() {
		return tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
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

	@Override
	public String toString() {
		return "ClassPojo [samenvatting = " + samenvatting + ", tijdweerbericht = " + tijdweerbericht
				+ ", formattedtekst = " + formattedtekst + ", titel = " + titel + ", tekst = " + tekst
				+ ", urlbackup = " + urlbackup + ", url = " + url + "]";
	}
}
