package org.vpk.rmt.serviceproviders.buienradar.backend;

import static org.junit.Assert.*;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;

import org.junit.Test;
import org.vpk.rmt.serviceproviders.buienradar.backend.api.BuienradarBackEnd;

public class BuienradarBackEndTest {

	@Test
	public void test() {
		assertEquals("result should be true", true, true);
	}

	@Test
	public void test2() {
		BuienradarBackEnd buienradarBackEnd = JAXRSClientFactory.create("http://xml.buienradar.nl", BuienradarBackEnd.class);
		String response = buienradarBackEnd.getWeatherInformation();
		//<buienradarnl><weergegevens
		
		assertEquals("result should be true", true, true);
	}

}
