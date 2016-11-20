package org.vpk.rmt.serviceproviders.buienradar.server.impl;

import org.junit.Test;
import org.vpk.rmt.serviceproviders.buienradar.client.api.BuienradarClient;
import org.vpk.rmt.serviceproviders.buienradar.client.datamodel.Buienindex;
import org.vpk.rmt.serviceproviders.buienradar.client.datamodel.Buienradarnl;
import org.vpk.rmt.serviceproviders.buienradar.client.datamodel.Weergegevens;
import org.vpk.rmt.serviceproviders.buienradar.client.stub.BuienradarClientStub;
import org.vpk.rmt.serviceproviders.buienradar.server.exceptions.*;

import javax.ws.rs.NotFoundException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Pieter on 20-11-2016.
 */
public class ServerToClientTest {

    // all data related tests

    // TODO: create data related tests

    // all exception related tests

//    @Test
//    public void testNoBuienIndex() throws BuienradarServerException {
//        BuienradarClient buienradarClient = new BuienradarClientStub("buienradarnl-20161108222000.xml");
//        buienradarClient.getBuienradarnl().getWeergegevens().getActueelWeer().setBuienindex(null);
//        ServerToClient serverToClient = new ServerToClient(buienradarClient);
//        Buienindex buienindex = serverToClient.getBuienIndex();
//        int i = 0;
//    }

    @Test (expected = BuienradarClientCommunicationException.class)
    public void testClientThrowsException() throws BuienradarServerException {
        BuienradarClient buienradarClient = mock(BuienradarClient.class);
        when(buienradarClient.getBuienradarnl()).thenThrow(new NotFoundException("test"));
        ServerToClient serverToClient = new ServerToClient(buienradarClient);
        serverToClient.getWeerGegevens();
    }

    @Test(expected = BuienradarActueelWeerNotFoundException.class)
    public void testNoActueelWeer() throws BuienradarServerException {
        ServerToClient serverToClient = new ServerToClient(new BuienradarClientStub("buienradarnl-20161108222000-no-actueel_weer.xml"));
        serverToClient.getWeerStation("dummyId");
    }

    @Test (expected = BuienradarWeerGegevensNotFoundException.class)
    public void testNoWeerGegevens() throws BuienradarServerException {
        ServerToClient serverToClient = new ServerToClient(new BuienradarClientStub("buienradarnl-20161108222000-no-weergegevens.xml"));
        serverToClient.getWeerGegevens();
   }

    @Test (expected = BuienradarWeerStationsNotFoundException.class)
    public void testNoWeerStations() throws BuienradarServerException {
        ServerToClient serverToClient = new ServerToClient(new BuienradarClientStub("buienradarnl-20161108222000-no-weerstations.xml"));
        serverToClient.getWeerStations();
    }

    @Test (expected = BuienradarWeerStationNotFoundException.class)
    public void testNoWeerStation() throws BuienradarServerException {
        ServerToClient serverToClient = new ServerToClient(new BuienradarClientStub("buienradarnl-20161108222000-no-weerstation.xml"));
        serverToClient.getWeerStation("0");
    }

    @Test (expected = BuienradarWeerStationNotFoundException.class)
    public void testUnknownStation() throws BuienradarServerException {
        ServerToClient serverToClient = new ServerToClient(new BuienradarClientStub("buienradarnl-20161108222000.xml"));
        serverToClient.getWeerStation("0");
    }
}
