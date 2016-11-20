package org.vpk.rmt.serviceproviders.buienradar.server.impl;

import org.junit.Test;
import org.vpk.rmt.serviceproviders.buienradar.client.api.BuienradarClient;
import org.vpk.rmt.serviceproviders.buienradar.client.stub.BuienradarClientStub;
import org.vpk.rmt.serviceproviders.buienradar.server.datamodel.ActualWeatherDataForRegion;
import org.vpk.rmt.serviceproviders.buienradar.server.datamodel.NextExpectedWeatherData;
import org.vpk.rmt.serviceproviders.buienradar.server.datamodel.TodaysExpectedWeatherData;
import org.vpk.rmt.serviceproviders.buienradar.server.exceptions.*;

import javax.ws.rs.NotFoundException;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BuienradarServerImplTest {

    @Test
    public void testActualWeatherDataForRegion() throws BuienradarServerException {
        BuienradarServerImpl buienradarServer = new BuienradarServerImpl(new BuienradarClientStub("buienradarnl-20161108222000.xml"));
        List<ActualWeatherDataForRegion> actualWeatherDataForRegionList =
                buienradarServer.getActualWeatherDataForRegion("Eindhoven,Venlo");
        assertEquals("number of weerstations is incorrect", 2, actualWeatherDataForRegionList.size());
    }

    @Test
    public void testTodaysExpectedWeatherData() throws BuienradarServerException {
        BuienradarServerImpl buienradarServer = new BuienradarServerImpl(new BuienradarClientStub("buienradarnl-20161108222000.xml"));
        TodaysExpectedWeatherData todaysExpectedWeatherData = buienradarServer.getTodaysExpectedWeatherData();
        String title = todaysExpectedWeatherData.getTitel();
        assertEquals("title is not correct", true, title.contains("Lokaal een winterse bui"));
    }

    @Test
    public void testNextExpectedWeatherData() throws BuienradarServerException {
        BuienradarServerImpl buienradarServer = new BuienradarServerImpl(new BuienradarClientStub("buienradarnl-20161108222000.xml"));
        List<NextExpectedWeatherData> nextExpectedWeatherDataList = buienradarServer.getNextExpectedWeatherData("5");
        assertEquals("number of next days is incorrect", 5, nextExpectedWeatherDataList.size());
        assertEquals("the first next day of the week is incorrect", "wo", nextExpectedWeatherDataList.get(0).getDagweek());
        assertEquals("the last next day of the week is incorrect", "zo", nextExpectedWeatherDataList.get(4).getDagweek());
    }
}
