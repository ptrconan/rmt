package org.vpk.rmt.serviceproviders.buienradar.server.impl;

import java.util.List;
import java.util.Optional;

import org.joda.time.DateTime;
import org.vpk.rmt.serviceproviders.buienradar.client.api.BuienradarClient;
import org.vpk.rmt.serviceproviders.buienradar.client.datamodel.*;
import org.vpk.rmt.serviceproviders.buienradar.server.api.BuienradarServer;
import org.vpk.rmt.serviceproviders.buienradar.server.datamodel.WeatherInformation;
import org.vpk.rmt.serviceproviders.buienradar.server.exceptions.*;

import static org.joda.time.DateTime.now;

public class BuienradarServerImpl implements BuienradarServer {

    private static final long serialVersionUID = 1L;

    private Buienradarnl buienradarnl;
    private DateTime dateTimeLastSuccessFullUpdate;

    public BuienradarServerImpl() {
        buienradarnl = null;
        dateTimeLastSuccessFullUpdate = new DateTime(); // TODO: minus offset for stale detemination
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
    public VerwachtingMeerdaags getVerwachtingMeerdaags(String debug) throws BuienradarServerException {
        return Optional.of(getWeerGegevens(debug))
                .map(Weergegevens::getVerwachtingMeerdaags)
                .orElseThrow(() -> new BuienradarVerwachtingMeerdaagsNotFoundException());
    }

    @Override
    public VerwachtingVandaag getVerwachtingVandaag(String debug) throws BuienradarServerException {
        return Optional.of(getWeerGegevens(debug))
                .map(Weergegevens::getVerwachtingVandaag)
                .orElseThrow(() -> new BuienradarVerwachtingVandaagNotFoundException());
    }

    @Override
    public ActueelWeer getActueelWeer(String debug) throws BuienradarServerException {
        return Optional.of(getWeerGegevens(debug))
                .map(Weergegevens::getActueelWeer)
                .orElseThrow(() -> new BuienradarActueelWeerNotFoundException());
    }

    @Override
    public Buienindex getBuienIndex(String debug) throws BuienradarServerException {
        return Optional.of(getActueelWeer(debug))
                .map(ActueelWeer::getBuienindex)
                .orElseThrow(() -> new BuienradarBuienIndexNotFoundException());
    }

    @Override
    public Buienradar getBuienRadar(String debug) throws BuienradarServerException {
        return Optional.of(getActueelWeer(debug))
                .map(ActueelWeer::getBuienradar)
                .orElseThrow(() -> new BuienradarBuienRadarNotFoundException());
    }

    @Override
    public Weerstations getWeerStations(String debug) throws BuienradarServerException {
        return Optional.of(getActueelWeer(debug))
                .map(ActueelWeer::getWeerstations)
                .orElseThrow(() -> new BuienradarWeerStationsNotFoundException());
    }

    @Override
    public Weerstation getWeerStationPathParamId(String id, String debug) throws BuienradarServerException {
        return getWeerStation(id, debug);
    }

    @Override
    public Weerstation getWeerStationQueryParam(String id1, String id2, String debug) throws BuienradarServerException {
        String id = "0";
        if (id1 != null) {
            id = id1;
        }
        if (id2 != null) {
            id = id2;
        }
        return getWeerStation(id, debug);
    }

    // the next method is kept public just for the sake of unit tests
    public Weerstation getWeerStation(String id, String debug) throws BuienradarServerException {
        return Optional.of(getWeerStations(debug))
                .map(Weerstations::getWeerstation)
                .get()
                .stream()
                .filter(weerstation -> weerstation.getId().equals(Short.valueOf(id)))
                .findFirst()
                .orElseThrow(() -> new BuienradarWeerStationNotFoundException());
    }

    private Buienradarnl getBuienradarnl() throws BuienradarClientCommunicationException {
        // TODO: refactor nof seconds for the need to update
        boolean noNeedToUpdate = dateTimeLastSuccessFullUpdate.plusSeconds(600).isAfterNow();
        if ((buienradarnl != null) && noNeedToUpdate) {
            return buienradarnl;
        }
        else {
            try {
                buienradarnl = buienradarClient.getBuienradarnl();
                dateTimeLastSuccessFullUpdate = now();
                return buienradarnl;
            }
            catch (Exception e) {
                throw new BuienradarClientCommunicationException(e.getMessage());
            }
        }
    }
}
