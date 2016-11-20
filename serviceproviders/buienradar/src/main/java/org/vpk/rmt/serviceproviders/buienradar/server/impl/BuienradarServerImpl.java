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
    public TodaysExpectedWeatherData getTodaysExpectedWeatherData() throws BuienradarServerException {
        VerwachtingVandaag verwachtingVandaag = serverToClient.getVerwachtingVandaag();
        TodaysExpectedWeatherData todaysExpectedWeatherData = clientModelToServerModel.getVerwachtingVandaag2TodaysExpectedWeatherDataMapper().apply(verwachtingVandaag);
        return todaysExpectedWeatherData;
    }

    @Override
    public List<NextExpectedWeatherData> getNextExpectedWeatherData(@PathParam("nofDays") String nofDays) throws BuienradarServerException {
        VerwachtingMeerdaags verwachtingMeerdaags = serverToClient.getVerwachtingMeerdaags();
        List<DagPlusN> dagPlusNList = new ArrayList<>();
        dagPlusNList.add(new DagPlusN(verwachtingMeerdaags.getDagPlus1()));
        dagPlusNList.add(new DagPlusN(verwachtingMeerdaags.getDagPlus2()));
        dagPlusNList.add(new DagPlusN(verwachtingMeerdaags.getDagPlus3()));
        dagPlusNList.add(new DagPlusN(verwachtingMeerdaags.getDagPlus4()));
        dagPlusNList.add(new DagPlusN(verwachtingMeerdaags.getDagPlus5()));
        List<NextExpectedWeatherData> nextExpectedWeatherDataList = dagPlusNList.stream()
                .map(clientModelToServerModel.getDagPlusN2NextExpectedWeatherDataMapper())
                .collect(Collectors.toList());
        return nextExpectedWeatherDataList.subList(0, Integer.valueOf(nofDays));
    }
}
