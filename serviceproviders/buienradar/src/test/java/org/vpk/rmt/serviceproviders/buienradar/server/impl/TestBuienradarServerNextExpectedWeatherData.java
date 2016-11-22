package org.vpk.rmt.serviceproviders.buienradar.server.impl;

import org.junit.Test;
import org.vpk.rmt.serviceproviders.buienradar.client.stub.BuienradarClientStub;
import org.vpk.rmt.serviceproviders.buienradar.server.datamodel.NextExpectedWeatherData;
import org.vpk.rmt.serviceproviders.buienradar.server.exceptions.BuienradarServerException;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Pieter on 22-11-2016.
 */
public class TestBuienradarServerNextExpectedWeatherData {

    @Test
    public void testNextExpectedWeatherData() throws BuienradarServerException {
        BuienradarServerImpl buienradarServer = new BuienradarServerImpl(new BuienradarClientStub("buienradarnl-20161108222000.xml"));
        List<NextExpectedWeatherData> nextExpectedWeatherDataList = buienradarServer.getNextExpectedWeatherData("5");
        assertEquals("the first next day of the week is incorrect", "wo", nextExpectedWeatherDataList.get(0).getDagweek());
        assertEquals("the last next day of the week is incorrect", "zo", nextExpectedWeatherDataList.get(4).getDagweek());
    }

    @Test
    public void testNofNextExpectedWeatherDataFirstInRange() throws BuienradarServerException {
        BuienradarServerImpl buienradarServer = new BuienradarServerImpl(new BuienradarClientStub("buienradarnl-20161108222000.xml"));
        List<NextExpectedWeatherData> nextExpectedWeatherDataList = buienradarServer.getNextExpectedWeatherData(String.valueOf(BuienradarServerImpl.MIN_NOF_NEXT_DAYS));
        assertEquals("number of next days is incorrect", BuienradarServerImpl.MIN_NOF_NEXT_DAYS, nextExpectedWeatherDataList.size());
    }

    @Test
    public void testNofNextExpectedWeatherDataLastInRange() throws BuienradarServerException {
        BuienradarServerImpl buienradarServer = new BuienradarServerImpl(new BuienradarClientStub("buienradarnl-20161108222000.xml"));
        List<NextExpectedWeatherData> nextExpectedWeatherDataList = buienradarServer.getNextExpectedWeatherData(String.valueOf(BuienradarServerImpl.MAX_NOF_NEXT_DAYS));
        assertEquals("number of next days is incorrect", BuienradarServerImpl.MAX_NOF_NEXT_DAYS, nextExpectedWeatherDataList.size());
    }

    @Test
    public void testNofNextExpectedWeatherDataFromTooLow() throws BuienradarServerException {
        BuienradarServerImpl buienradarServer = new BuienradarServerImpl(new BuienradarClientStub("buienradarnl-20161108222000.xml"));
        List<NextExpectedWeatherData> nextExpectedWeatherDataList = buienradarServer.getNextExpectedWeatherData(String.valueOf(BuienradarServerImpl.MIN_NOF_NEXT_DAYS - 1));
        assertEquals("number of next days is incorrect", BuienradarServerImpl.MAX_NOF_NEXT_DAYS, nextExpectedWeatherDataList.size());
    }

    @Test
    public void testNofNextExpectedWeatherDataFromTooHigh() throws BuienradarServerException {
        BuienradarServerImpl buienradarServer = new BuienradarServerImpl(new BuienradarClientStub("buienradarnl-20161108222000.xml"));
        List<NextExpectedWeatherData> nextExpectedWeatherDataList = buienradarServer.getNextExpectedWeatherData(String.valueOf(BuienradarServerImpl.MAX_NOF_NEXT_DAYS + 1));
        assertEquals("number of next days is incorrect", BuienradarServerImpl.MAX_NOF_NEXT_DAYS, nextExpectedWeatherDataList.size());
    }

    @Test
    public void testNofNextExpectedWeatherDataFromInvalidNumber() throws BuienradarServerException {
        BuienradarServerImpl buienradarServer = new BuienradarServerImpl(new BuienradarClientStub("buienradarnl-20161108222000.xml"));
        List<NextExpectedWeatherData> nextExpectedWeatherDataList = buienradarServer.getNextExpectedWeatherData("seven");
        assertEquals("number of next days is incorrect", BuienradarServerImpl.MAX_NOF_NEXT_DAYS, nextExpectedWeatherDataList.size());
    }
}
