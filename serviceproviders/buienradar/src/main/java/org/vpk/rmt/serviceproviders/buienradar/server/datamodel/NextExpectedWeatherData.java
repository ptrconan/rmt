package org.vpk.rmt.serviceproviders.buienradar.server.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Created by Pieter on 17-11-2016.
    <dag-plus1>
        <datum>woensdag 09 november 2016</datum>
        <dagweek>wo</dagweek>
        <kanszon>10</kanszon>
        <kansregen>40</kansregen>
        <minmmregen>0</minmmregen>
        <maxmmregen>4</maxmmregen>
        <mintemp>0</mintemp>
        <mintempmax>0</mintempmax>
        <maxtemp>4</maxtemp>
        <maxtempmax>4</maxtempmax>
        <windrichting>ZO</windrichting>
        <windkracht>3</windkracht>
        <icoon ID="w">http://xml.buienradar.nl/icons/w.gif</icoon>
        <sneeuwcms>0</sneeuwcms>
    </dag-plus1>
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"dagweek", "datum", "kansregen", "kanszon", "maxmmregen", "maxtemp", "maxtempmax", "minmmregen", "mintemp", "mintempmax", "windkracht", "windrichting", "sneeuwcms"})
@JsonIgnoreProperties(ignoreUnknown=true)
public class NextExpectedWeatherData {

    private static final long serialVersionUID = 1L;

    public NextExpectedWeatherData() {
    }

    @JsonProperty("dagweek")
    private String dagweek;

    @JsonProperty("dagweek")
    public String getDagweek() {
        return dagweek;
    }

    @JsonProperty("dagweek")
    public void setDagweek(String dagweek) {
        this.dagweek = dagweek;
    }

    @JsonProperty("datum")
    private String datum;

    @JsonProperty("datum")
    public String getDatum() {
        return datum;
    }

    @JsonProperty("datum")
    public void setDatum(String datum) {
        this.datum = datum;
    }

    @JsonProperty("kansregen")
    private int kansregen;

    @JsonProperty("kansregen")
    public int getKansregen() {
        return kansregen;
    }

    @JsonProperty("kansregen")
    public void setKansregen(int kansregen) {
        this.kansregen = kansregen;
    }

    @JsonProperty("kanszon")
    private int kanszon;

    @JsonProperty("kanszon")
    public int getKanszon() {
        return kanszon;
    }

    @JsonProperty("kanszon")
    public void setKanszon(int kanszon) {
        this.kanszon = kanszon;
    }

    @JsonProperty("maxmmregen")
    private int maxmmregen;

    @JsonProperty("maxmmregen")
    public int getMaxmmregen() {
        return maxmmregen;
    }

    @JsonProperty("maxmmregen")
    public void setMaxmmregen(int maxmmregen) {
        this.maxmmregen = maxmmregen;
    }

    @JsonProperty("maxtemp")
    private int maxtemp;

    @JsonProperty("maxtemp")
    public int getMaxtemp() {
        return maxtemp;
    }

    @JsonProperty("maxtemp")
    public void setMaxtemp(int maxtemp) {
        this.maxtemp = maxtemp;
    }

    @JsonProperty("maxtempmax")
    private int maxtempmax;

    @JsonProperty("maxtempmax")
    public int getMaxtempmax() {
        return maxtempmax;
    }

    @JsonProperty("maxtempmax")
    public void setMaxtempmax(int maxtempmax) {
        this.maxtempmax = maxtempmax;
    }

    @JsonProperty("minmmregen")
    private int minmmregen;

    @JsonProperty("minmmregen")
    public int getMinmmregen() {
        return minmmregen;
    }

    @JsonProperty("minmmregen")
    public void setMinmmregen(int minmmregen) {
        this.minmmregen = minmmregen;
    }

    @JsonProperty("mintemp")
    private int mintemp;

    @JsonProperty("mintemp")
    public int getMintemp() {
        return mintemp;
    }

    @JsonProperty("mintemp")
    public void setMintemp(int mintemp) {
        this.mintemp = mintemp;
    }

    @JsonProperty("mintempmax")
    private int mintempmax;

    @JsonProperty("mintempmax")
    public int getMintempmax() {
        return mintempmax;
    }

    @JsonProperty("mintempmax")
    public void setMintempmax(int mintempmax) {
        this.mintempmax = mintempmax;
    }

    @JsonProperty("windkracht")
    private int windkracht;

    @JsonProperty("windkracht")
    public int getWindkracht() {
        return windkracht;
    }

    @JsonProperty("windkracht")
    public void setWindkracht(int windkracht) {
        this.windkracht = windkracht;
    }

    @JsonProperty("windrichting")
    private String windrichting;

    @JsonProperty("windrichting")
    public String getWindrichting() {
        return windrichting;
    }

    @JsonProperty("windrichting")
    public void setWindrichting(String windrichting) {
        this.windrichting = windrichting;
    }

    @JsonProperty("sneeuwcms")
    private int sneeuwcms;

    @JsonProperty("sneeuwcms")
    public int getSneeuwcms() {
        return sneeuwcms;
    }

    @JsonProperty("sneeuwcms")
    public void setSneeuwcms(int sneeuwcms) {
        this.sneeuwcms = sneeuwcms;
    }
}
