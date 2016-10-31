package org.vpk.rmt.serviceproviders.buienradar.server.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.junit.Test;
import org.vpk.rmt.serviceproviders.buienradar.client.api.BuienradarClient;
import org.vpk.rmt.serviceproviders.buienradar.client.datamodel.ActueelWeer;
import org.vpk.rmt.serviceproviders.buienradar.client.datamodel.Buienradarnl;
import org.vpk.rmt.serviceproviders.buienradar.client.datamodel.Stationnaam;
import org.vpk.rmt.serviceproviders.buienradar.client.datamodel.Weergegevens;
import org.vpk.rmt.serviceproviders.buienradar.client.datamodel.Weerstation;
import org.vpk.rmt.serviceproviders.buienradar.client.datamodel.Weerstations;
import org.vpk.rmt.serviceproviders.buienradar.server.impl.BuienradarServerImpl;

public class BuienradarServerImplTest {

	@Test
	public void test() {
		// create and program the buienradarClient mock response on the request
		BuienradarClient buienradarClient = mock(BuienradarClient.class);
		Buienradarnl buienradarnl = new Buienradarnl();
		Weergegevens weergegevens = new Weergegevens();
		ActueelWeer actueelWeer = new ActueelWeer();
		Weerstations weerstations = new Weerstations();
		
		Weerstation weerstation1 = new Weerstation();
		Stationnaam stationnaam1 = new Stationnaam();
		stationnaam1.setValue("Eindhoven");
		weerstation1.setStationnaam(stationnaam1);
		weerstation1.setTemperatuurGC(11.1f);

		Weerstation weerstation2 = new Weerstation();
		Stationnaam stationnaam2 = new Stationnaam();
		stationnaam2.setValue("Son");
		weerstation2.setStationnaam(stationnaam2);
		weerstation2.setTemperatuurGC(22.2f);
		
		weerstations.getWeerstation().add(weerstation1);
		weerstations.getWeerstation().add(weerstation2);
		actueelWeer.setWeerstations(weerstations);
		weergegevens.setActueelWeer(actueelWeer);
		buienradarnl.setWeergegevens(weergegevens);
		when(buienradarClient.getWeatherInformationNl()).thenReturn(buienradarnl);
		
		BuienradarServerImpl buienradarServerImpl = new BuienradarServerImpl();
		buienradarServerImpl.setBuienradarClient(buienradarClient);
		
		String response = buienradarServerImpl.getWeatherInformation("Eindhoven", "false");
		
		assertEquals("Response is not as expected, ", "11.1", response);
	}

}
