package org.vpk.rmt.serviceproviders.buienradar.server.impl;

import org.junit.Test;
import org.vpk.rmt.serviceproviders.buienradar.client.stub.BuienradarClientStub;
import org.vpk.rmt.serviceproviders.buienradar.server.datamodel.ActualWeatherDataForRegion;
import org.vpk.rmt.serviceproviders.buienradar.server.exceptions.*;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestBuienradarServerActualWeatherData {

    @Test
    public void testKnownRegions() throws BuienradarServerException {
        BuienradarServerImpl buienradarServer = new BuienradarServerImpl(new BuienradarClientStub("buienradarnl-20161108222000.xml"));
        List<ActualWeatherDataForRegion> actualWeatherDataForRegionList =
                buienradarServer.getActualWeatherDataForRegion("Eindhoven,Venlo");
        assertEquals("number of weerstations is incorrect", 2, actualWeatherDataForRegionList.size());
    }

    @Test
    public void testUnknownRegions() throws BuienradarServerException {
        BuienradarServerImpl buienradarServer = new BuienradarServerImpl(new BuienradarClientStub("buienradarnl-20161108222000.xml"));
        List<ActualWeatherDataForRegion> actualWeatherDataForRegionList =
                buienradarServer.getActualWeatherDataForRegion("Eeiindhooveen,Veenloo");
        assertEquals("number of weerstations is incorrect", 0, actualWeatherDataForRegionList.size());
    }

    @Test
    public void testKnownAndUnknownRegions() throws BuienradarServerException {
        BuienradarServerImpl buienradarServer = new BuienradarServerImpl(new BuienradarClientStub("buienradarnl-20161108222000.xml"));
        List<ActualWeatherDataForRegion> actualWeatherDataForRegionList =
                buienradarServer.getActualWeatherDataForRegion("Eindhoven,Timboektoe,Venlo");
        assertEquals("number of weerstations is incorrect", 2, actualWeatherDataForRegionList.size());
    }

    @Test
    public void testNoRegions() throws BuienradarServerException {
        BuienradarServerImpl buienradarServer = new BuienradarServerImpl(new BuienradarClientStub("buienradarnl-20161108222000.xml"));
        List<ActualWeatherDataForRegion> actualWeatherDataForRegionList =
                buienradarServer.getActualWeatherDataForRegion("");
        assertEquals("number of weerstations is incorrect", 0, actualWeatherDataForRegionList.size());
    }

    @Test
    public void testEmptyRegions() throws BuienradarServerException {
        BuienradarServerImpl buienradarServer = new BuienradarServerImpl(new BuienradarClientStub("buienradarnl-20161108222000.xml"));
        List<ActualWeatherDataForRegion> actualWeatherDataForRegionList =
                buienradarServer.getActualWeatherDataForRegion(",");
        assertEquals("number of weerstations is incorrect", 0, actualWeatherDataForRegionList.size());
    }

    @Test
    public void testKnownAndEmptyRegions() throws BuienradarServerException {
        BuienradarServerImpl buienradarServer = new BuienradarServerImpl(new BuienradarClientStub("buienradarnl-20161108222000.xml"));
        List<ActualWeatherDataForRegion> actualWeatherDataForRegionList =
                buienradarServer.getActualWeatherDataForRegion("Eindhoven,,Venlo");
        assertEquals("number of weerstations is incorrect", 2, actualWeatherDataForRegionList.size());
    }
}
