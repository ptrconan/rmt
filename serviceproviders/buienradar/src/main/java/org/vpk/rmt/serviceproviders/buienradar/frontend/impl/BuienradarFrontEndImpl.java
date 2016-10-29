package org.vpk.rmt.serviceproviders.buienradar.frontend.impl;

import org.vpk.rmt.serviceproviders.buienradar.backend.api.BuienradarBackEnd;
import org.vpk.rmt.serviceproviders.buienradar.backend.datamodel.Buienradarnl;
import org.vpk.rmt.serviceproviders.buienradar.frontend.api.BuienradarFrontEnd;

public class BuienradarFrontEndImpl implements BuienradarFrontEnd {

	private BuienradarBackEnd buienradarBackEnd;
	
	public void setBuienradarBackEnd(BuienradarBackEnd buienradarBackEnd) {
		this.buienradarBackEnd = buienradarBackEnd;
	}

	@Override
    public String getWeatherInformation(String id, String debug) {
		Buienradarnl buienradarnl = buienradarBackEnd.getWeatherInformation();
    	return buienradarnl.toString();
    }
	
}
