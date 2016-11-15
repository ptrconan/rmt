package org.vpk.rmt.serviceproviders.buienradar.server.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.vpk.rmt.serviceproviders.buienradar.client.api.BuienradarClient;
import org.vpk.rmt.serviceproviders.buienradar.client.datamodel.*;
import org.vpk.rmt.serviceproviders.buienradar.server.api.*;
import org.vpk.rmt.serviceproviders.buienradar.server.datamodel.WeatherInformation;

public class BuienradarServerImpl implements BuienradarServer {

    private static final long serialVersionUID = 1L;

    private Buienradarnl buienradarnl;

    public BuienradarServerImpl() {
        buienradarnl = null;
    }

    private BuienradarClient buienradarClient;

    public void setBuienradarClient(BuienradarClient buienradarClient) {
        this.buienradarClient = buienradarClient;
    }

    @Override
    public WeatherInformation getWeatherInformation(String stationName, String debug) throws BuienradarServerException {
        Buienradarnl buienradarnl = getBuienradarnl();
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

    @Override
    public Weergegevens getWeerGegevens(String debug) throws BuienradarServerException {
        return Optional.of(getBuienradarnl())
                .map(Buienradarnl::getWeergegevens)
                .orElseThrow(() -> new BuienradarWeerGegevensNotFoundException());
    }

    @Override
    public ActueelWeer getActueelWeer(String debug) throws BuienradarServerException {
        return Optional.of(getWeerGegevens(debug))
                .map(Weergegevens::getActueelWeer)
                .orElseThrow(() -> new BuienradarActueelWeerNotFoundException());
    }

    @Override
    public Weerstations getWeerStations(String debug) throws BuienradarServerException {
        return Optional.of(getActueelWeer(debug))
                .map(ActueelWeer::getWeerstations)
                .orElseThrow(() -> new BuienradarWeerstationsNotFoundException());
    }

    @Override
    public Weerstation getWeerStation(String id, String debug) throws BuienradarServerException {
        return Optional.of(getWeerStations(debug))
                .map(Weerstations::getWeerstation)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(weerstation -> weerstation.getId().equals(Short.valueOf(id)))
                .findFirst()
                .orElseThrow(() -> new BuienradarWeerstationNotFoundException());
    }

    private Buienradarnl getBuienradarnl() throws BuienradarClientCommunicationException {
        try {
            return buienradarClient.getBuienradarnl();
        }
        catch (Exception e) {
            throw new BuienradarClientCommunicationException(e.getMessage());
        }
    }
}
