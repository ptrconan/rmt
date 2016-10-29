package org.vpk.rmt.serviceproviders.buienradar.client;

import static org.junit.Assert.*;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

import org.junit.Test;
import org.vpk.rmt.serviceproviders.buienradar.client.api.BuienradarClient;
import org.vpk.rmt.serviceproviders.buienradar.client.datamodel.Buienradarnl;

public class BuienradarClientTest {

	@Test
	public void test() {
		assertEquals("result should be true", true, true);
	}

	@Test
	public void test2() {
		BuienradarClient buienradarBackEnd = JAXRSClientFactory.create("http://xml.buienradar.nl", BuienradarClient.class);
		Buienradarnl response = buienradarBackEnd.getWeatherInformation();
		//<buienradarnl><weergegevens
		
		assertEquals("result should be true", true, true);
	}

}
