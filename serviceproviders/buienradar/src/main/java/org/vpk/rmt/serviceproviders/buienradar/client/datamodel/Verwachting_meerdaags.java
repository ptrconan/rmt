package org.vpk.rmt.serviceproviders.buienradar.client.datamodel;

public class Verwachting_meerdaags {
	private Tekst_lang tekst_lang;

	private Dag_plus5 dag_plus5;

	private Dag_plus4 dag_plus4;

	private Dag_plus3 dag_plus3;

	private Dag_plus2 dag_plus2;

	private Dag_plus1 dag_plus1;

	private String urlbackup;

	private Tekst_middellang tekst_middellang;

	private String url;

	public Tekst_lang getTekst_lang() {
		return tekst_lang;
	}

	public void setTekst_lang(Tekst_lang tekst_lang) {
		this.tekst_lang = tekst_lang;
	}

	public Dag_plus5 getDag_plus5 ()
    {
        return dag_plus5;
    }

	public void setDag_plus5 (Dag_plus5 dag_plus5)
    {
        this.dag_plus5 = dag_plus5;
    }

    public Dag_plus4 getDag_plus4 ()
    {
        return dag_plus4;
    }

	public void setDag_plus4 (Dag_plus4 dag_plus4)
    {
        this.dag_plus4 = dag_plus4;
    }

    public Dag_plus3 getDag_plus3 ()
    {
        return dag_plus3;
    }

	public void setDag_plus3 (Dag_plus3 dag_plus3)
    {
        this.dag_plus3 = dag_plus3;
    }

    public Dag_plus2 getDag_plus2 ()
    {
        return dag_plus2;
    }

	public void setDag_plus2 (Dag_plus2 dag_plus2)
    {
        this.dag_plus2 = dag_plus2;
    }

    public Dag_plus1 getDag_plus1 ()
    {
        return dag_plus1;
    }

	public void setDag_plus1 (Dag_plus1 dag_plus1)
    {
        this.dag_plus1 = dag_plus1;
    }

	public String getUrlbackup() {
		return urlbackup;
	}

	public void setUrlbackup(String urlbackup) {
		this.urlbackup = urlbackup;
	}

	public Tekst_middellang getTekst_middellang() {
		return tekst_middellang;
	}

	public void setTekst_middellang(Tekst_middellang tekst_middellang) {
		this.tekst_middellang = tekst_middellang;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "ClassPojo [tekst_lang = " + tekst_lang + ", dag_plus5 = " + dag_plus5 + ", dag_plus4 = " + dag_plus4
				+ ", dag_plus3 = " + dag_plus3 + ", dag_plus2 = " + dag_plus2 + ", dag_plus1 = " + dag_plus1
				+ ", urlbackup = " + urlbackup + ", tekst_middellang = " + tekst_middellang + ", url = " + url + "]";
	}
}
