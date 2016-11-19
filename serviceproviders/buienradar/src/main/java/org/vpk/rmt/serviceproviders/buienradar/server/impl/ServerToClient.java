package org.vpk.rmt.serviceproviders.buienradar.server.impl;

import org.joda.time.DateTime;
import org.vpk.rmt.serviceproviders.buienradar.client.api.BuienradarClient;
import org.vpk.rmt.serviceproviders.buienradar.client.datamodel.*;
import org.vpk.rmt.serviceproviders.buienradar.server.exceptions.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.joda.time.DateTime.now;

/**
 * Created by Pieter on 19-11-2016.
 */
public class ServerToClient {

    private static final long serialVersionUID = 1L;

    private Buienradarnl buienradarnl;
    private BuienradarClient buienradarClient;
    private DateTime dateTimeLastSuccessFullUpdate;

    private ServerToClient() {
    }

    public ServerToClient(BuienradarClient buienradarClient) {
        this.buienradarnl = null;
        this.buienradarClient = buienradarClient;
        this.dateTimeLastSuccessFullUpdate = new DateTime(); // TODO: minus offset for stale detemination
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

    public Weergegevens getWeerGegevens() throws BuienradarServerException {
        return Optional.of(getBuienradarnl())
                .map(Buienradarnl::getWeergegevens)
                .orElseThrow(() -> new BuienradarWeerGegevensNotFoundException());
    }

    public VerwachtingMeerdaags getVerwachtingMeerdaags() throws BuienradarServerException {
        return Optional.of(getWeerGegevens())
                .map(Weergegevens::getVerwachtingMeerdaags)
                .orElseThrow(() -> new BuienradarVerwachtingMeerdaagsNotFoundException());
    }

    public VerwachtingVandaag getVerwachtingVandaag() throws BuienradarServerException {
        return Optional.of(getWeerGegevens())
                .map(Weergegevens::getVerwachtingVandaag)
                .orElseThrow(() -> new BuienradarVerwachtingVandaagNotFoundException());
    }

    public ActueelWeer getActueelWeer() throws BuienradarServerException {
        return Optional.of(getWeerGegevens())
                .map(Weergegevens::getActueelWeer)
                .orElseThrow(() -> new BuienradarActueelWeerNotFoundException());
    }

    public Buienindex getBuienIndex() throws BuienradarServerException {
        return Optional.of(getActueelWeer())
                .map(ActueelWeer::getBuienindex)
                .orElseThrow(() -> new BuienradarBuienIndexNotFoundException());
    }

    public Buienradar getBuienRadar() throws BuienradarServerException {
        return Optional.of(getActueelWeer())
                .map(ActueelWeer::getBuienradar)
                .orElseThrow(() -> new BuienradarBuienRadarNotFoundException());
    }

    public Weerstations getWeerStations() throws BuienradarServerException {
        return Optional.of(getActueelWeer())
                .map(ActueelWeer::getWeerstations)
                .orElseThrow(() -> new BuienradarWeerStationsNotFoundException());
    }

    public Weerstation getWeerStationPathParamId(String id) throws BuienradarServerException {
        return getWeerStation(id);
    }

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

    public Weerstation getWeerStation(String id) throws BuienradarServerException {
        return Optional.of(getWeerStations())
                .map(Weerstations::getWeerstation)
                .get()
                .stream()
                .filter(weerstation -> weerstation.getId().equals(Short.valueOf(id)))
                .findFirst()
                .orElseThrow(() -> new BuienradarWeerStationNotFoundException());
    }

    public List<Weerstation> getWeerStationList(List<String> regionList) throws BuienradarServerException {
        return Optional.of(getWeerStations())
                .map(Weerstations::getWeerstation)
                .get()
                .stream()
                .filter(weerstation -> (regionList.contains(weerstation.getStationnaam().getRegio())))
                .collect(Collectors.toList());
    }
}
