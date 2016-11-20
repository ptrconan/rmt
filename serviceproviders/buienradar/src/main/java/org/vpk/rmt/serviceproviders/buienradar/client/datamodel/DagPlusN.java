package org.vpk.rmt.serviceproviders.buienradar.client.datamodel;

/**
 * Created by Pieter on 19-11-2016.
 */
public class DagPlusN {

    private static final long serialVersionUID = 1L;

    protected String dagweek;
    protected String datum;
    protected int kansregen;
    protected int kanszon;
    protected int maxmmregen;
    protected int maxtemp;
    protected int maxtempmax;
    protected int minmmregen;
    protected int mintemp;
    protected int mintempmax;
    protected int sneeuwcms;
    protected int windkracht;
    protected String windrichting;

    private DagPlusN() {
    }

    public DagPlusN(DagPlus1 dagPlusX) {
        this.dagweek = dagPlusX.getDagweek();
        this.datum = dagPlusX.getDatum();
        this.kansregen = dagPlusX.getKansregen();
        this.kanszon = dagPlusX.getKanszon();
        this.maxmmregen = dagPlusX.getMaxmmregen();
        this.maxtemp = dagPlusX.getMaxtemp();
        this.maxtempmax = dagPlusX.getMaxtempmax();
        this.minmmregen = dagPlusX.getMinmmregen();
        this.mintemp = dagPlusX.getMintemp();
        this.mintempmax = dagPlusX.getMintempmax();
        this.sneeuwcms= dagPlusX.getSneeuwcms();
        this.windkracht = dagPlusX.getWindkracht();
        this.windrichting = dagPlusX.getWindrichting();
    }

    public DagPlusN(DagPlus2 dagPlusX) {
        this.dagweek = dagPlusX.getDagweek();
        this.datum = dagPlusX.getDatum();
        this.kansregen = dagPlusX.getKansregen();
        this.kanszon = dagPlusX.getKanszon();
        this.maxmmregen = dagPlusX.getMaxmmregen();
        this.maxtemp = dagPlusX.getMaxtemp();
        this.maxtempmax = dagPlusX.getMaxtempmax();
        this.minmmregen = dagPlusX.getMinmmregen();
        this.mintemp = dagPlusX.getMintemp();
        this.mintempmax = dagPlusX.getMintempmax();
        this.sneeuwcms= dagPlusX.getSneeuwcms();
        this.windkracht = dagPlusX.getWindkracht();
        this.windrichting = dagPlusX.getWindrichting();
    }

    public DagPlusN(DagPlus3 dagPlusX) {
        this.dagweek = dagPlusX.getDagweek();
        this.datum = dagPlusX.getDatum();
        this.kansregen = dagPlusX.getKansregen();
        this.kanszon = dagPlusX.getKanszon();
        this.maxmmregen = dagPlusX.getMaxmmregen();
        this.maxtemp = dagPlusX.getMaxtemp();
        this.maxtempmax = dagPlusX.getMaxtempmax();
        this.minmmregen = dagPlusX.getMinmmregen();
        this.mintemp = dagPlusX.getMintemp();
        this.mintempmax = dagPlusX.getMintempmax();
        this.sneeuwcms= dagPlusX.getSneeuwcms();
        this.windkracht = dagPlusX.getWindkracht();
        this.windrichting = dagPlusX.getWindrichting();
    }

    public DagPlusN(DagPlus4 dagPlusX) {
        this.dagweek = dagPlusX.getDagweek();
        this.datum = dagPlusX.getDatum();
        this.kansregen = dagPlusX.getKansregen();
        this.kanszon = dagPlusX.getKanszon();
        this.maxmmregen = dagPlusX.getMaxmmregen();
        this.maxtemp = dagPlusX.getMaxtemp();
        this.maxtempmax = dagPlusX.getMaxtempmax();
        this.minmmregen = dagPlusX.getMinmmregen();
        this.mintemp = dagPlusX.getMintemp();
        this.mintempmax = dagPlusX.getMintempmax();
        this.sneeuwcms= dagPlusX.getSneeuwcms();
        this.windkracht = dagPlusX.getWindkracht();
        this.windrichting = dagPlusX.getWindrichting();
    }

    public DagPlusN(DagPlus5 dagPlusX) {
        this.dagweek = dagPlusX.getDagweek();
        this.datum = dagPlusX.getDatum();
        this.kansregen = dagPlusX.getKansregen();
        this.kanszon = dagPlusX.getKanszon();
        this.maxmmregen = dagPlusX.getMaxmmregen();
        this.maxtemp = dagPlusX.getMaxtemp();
        this.maxtempmax = dagPlusX.getMaxtempmax();
        this.minmmregen = dagPlusX.getMinmmregen();
        this.mintemp = dagPlusX.getMintemp();
        this.mintempmax = dagPlusX.getMintempmax();
        this.sneeuwcms= dagPlusX.getSneeuwcms();
        this.windkracht = dagPlusX.getWindkracht();
        this.windrichting = dagPlusX.getWindrichting();
    }

    public String getDagweek() {
        return dagweek;
    }

    public String getDatum() {
        return datum;
    }

    public int getKansregen() {
        return kansregen;
    }

    public int getKanszon() {
        return kanszon;
    }

    public int getMaxmmregen() {
        return maxmmregen;
    }

    public int getMaxtemp() {
        return maxtemp;
    }

    public int getMaxtempmax() {
        return maxtempmax;
    }

    public int getMinmmregen() {
        return minmmregen;
    }

    public int getMintemp() {
        return mintemp;
    }

    public int getMintempmax() {
        return mintempmax;
    }

    public int getSneeuwcms() {
        return sneeuwcms;
    }

    public int getWindkracht() {
        return windkracht;
    }

    public String getWindrichting() {
        return windrichting;
    }
}
