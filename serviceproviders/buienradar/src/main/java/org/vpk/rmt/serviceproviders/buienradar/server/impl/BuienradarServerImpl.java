package org.vpk.rmt.serviceproviders.buienradar.server.impl;

import java.util.List;
import java.util.Optional;

import org.vpk.rmt.serviceproviders.buienradar.client.api.BuienradarClient;
import org.vpk.rmt.serviceproviders.buienradar.server.api.BuienradarClientException;
import org.vpk.rmt.serviceproviders.buienradar.client.datamodel.Buienradarnl;
import org.vpk.rmt.serviceproviders.buienradar.client.datamodel.Weerstation;
import org.vpk.rmt.serviceproviders.buienradar.server.api.BuienradarServer;
import org.vpk.rmt.serviceproviders.buienradar.server.api.BuienradarServerException;
import org.vpk.rmt.serviceproviders.buienradar.server.datamodel.WeatherInformation;

public class BuienradarServerImpl implements BuienradarServer {

    private static final long serialVersionUID = 1L;

    private BuienradarClient buienradarClient;

    public void setBuienradarClient(BuienradarClient buienradarClient) {
        this.buienradarClient = buienradarClient;
    }

    @Override
    public WeatherInformation getWeatherInformation(String stationName, String debug) throws BuienradarServerException, BuienradarClientException {
        Buienradarnl buienradarnl;
        try {
            buienradarnl = buienradarClient.getBuienradarnl();
        }
        catch (Exception e) {
            throw new BuienradarClientException(e.getMessage());
        }
        List<Weerstation> weerStations = buienradarnl.getWeergegevens().getActueelWeer().getWeerstations().getWeerstation();
        Optional<Weerstation> optionalWeerStation = weerStations.stream()
                .filter(x -> x.getStationnaam().getRegio().equals(stationName))
                .findFirst();

        WeatherInformation weatherInformation = new WeatherInformation();
        if (optionalWeerStation.isPresent()) {
/*  TODO: use extractor
*         Optional.ofNullable(titleType.getDurationInSeconds())
                .map(BigInteger::intValue)
                .ifPresent(descriptiveMetadata::setDuration);
        //title
        extractTitle(titleType).ifPresent(title -> descriptiveMetadata.getTitle().add(title));
        //isAdult
        Optional.ofNullable(titleType.isIsAdult()).ifPresent(descriptiveMetadata::setIsAdult);
        //broadcastDate
        Optional.ofNullable(titleType.getBroadcastDate())
                .map(XMLGregorianCalendar::toGregorianCalendar)
                .map(DateTime::new)
                .ifPresent(descriptiveMetadata::setBroadcastDate);
* */
            Weerstation weerstation = optionalWeerStation.get();
            weatherInformation.setHumidity(weerstation.getLuchtvochtigheid());
            weatherInformation.setLatitude(weerstation.getLat());
            weatherInformation.setLongitude(weerstation.getLon());
            weatherInformation.setRegion(weerstation.getStationnaam().getRegio());
            weatherInformation.setTemperature(weerstation.getTemperatuurGC());
            return weatherInformation;
        }
        else {
            throw new BuienradarServerException("Weather station not found");
        }
    }
}
