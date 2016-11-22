package org.vpk.rmt.serviceproviders.buienradar.server.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.vpk.rmt.serviceproviders.buienradar.client.api.BuienradarClient;
import org.vpk.rmt.serviceproviders.buienradar.server.api.BuienradarServer;
import org.vpk.rmt.serviceproviders.buienradar.server.datamodel.ActualWeatherDataForRegion;
import org.vpk.rmt.serviceproviders.buienradar.server.datamodel.NextExpectedWeatherData;
import org.vpk.rmt.serviceproviders.buienradar.server.datamodel.TodaysExpectedWeatherData;
import org.vpk.rmt.serviceproviders.buienradar.server.exceptions.*;
import org.vpk.rmt.serviceproviders.buienradar.server.transformations.ClientModelToServerModel;

import static com.google.common.primitives.Ints.tryParse;

import javax.ws.rs.PathParam;

public class BuienradarServerImpl implements BuienradarServer {

    private static final long serialVersionUID = 1L;

    public static final int MIN_NOF_NEXT_DAYS = 1;
    public static final int MAX_NOF_NEXT_DAYS = 5;

    private BuienradarServerImplHelper buienradarServerImplHelper;
    private ClientModelToServerModel clientModelToServerModel = new ClientModelToServerModel();

    private BuienradarServerImpl() {
    }

    public BuienradarServerImpl(BuienradarClient buienradarClient) {
        buienradarServerImplHelper = new BuienradarServerImplHelper(buienradarClient);
    }

    @Override
    public List<ActualWeatherDataForRegion> getActualWeatherDataForRegion(@PathParam("regions") String regions) throws BuienradarServerException {
        List<String> regionList = Arrays.asList(regions.split(","));
        List<ActualWeatherDataForRegion> actualWeatherDataForRegionList = buienradarServerImplHelper.getWeerStationList(regionList).stream()
                .map(clientModelToServerModel.getWeerstation2ActualWeatherDataForRegionMapper())
                .collect(Collectors.toList());
        return actualWeatherDataForRegionList;
    }

    @Override
    public List<NextExpectedWeatherData> getNextExpectedWeatherData(@PathParam("nofDays") String nofDays) throws BuienradarServerException {
        List<NextExpectedWeatherData> nextExpectedWeatherDataList = buienradarServerImplHelper.getDagPlusNList().stream()
                .map(clientModelToServerModel.getDagPlusN2NextExpectedWeatherDataMapper())
                .collect(Collectors.toList());
        // top the number of next days to the maximum or set to maximum if larger than allowed or invalid string
        Integer checkedNofDays = Optional.ofNullable(tryParse(nofDays))
                .map(Integer::valueOf)
                .filter(nofNextDays -> (nofNextDays >= MIN_NOF_NEXT_DAYS && nofNextDays <= MAX_NOF_NEXT_DAYS))
                .orElse(MAX_NOF_NEXT_DAYS);
        return nextExpectedWeatherDataList.subList(0, checkedNofDays);
    }

    @Override
    public TodaysExpectedWeatherData getTodaysExpectedWeatherData() throws BuienradarServerException {
        TodaysExpectedWeatherData todaysExpectedWeatherData = clientModelToServerModel.getVerwachtingVandaag2TodaysExpectedWeatherDataMapper()
                .apply(buienradarServerImplHelper.getVerwachtingVandaag());
        return todaysExpectedWeatherData;
    }
}
