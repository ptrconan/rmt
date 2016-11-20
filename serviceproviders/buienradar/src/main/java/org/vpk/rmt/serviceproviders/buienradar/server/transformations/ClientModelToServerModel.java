package org.vpk.rmt.serviceproviders.buienradar.server.transformations;

import org.vpk.rmt.serviceproviders.buienradar.client.datamodel.*;
import org.vpk.rmt.serviceproviders.buienradar.server.datamodel.ActualWeatherDataForRegion;
import org.vpk.rmt.serviceproviders.buienradar.server.datamodel.NextExpectedWeatherData;
import org.vpk.rmt.serviceproviders.buienradar.server.datamodel.TodaysExpectedWeatherData;

import java.util.function.Function;

/**
 * Created by Pieter on 19-11-2016.
 */
public class ClientModelToServerModel {

    private static final long serialVersionUID = 1L;

    public Function<DagPlusN, NextExpectedWeatherData> getDagPlusN2NextExpectedWeatherDataMapper() {
        return dagPlusN2NextExpectedWeatherDataMapper;
    }

    public Function<VerwachtingVandaag, TodaysExpectedWeatherData> getVerwachtingVandaag2TodaysExpectedWeatherDataMapper() {
        return verwachtingVandaag2TodaysExpectedWeatherDataMapper;
    }

    public Function<Weerstation, ActualWeatherDataForRegion> getWeerstation2ActualWeatherDataForRegionMapper() {
        return weerstation2ActualWeatherDataForRegionMapper;
    }

    private Function<DagPlusN, NextExpectedWeatherData> dagPlusN2NextExpectedWeatherDataMapper = new Function<DagPlusN, NextExpectedWeatherData>() {
        @Override
        public NextExpectedWeatherData apply(DagPlusN dagPlusN) {
            NextExpectedWeatherData nextExpectedWeatherData = new NextExpectedWeatherData();
            nextExpectedWeatherData.setDagweek(dagPlusN.getDagweek());
            nextExpectedWeatherData.setDatum(dagPlusN.getDatum());
            nextExpectedWeatherData.setKansregen(dagPlusN.getKansregen());
            nextExpectedWeatherData.setKanszon(dagPlusN.getKanszon());
            nextExpectedWeatherData.setMaxmmregen(dagPlusN.getMaxmmregen());
            nextExpectedWeatherData.setMaxtemp(dagPlusN.getMaxtemp());
            nextExpectedWeatherData.setMaxtempmax(dagPlusN.getMaxtempmax());
            nextExpectedWeatherData.setMinmmregen(dagPlusN.getMinmmregen());
            nextExpectedWeatherData.setMintemp(dagPlusN.getMintemp());
            nextExpectedWeatherData.setMintempmax(dagPlusN.getMintempmax());
            nextExpectedWeatherData.setSneeuwcms(dagPlusN.getSneeuwcms());
            nextExpectedWeatherData.setWindkracht(dagPlusN.getWindkracht());
            nextExpectedWeatherData.setWindrichting(dagPlusN.getWindrichting());
            return nextExpectedWeatherData;
        }
    };

    private Function<VerwachtingVandaag, TodaysExpectedWeatherData> verwachtingVandaag2TodaysExpectedWeatherDataMapper = new Function<VerwachtingVandaag, TodaysExpectedWeatherData>() {
        @Override
        public TodaysExpectedWeatherData apply(VerwachtingVandaag verwachtingVandaag) {
            TodaysExpectedWeatherData todaysExpectedWeatherData = new TodaysExpectedWeatherData();
            todaysExpectedWeatherData.setSamenvatting(verwachtingVandaag.getSamenvatting());
            todaysExpectedWeatherData.setTekst(verwachtingVandaag.getTekst());
            todaysExpectedWeatherData.setTijdweerbericht(verwachtingVandaag.getTijdweerbericht());
            todaysExpectedWeatherData.setTitel(verwachtingVandaag.getTitel());
            return todaysExpectedWeatherData;
        }
    };

    private Function<Weerstation, ActualWeatherDataForRegion> weerstation2ActualWeatherDataForRegionMapper = new Function<Weerstation, ActualWeatherDataForRegion>() {
        @Override
        public ActualWeatherDataForRegion apply(Weerstation weerstation) {
            ActualWeatherDataForRegion actualWeatherDataForRegion = new ActualWeatherDataForRegion();
            actualWeatherDataForRegion.setHumidity(weerstation.getLuchtvochtigheid());
            actualWeatherDataForRegion.setLatitude(weerstation.getLatGraden());
            actualWeatherDataForRegion.setLongitude(weerstation.getLonGraden());
            actualWeatherDataForRegion.setRegion(weerstation.getStationnaam().getRegio());
            actualWeatherDataForRegion.setTemperature(weerstation.getTemperatuurGC());
            return actualWeatherDataForRegion;
        }
    };
}
