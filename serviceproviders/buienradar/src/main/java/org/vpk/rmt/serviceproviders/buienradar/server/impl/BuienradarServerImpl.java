package org.vpk.rmt.serviceproviders.buienradar.server.impl;

import org.vpk.rmt.serviceproviders.buienradar.client.api.BuienradarClient;
import org.vpk.rmt.serviceproviders.buienradar.client.datamodel.Buienradarnl;
import org.vpk.rmt.serviceproviders.buienradar.server.api.BuienradarServer;

public class BuienradarServerImpl implements BuienradarServer {

	private BuienradarClient buienradarClient;
	
	public void setBuienradarClient(BuienradarClient buienradarClient) {
		this.buienradarClient = buienradarClient;
	}

	@Override
    public String getWeatherInformation(String id, String debug) {
		Buienradarnl buienradarnl = buienradarClient.getWeatherInformation();
    	return buienradarnl.toString();
    }
	
}
