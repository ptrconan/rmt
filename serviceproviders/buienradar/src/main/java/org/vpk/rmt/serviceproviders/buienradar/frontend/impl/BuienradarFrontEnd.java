package org.vpk.rmt.serviceproviders.buienradar.frontend.impl;

import org.vpk.rmt.serviceproviders.buienradar.frontend.api.BuienradarFrontEndApi;

public class BuienradarFrontEnd implements BuienradarFrontEndApi {

	@Override
    public String getWeatherInformation(String id, String debug) {
    	return PATH_ROOT;
    }
	
}
