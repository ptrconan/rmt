package org.vpk.rmt.serviceproviders.buienradar.server.impl;

import org.junit.Test;
import org.vpk.rmt.serviceproviders.buienradar.client.api.BuienradarClient;
import org.vpk.rmt.serviceproviders.buienradar.client.stub.BuienradarClientStub;
import org.vpk.rmt.serviceproviders.buienradar.server.datamodel.WeatherInformation;
import org.vpk.rmt.serviceproviders.buienradar.server.exceptions.*;

import javax.ws.rs.NotFoundException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BuienradarServerImplTest {

    @Test
    public void test20161108222000() {
        BuienradarServerImpl buienradarServer = new BuienradarServerImpl();
        buienradarServer.setBuienradarClient(new BuienradarClientStub("buienradarnl-20161108222000.xml"));

        WeatherInformation weatherInformation = null;
        try {
            weatherInformation = buienradarServer.getWeatherInformation("Eindhoven", "false");
            assertEquals("Response is not as expected, ", "3.3", String.valueOf(weatherInformation.getTemperature()));
        } catch (BuienradarServerException e) {
        }
    }

    @Test (expected = BuienradarServerException.class)
    public void testUnknownStation() throws BuienradarServerException {
        BuienradarServerImpl buienradarServer = new BuienradarServerImpl();
        buienradarServer.setBuienradarClient(new BuienradarClientStub("buienradarnl-20161108222000.xml"));
        buienradarServer.getWeatherInformation("Timboektoe", "false");
    }

    @Test (expected = BuienradarClientCommunicationException.class)
    public void testClientThrowsException() throws BuienradarServerException {
        BuienradarClient buienradarClient = mock(BuienradarClient.class);
        when(buienradarClient.getBuienradarnl()).thenThrow(new NotFoundException("test"));

        BuienradarServerImpl buienradarServer = new BuienradarServerImpl();
        buienradarServer.setBuienradarClient(buienradarClient);

        buienradarServer.getWeatherInformation("test", "false");
    }

    @Test (expected = BuienradarActueelWeerNotFoundException.class)
    public void testNoActueelWeer() throws BuienradarServerException {
        BuienradarServerImpl buienradarServer = new BuienradarServerImpl();
        buienradarServer.setBuienradarClient(new BuienradarClientStub("buienradarnl-20161108222000-no-actueel_weer.xml"));
        buienradarServer.getWeerStation("dummyId", "false");
    }

    @Test (expected = BuienradarWeerGegevensNotFoundException.class)
    public void testNoWeerGegevens() throws BuienradarServerException {
        BuienradarServerImpl buienradarServer = new BuienradarServerImpl();
        buienradarServer.setBuienradarClient(new BuienradarClientStub("buienradarnl-20161108222000-no-weergegevens.xml"));
        buienradarServer.getWeerGegevens("false");
    }

    @Test (expected = BuienradarWeerStationsNotFoundException.class)
    public void testNoWeerStations() throws BuienradarServerException {
        BuienradarServerImpl buienradarServer = new BuienradarServerImpl();
        buienradarServer.setBuienradarClient(new BuienradarClientStub("buienradarnl-20161108222000-no-weerstations.xml"));
        buienradarServer.getWeerStations("false");
    }

    @Test (expected = BuienradarWeerStationNotFoundException.class)
    public void testNoWeerStation() throws BuienradarServerException {
        BuienradarServerImpl buienradarServer = new BuienradarServerImpl();
        buienradarServer.setBuienradarClient(new BuienradarClientStub("buienradarnl-20161108222000-no-weerstation.xml"));
        buienradarServer.getWeerStation("dummyId", "false");
    }

    @Test
    public void testGetWeerStation() throws BuienradarServerException {
        BuienradarServerImpl buienradarServer = new BuienradarServerImpl();
        buienradarServer.setBuienradarClient(new BuienradarClientStub("buienradarnl-20161108222000.xml"));
        buienradarServer.getWeerStation("6275", "false");
    }
}
