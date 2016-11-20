package org.vpk.rmt.serviceproviders.buienradar.server.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.vpk.rmt.serviceproviders.buienradar.client.api.BuienradarClient;
import org.vpk.rmt.serviceproviders.buienradar.client.datamodel.DagPlusN;
import org.vpk.rmt.serviceproviders.buienradar.client.datamodel.VerwachtingMeerdaags;
import org.vpk.rmt.serviceproviders.buienradar.client.datamodel.VerwachtingVandaag;
import org.vpk.rmt.serviceproviders.buienradar.server.api.BuienradarServer;
import org.vpk.rmt.serviceproviders.buienradar.server.datamodel.ActualWeatherDataForRegion;
import org.vpk.rmt.serviceproviders.buienradar.server.datamodel.NextExpectedWeatherData;
import org.vpk.rmt.serviceproviders.buienradar.server.datamodel.TodaysExpectedWeatherData;
import org.vpk.rmt.serviceproviders.buienradar.server.exceptions.*;
import org.vpk.rmt.serviceproviders.buienradar.server.transformations.ClientModelToServerModel;

import javax.ws.rs.PathParam;

public class BuienradarServerImpl implements BuienradarServer {

    private static final long serialVersionUID = 1L;

    private ServerToClient serverToClient;
    private ClientModelToServerModel clientModelToServerModel = new ClientModelToServerModel();

    private BuienradarServerImpl() {
    }

    public BuienradarServerImpl(BuienradarClient buienradarClient) {
        serverToClient = new ServerToClient(buienradarClient);
    }

    @Override
    public List<ActualWeatherDataForRegion> getActualWeatherDataForRegion(@PathParam("regions") String regions) throws BuienradarServerException {
        List<String> regionList = Arrays.asList(regions.split(","));
        List<ActualWeatherDataForRegion> actualWeatherDataForRegionList = serverToClient.getWeerStationList(regionList).stream()
                .map(clientModelToServerModel.getWeerstation2ActualWeatherDataForRegionMapper())
                .collect(Collectors.toList());
        return actualWeatherDataForRegionList;
    }

    @Override
    public List<NextExpectedWeatherData> getNextExpectedWeatherData(@PathParam("nofDays") String nofDays) throws BuienradarServerException {
        List<NextExpectedWeatherData> nextExpectedWeatherDataList = serverToClient.getDagPlusNList().stream()
                .map(clientModelToServerModel.getDagPlusN2NextExpectedWeatherDataMapper())
                .collect(Collectors.toList());
        return nextExpectedWeatherDataList.subList(0, Integer.valueOf(nofDays));
    }

    @Override
    public TodaysExpectedWeatherData getTodaysExpectedWeatherData() throws BuienradarServerException {
        VerwachtingVandaag verwachtingVandaag = serverToClient.getVerwachtingVandaag();
        TodaysExpectedWeatherData todaysExpectedWeatherData = clientModelToServerModel.getVerwachtingVandaag2TodaysExpectedWeatherDataMapper().apply(verwachtingVandaag);
        return todaysExpectedWeatherData;
    }
}
