package org.vpk.rmt.serviceproviders.buienradar.server.transformations;

import org.vpk.rmt.serviceproviders.buienradar.client.datamodel.VerwachtingVandaag;
import org.vpk.rmt.serviceproviders.buienradar.client.datamodel.Weerstation;
import org.vpk.rmt.serviceproviders.buienradar.server.datamodel.ActualWeatherDataForRegion;
import org.vpk.rmt.serviceproviders.buienradar.server.datamodel.TodaysExpectedWeatherData;

import java.util.function.Function;

/**
 * Created by Pieter on 19-11-2016.
 */
public class ClientModelToServerModel {

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

    public Function<Weerstation, ActualWeatherDataForRegion> getWeerstation2ActualWeatherDataForRegionMapper() {
        return weerstation2ActualWeatherDataForRegionMapper;
    }

    private Function<VerwachtingVandaag, TodaysExpectedWeatherData> verwachtingVandaag2TodaysExpectedWeatherDataMapper = new Function<VerwachtingVandaag, TodaysExpectedWeatherData>() {
        @Override
        public TodaysExpectedWeatherData apply(VerwachtingVandaag verwachtingVandaag) {
            TodaysExpectedWeatherData todaysExpectedWeatherData = new TodaysExpectedWeatherData();
            todaysExpectedWeatherData.setSamenvatting(verwachtingVandaag.getSamenvatting());
            todaysExpectedWeatherData.setTekst(verwachtingVandaag.getTekst());
            todaysExpectedWeatherData.setTijdweerbericht(verwachtingVandaag.getTijdweerbericht());
            todaysExpectedWeatherData.setTitel(verwachtingVandaag.getTitel());
            return  todaysExpectedWeatherData;
        }
    };

    public Function<VerwachtingVandaag, TodaysExpectedWeatherData> getVerwachtingVandaag2TodaysExpectedWeatherDataMapper() {
        return verwachtingVandaag2TodaysExpectedWeatherDataMapper;
    }
}
