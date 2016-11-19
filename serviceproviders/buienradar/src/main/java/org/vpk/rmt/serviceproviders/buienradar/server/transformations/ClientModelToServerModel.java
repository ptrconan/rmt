package org.vpk.rmt.serviceproviders.buienradar.server.transformations;

import org.vpk.rmt.serviceproviders.buienradar.client.datamodel.Weerstation;
import org.vpk.rmt.serviceproviders.buienradar.server.datamodel.ActualWeatherDataForRegion;

import java.util.function.Function;

/**
 * Created by Pieter on 19-11-2016.
 */
public class ClientModelToServerModel {

    private Function<Weerstation, ActualWeatherDataForRegion> weerstationToActualWeatherDataForRegionMapper = new Function<Weerstation, ActualWeatherDataForRegion>() {
        @Override
        public ActualWeatherDataForRegion apply(Weerstation weerstation) {
            ActualWeatherDataForRegion actualWeatherDataForRegion = new ActualWeatherDataForRegion();
            actualWeatherDataForRegion.setRegion(weerstation.getStationnaam().getRegio());
            actualWeatherDataForRegion.setLatitude(weerstation.getLatGraden());
            actualWeatherDataForRegion.setLongitude(weerstation.getLonGraden());
            actualWeatherDataForRegion.setHumidity(weerstation.getLuchtvochtigheid());
            actualWeatherDataForRegion.setTemperature(weerstation.getTemperatuurGC());
            return actualWeatherDataForRegion;
        }
    };

    public Function<Weerstation, ActualWeatherDataForRegion> getWeerstationToActualWeatherDataForRegionMapper() {
        return weerstationToActualWeatherDataForRegionMapper;
    }
}
