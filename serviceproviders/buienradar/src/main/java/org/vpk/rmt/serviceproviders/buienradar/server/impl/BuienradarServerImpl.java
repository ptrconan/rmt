package org.vpk.rmt.serviceproviders.buienradar.server.impl;

import java.util.List;
import java.util.Optional;

import org.vpk.rmt.serviceproviders.buienradar.client.api.BuienradarClient;
import org.vpk.rmt.serviceproviders.buienradar.client.datamodel.Buienradarnl;
import org.vpk.rmt.serviceproviders.buienradar.client.datamodel.Weerstation;
import org.vpk.rmt.serviceproviders.buienradar.server.api.BuienradarServer;

public class BuienradarServerImpl implements BuienradarServer {

	private BuienradarClient buienradarClient;
	
	public void setBuienradarClient(BuienradarClient buienradarClient) {
		this.buienradarClient = buienradarClient;
	}

	@Override
    public String getWeatherInformation(String stationName, String debug) {
		Buienradarnl buienradarnl = buienradarClient.getWeatherInformationNl();
		
		List<Weerstation> weerStations = buienradarnl.getWeergegevens().getActueelWeer().getWeerstations().getWeerstation();
		Optional<Weerstation> weerStation = weerStations.stream()
			.filter(x -> x.getStationnaam().getValue().equals(stationName))
			.findFirst();
		
		if (weerStation.isPresent()) {
			return String.valueOf(weerStation.get().getTemperatuurGC());
		}
		
    	return "no weather information available";
    }
	
}
