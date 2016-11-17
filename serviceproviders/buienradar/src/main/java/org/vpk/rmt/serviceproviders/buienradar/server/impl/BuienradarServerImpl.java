package org.vpk.rmt.serviceproviders.buienradar.server.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.joda.time.DateTime;
import org.vpk.rmt.serviceproviders.buienradar.client.api.BuienradarClient;
import org.vpk.rmt.serviceproviders.buienradar.client.datamodel.*;
import org.vpk.rmt.serviceproviders.buienradar.server.api.BuienradarServer;
import org.vpk.rmt.serviceproviders.buienradar.server.datamodel.WeatherDataActualForRegion;
import org.vpk.rmt.serviceproviders.buienradar.server.datamodel.WeatherDataExpectedNext;
import org.vpk.rmt.serviceproviders.buienradar.server.datamodel.WeatherDataExpectedToday;
import org.vpk.rmt.serviceproviders.buienradar.server.datamodel.WeatherInformation;
import org.vpk.rmt.serviceproviders.buienradar.server.exceptions.*;

import javax.ws.rs.PathParam;

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

    Function<Weerstation, WeatherDataActualForRegion> transformClientModelToServerModel = new Function<Weerstation, WeatherDataActualForRegion>() {
        @Override
        public WeatherDataActualForRegion apply(Weerstation weerstation) {
            WeatherDataActualForRegion weatherDataActualForRegion = new WeatherDataActualForRegion();
            weatherDataActualForRegion.setRegion(weerstation.getStationnaam().getRegio());
            weatherDataActualForRegion.setLatitude(weerstation.getLatGraden());
            weatherDataActualForRegion.setLongitude(weerstation.getLonGraden());
            weatherDataActualForRegion.setHumidity(weerstation.getLuchtvochtigheid());
            weatherDataActualForRegion.setTemperature(weerstation.getTemperatuurGC());
            return weatherDataActualForRegion;
        }
    };

    @Override
    public List<WeatherDataActualForRegion> getWeatherDataActualForRegion(@PathParam("regions") String regions) throws BuienradarServerException {
        List<String> regionList = Arrays.asList(regions.split(","));
        List<Weerstation> weerstationList = getWeerStationList(regionList);
        List<WeatherDataActualForRegion> weatherDataActualForRegionList = weerstationList.stream()
                .map(transformClientModelToServerModel)
                .collect(Collectors.toList());
        return weatherDataActualForRegionList;
    }

    @Override
    public WeatherDataExpectedToday getWeatherDataExpectedToday() throws BuienradarServerException {
        return null;
    }

    @Override
    public List<WeatherDataExpectedNext> getWeatherDataExpectedNext(@PathParam("nofDays") String nofDays) throws BuienradarServerException {
        return null;
    }

    @Override
    public Weergegevens getWeerGegevens() throws BuienradarServerException {
        return Optional.of(getBuienradarnl())
                .map(Buienradarnl::getWeergegevens)
                .orElseThrow(() -> new BuienradarWeerGegevensNotFoundException());
    }

    @Override
    public VerwachtingMeerdaags getVerwachtingMeerdaags() throws BuienradarServerException {
        return Optional.of(getWeerGegevens())
                .map(Weergegevens::getVerwachtingMeerdaags)
                .orElseThrow(() -> new BuienradarVerwachtingMeerdaagsNotFoundException());
    }

    @Override
    public VerwachtingVandaag getVerwachtingVandaag() throws BuienradarServerException {
        return Optional.of(getWeerGegevens())
                .map(Weergegevens::getVerwachtingVandaag)
                .orElseThrow(() -> new BuienradarVerwachtingVandaagNotFoundException());
    }

    @Override
    public ActueelWeer getActueelWeer() throws BuienradarServerException {
        return Optional.of(getWeerGegevens())
                .map(Weergegevens::getActueelWeer)
                .orElseThrow(() -> new BuienradarActueelWeerNotFoundException());
    }

    @Override
    public Buienindex getBuienIndex() throws BuienradarServerException {
        return Optional.of(getActueelWeer())
                .map(ActueelWeer::getBuienindex)
                .orElseThrow(() -> new BuienradarBuienIndexNotFoundException());
    }

    @Override
    public Buienradar getBuienRadar() throws BuienradarServerException {
        return Optional.of(getActueelWeer())
                .map(ActueelWeer::getBuienradar)
                .orElseThrow(() -> new BuienradarBuienRadarNotFoundException());
    }

    @Override
    public Weerstations getWeerStations() throws BuienradarServerException {
        return Optional.of(getActueelWeer())
                .map(ActueelWeer::getWeerstations)
                .orElseThrow(() -> new BuienradarWeerStationsNotFoundException());
    }

    @Override
    public Weerstation getWeerStationPathParamId(String id) throws BuienradarServerException {
        return getWeerStation(id);
    }

    @Override
    public Weerstation getWeerStationQueryParam(String id1, String id2) throws BuienradarServerException {
        String id = "0";
        if (id1 != null) {
            id = id1;
        }
        if (id2 != null) {
            id = id2;
        }
        return getWeerStation(id);
    }

    // public for unit testing
    public Weerstation getWeerStation(String id) throws BuienradarServerException {
        return Optional.of(getWeerStations())
                .map(Weerstations::getWeerstation)
                .get()
                .stream()
                .filter(weerstation -> weerstation.getId().equals(Short.valueOf(id)))
                .findFirst()
                .orElseThrow(() -> new BuienradarWeerStationNotFoundException());
    }

    private List<Weerstation> getWeerStationList(List<String> regionList) throws BuienradarServerException {
        return Optional.of(getWeerStations())
                .map(Weerstations::getWeerstation)
                .get()
                .stream()
                .filter(weerstation -> (regionList.contains(weerstation.getStationnaam().getRegio())))
                .collect(Collectors.toList());
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
