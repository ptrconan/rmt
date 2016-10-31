package org.vpk.rmt.serviceproviders.buienradar.client.impl;

import static org.junit.Assert.*;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

import org.junit.Test;
import org.vpk.rmt.serviceproviders.buienradar.client.api.BuienradarClient;
import org.vpk.rmt.serviceproviders.buienradar.client.datamodel.Buienradarnl;

public class BuienradarClientTest {

	@Test
	public void testLiveWeerGegevens() {
		BuienradarClient buienradarClient = JAXRSClientFactory.create("http://xml.buienradar.nl", BuienradarClient.class);
		Buienradarnl response = buienradarClient.getWeatherInformationNl();

		assertEquals("Titel is not as expected, ", "www.buienradar.nl - actuele weersinformatie", response.getWeergegevens().getTitel());
		assertEquals("Omschrijving is not as expected, ", "XML feed weersinformatie", response.getWeergegevens().getOmschrijving());
		assertEquals("Number of weerstations is not as expected, ", 50, response.getWeergegevens().getActueelWeer().getWeerstations().getWeerstation().size());
	}

}
