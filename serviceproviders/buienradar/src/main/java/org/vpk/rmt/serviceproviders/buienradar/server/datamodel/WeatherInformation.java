package org.vpk.rmt.serviceproviders.buienradar.server.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Created by Pieter on 8-11-2016.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "region", "latitude", "longitude", "humidity", "temperature"})
@JsonIgnoreProperties(ignoreUnknown=true)
public class WeatherInformation {

    private static final long serialVersionUID = 1L;

    public WeatherInformation() {
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
