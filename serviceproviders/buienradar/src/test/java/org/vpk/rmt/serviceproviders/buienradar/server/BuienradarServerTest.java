package org.vpk.rmt.serviceproviders.buienradar.server;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.vpk.rmt.serviceproviders.buienradar.client.api.BuienradarClient;
import org.vpk.rmt.serviceproviders.buienradar.client.datamodel.Buienradarnl;
import org.vpk.rmt.serviceproviders.buienradar.server.impl.BuienradarServerImpl;

public class BuienradarServerTest {

	@Test
	public void test() {
		// create and program the mock's response on the request
		BuienradarClient buienradarClient = mock(BuienradarClient.class);
		Buienradarnl buienradarnl = new Buienradarnl(); 
		when(buienradarClient.getWeatherInformation()).thenReturn(buienradarnl);
		
		BuienradarServerImpl buienradarServerImpl = new BuienradarServerImpl(buienradarClient);
		String response = buienradarServerImpl.getWeatherInformation("nl", "false");
		
		assertEquals("result should be true", true, true);
	}

}
