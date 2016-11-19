package org.vpk.rmt.serviceproviders.buienradar.server.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Created by Pieter on 17-11-2016.

 <weerstation id="6370">
     <stationcode>6370</stationcode>
     <stationnaam regio="Eindhoven">Meetstation Eindhoven</stationnaam>
     <lat>51.27</lat>
     <lon>5.25</lon>
     <datum>11/08/2016 22:20:00</datum>
     <luchtvochtigheid>90</luchtvochtigheid>
     <temperatuurGC>3.3</temperatuurGC>
     <windsnelheidMS>3.83</windsnelheidMS>
     <windsnelheidBF>3</windsnelheidBF>
     <windrichtingGR>203.5</windrichtingGR>
     <windrichting>ZZW</windrichting>
     <luchtdruk>1007.568</luchtdruk>
     <zichtmeters>13400</zichtmeters>
     <windstotenMS>5.9</windstotenMS>
     <regenMMPU>-</regenMMPU>
     <icoonactueel zin="bewolkt" ID="pp">http://xml.buienradar.nl/icons/pp.gif</icoonactueel>
     <temperatuur10cm>2.2</temperatuur10cm>
     <url>http://www.buienradar.nl/nederland/weerbericht/weergrafieken/6370</url>
     <latGraden>51.45</latGraden>
     <lonGraden>5.42</lonGraden>
 </weerstation>

 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "region", "latitude", "longitude", "humidity", "temperature"})
@JsonIgnoreProperties(ignoreUnknown=true)
public class ActualWeatherDataForRegion {

    private static final long serialVersionUID = 1L;

    public ActualWeatherDataForRegion() {
    }

    @JsonProperty("humidity")
    private float humidity;

    @JsonProperty("humidity")
    public float getHumidity() {
        return humidity;
    }

    @JsonProperty("humidity")
    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    @JsonProperty("latitude")
    private float latitude;

    @JsonProperty("latitude")
    public float getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("longitude")
    private float longitude;

    @JsonProperty("longitude")
    public float getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("region")
    private String region;

    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonProperty("temperature")
    private float temperature;

    @JsonProperty("temperature")
    public float getTemperature() {
        return temperature;
    }

    @JsonProperty("temperature")
    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }
}
