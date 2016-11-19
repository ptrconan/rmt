package org.vpk.rmt.serviceproviders.buienradar.server.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Created by Pieter on 17-11-2016.
    <verwachting_vandaag>
        <url>http://www.buienradar.nl/nederland/weerbericht</url>
        <urlbackup>http://www.buienradar.nl/nederland/weerbericht</urlbackup>
        <titel>Lokaal een winterse bui, morgen in het zuiden regen</titel>
        <tijdweerbericht>Opgesteld op dinsdag 8 nov 2016 om 22:12 uur</tijdweerbericht>
        <samenvatting>Lokaal een winterse bui, vannacht landinwaarts mogelijk mist. Morgen bewolkt met in het zuiden regen, in het noorden droog.</samenvatting>
        <tekst>Een gebied met buiige regen en natte sneeuw trekt vanavond over het noorden en oosten, langs de kust valt lokaal een enkele winterse bui.
            Elders is het half tot zwaar bewolkt en overwegend droog. De wind komt uit richtingen tussen zuidwest en zuidoost en is zwak tot matig.
            Komende nacht zijn er wolkenvelden en vooral in het noordoosten en oosten is er kans op (natte) sneeuw. Er is een kleine kans dat dit aanleiding geeft tot gladheid.
            Op plaatsen met langdurige opklaringen ontstaat er mogelijk mist. In de loop van de nacht neemt in het zuidwesten de bewolking toe, maar blijft het nog droog.
            De minimumtemperatuur loopt uiteen van -2C landinwaarts tot +2C in het  zuidwesten van het land. Zeer lokaal zou het glad kunnen worden, vooral op bruggen en viaducten.
            De wind is zuid tot zuidoost en is matig, langs de kust en op het IJsselmeer vrij krachtig.Morgen neemt de bewolking van het zuidwesten uit verder toe en gaat het in het zuiden regenen.
            In de Limburgse heuvels is later natte sneeuw niet uitgesloten. In het noorden blijft het grotendeels droog en kan in de ochtend zelfs de zon nog even te zien zijn.
            De maximumtemperatuur blijft steken rond 4C. Er staat een matige, langs de kust en op het IJsselmeer vrij krachtige zuidoostenwind. (Bron: KNMI)
        </tekst>
        <formattedtekst>Een gebied met buiige regen en natte sneeuw trekt vanavond over het noorden en oosten, langs de kust valt lokaal een enkele winterse bui. Elders is het half tot zwaar bewolkt en overwegend droog. De wind komt uit richtingen tussen zuidwest en zuidoost en is zwak tot matig.
            Komende nacht zijn er wolkenvelden en vooral in het noordoosten en oosten is er kans op (natte) sneeuw. Er is een kleine kans dat dit aanleiding geeft tot gladheid. Op plaatsen met langdurige opklaringen ontstaat er mogelijk mist.
            In de loop van de nacht neemt in het zuidwesten de bewolking toe, maar blijft het nog droog. De minimumtemperatuur loopt uiteen van -2C landinwaarts tot +2C in het  zuidwesten van het land.
            Zeer lokaal zou het glad kunnen worden, vooral op bruggen en viaducten. De wind is zuid tot zuidoost en is matig, langs de kust en op het IJsselmeer vrij krachtig.
            Morgen neemt de bewolking van het zuidwesten uit verder toe en gaat het in het zuiden regenen. In de Limburgse heuvels is later natte sneeuw niet uitgesloten. In het noorden blijft het grotendeels droog en kan in de ochtend zelfs de zon nog even te zien zijn. De maximumtemperatuur blijft steken rond 4C. Er staat een matige, langs de kust en op het IJsselmeer vrij krachtige zuidoostenwind. (Bron: KNMI)
        </formattedtekst>
    </verwachting_vandaag>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"region", "latitude", "longitude", "humidity", "temperature"})
@JsonIgnoreProperties(ignoreUnknown=true)
public class TodaysExpectedWeatherData {

    private static final long serialVersionUID = 1L;

    public TodaysExpectedWeatherData() {
    }

    @JsonProperty("titel")
    private String titel;

    @JsonProperty("titel")
    public String getTitel() {
        return titel;
    }

    @JsonProperty("titel")
    public void setTitel(String titel) {
        this.titel = titel;
    }

    @JsonProperty("tijdweerbericht")
    private String tijdweerbericht;

    @JsonProperty("tijdweerbericht")
    public String getTijdweerbericht() {
        return tijdweerbericht;
    }

    @JsonProperty("tijdweerbericht")
    public void setTijdweerbericht(String tijdweerbericht) {
        this.tijdweerbericht = tijdweerbericht;
    }

    @JsonProperty("samenvatting")
    private String samenvatting;

    @JsonProperty("samenvatting")
    public String getSamenvatting() {
        return samenvatting;
    }

    @JsonProperty("samenvatting")
    public void setSamenvatting(String samenvatting) {
        this.samenvatting = samenvatting;
    }

    @JsonProperty("tekst")
    private String tekst;

    @JsonProperty("tekst")
    public String getTekst() {
        return tekst;
    }

    @JsonProperty("tekst")
    public void setTekst(String tekst) {
        this.tekst = tekst;
    }
}
