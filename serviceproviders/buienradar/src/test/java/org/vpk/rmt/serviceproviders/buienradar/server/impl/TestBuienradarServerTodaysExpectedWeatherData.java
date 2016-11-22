package org.vpk.rmt.serviceproviders.buienradar.server.impl;

import org.junit.Test;
import org.vpk.rmt.serviceproviders.buienradar.client.stub.BuienradarClientStub;
import org.vpk.rmt.serviceproviders.buienradar.server.datamodel.TodaysExpectedWeatherData;
import org.vpk.rmt.serviceproviders.buienradar.server.exceptions.BuienradarServerException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Pieter on 22-11-2016.
 */
public class TestBuienradarServerTodaysExpectedWeatherData {

    @Test
    public void testTitle() throws BuienradarServerException {
        BuienradarServerImpl buienradarServer = new BuienradarServerImpl(new BuienradarClientStub("buienradarnl-20161108222000.xml"));
        TodaysExpectedWeatherData todaysExpectedWeatherData = buienradarServer.getTodaysExpectedWeatherData();
        String title = todaysExpectedWeatherData.getTitel();
        assertEquals("title is not correct", true, title.contains("Lokaal een winterse bui"));
    }
}
