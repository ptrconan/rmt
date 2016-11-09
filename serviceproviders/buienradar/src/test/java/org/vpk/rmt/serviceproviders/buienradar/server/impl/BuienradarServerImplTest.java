package org.vpk.rmt.serviceproviders.buienradar.server.impl;

import org.junit.Test;
import org.vpk.rmt.serviceproviders.buienradar.client.api.BuienradarClient;
import org.vpk.rmt.serviceproviders.buienradar.server.api.BuienradarClientException;
import org.vpk.rmt.serviceproviders.buienradar.client.stub.BuienradarClientStub;
import org.vpk.rmt.serviceproviders.buienradar.server.api.BuienradarServerException;
import org.vpk.rmt.serviceproviders.buienradar.server.datamodel.WeatherInformation;

import javax.ws.rs.NotFoundException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BuienradarServerImplTest {

    @Test
    public void test20161108222000() {
        BuienradarServerImpl buienradarServer = new BuienradarServerImpl();
        buienradarServer.setBuienradarClient(new BuienradarClientStub("20161108222000"));

        WeatherInformation weatherInformation = null;
        try {
            weatherInformation = buienradarServer.getWeatherInformation("Eindhoven", "false");
            assertEquals("Response is not as expected, ", "3.3", String.valueOf(weatherInformation.getTemperature()));
        } catch (BuienradarServerException e) {
        } catch (BuienradarClientException e) {
        }
    }

    @Test (expected = BuienradarServerException.class)
    public void testUnknownStation() throws BuienradarServerException, BuienradarClientException {
        BuienradarServerImpl buienradarServer = new BuienradarServerImpl();
        buienradarServer.setBuienradarClient(new BuienradarClientStub("20161108222000"));

        buienradarServer.getWeatherInformation("Timboektoe", "false");
    }

    @Test (expected = BuienradarClientException.class)
    public void testClientThrowsException() throws BuienradarServerException, BuienradarClientException {
        BuienradarClient buienradarClient = mock(BuienradarClient.class);
        when(buienradarClient.getBuienradarnl()).thenThrow(new NotFoundException("test"));

        BuienradarServerImpl buienradarServer = new BuienradarServerImpl();
        buienradarServer.setBuienradarClient(buienradarClient);

        buienradarServer.getWeatherInformation("test", "false");
    }
}
