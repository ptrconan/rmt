package org.vpk.rmt.serviceproviders.buienradar.server.impl;

import org.junit.Test;
import org.vpk.rmt.serviceproviders.buienradar.client.api.BuienradarClient;
import org.vpk.rmt.serviceproviders.buienradar.client.stub.BuienradarClientStub;
import org.vpk.rmt.serviceproviders.buienradar.server.exceptions.*;

import javax.ws.rs.NotFoundException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Pieter on 20-11-2016.
 */
public class BuienradarServerImplHelperTest {

    // all data related tests

    // TODO: create data related tests

    @Test
    public void doTest() {
//        BuienradarServerImplHelper serverToClient = new BuienradarServerImplHelper(new BuienradarClientStub("buienradarnl-20161108222000.xml"));
//        serverToClient.getDagPlusNList();
    }


    // all exception related tests

    @Test (expected = BuienradarClientCommunicationException.class)
    public void testClientThrowsException() throws BuienradarServerException {
        BuienradarClient buienradarClient = mock(BuienradarClient.class);
        when(buienradarClient.getBuienradarnl()).thenThrow(new NotFoundException("test"));
        BuienradarServerImplHelper buienradarServerImplHelper = new BuienradarServerImplHelper(buienradarClient);
        buienradarServerImplHelper.getWeerGegevens();
    }

    @Test(expected = BuienradarActueelWeerNotFoundException.class)
    public void testNoActueelWeer() throws BuienradarServerException {
        BuienradarServerImplHelper buienradarServerImplHelper = new BuienradarServerImplHelper(new BuienradarClientStub("buienradarnl-20161108222000-no-actueel_weer.xml"));
        buienradarServerImplHelper.getWeerStation(0);
    }

    @Test (expected = BuienradarWeerGegevensNotFoundException.class)
    public void testNoWeerGegevens() throws BuienradarServerException {
        BuienradarServerImplHelper buienradarServerImplHelper = new BuienradarServerImplHelper(new BuienradarClientStub("buienradarnl-20161108222000-no-weergegevens.xml"));
        buienradarServerImplHelper.getWeerGegevens();
   }

    @Test (expected = BuienradarWeerStationsNotFoundException.class)
    public void testNoWeerStations() throws BuienradarServerException {
        BuienradarServerImplHelper buienradarServerImplHelper = new BuienradarServerImplHelper(new BuienradarClientStub("buienradarnl-20161108222000-no-weerstations.xml"));
        buienradarServerImplHelper.getWeerStations();
    }

    @Test (expected = BuienradarWeerStationNotFoundException.class)
    public void testNoWeerStation() throws BuienradarServerException {
        BuienradarServerImplHelper buienradarServerImplHelper = new BuienradarServerImplHelper(new BuienradarClientStub("buienradarnl-20161108222000-no-weerstation.xml"));
        buienradarServerImplHelper.getWeerStation(0);
    }

    @Test (expected = BuienradarWeerStationNotFoundException.class)
    public void testUnknownStation() throws BuienradarServerException {
        BuienradarServerImplHelper buienradarServerImplHelper = new BuienradarServerImplHelper(new BuienradarClientStub("buienradarnl-20161108222000.xml"));
        buienradarServerImplHelper.getWeerStation(0);
    }
}
