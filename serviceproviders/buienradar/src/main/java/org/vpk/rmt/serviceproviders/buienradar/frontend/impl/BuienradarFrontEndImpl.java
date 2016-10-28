package org.vpk.rmt.serviceproviders.buienradar.frontend.impl;

import org.vpk.rmt.serviceproviders.buienradar.frontend.api.BuienradarFrontEnd;

public class BuienradarFrontEndImpl implements BuienradarFrontEnd {

	@Override
    public String getWeatherInformation(String id, String debug) {
    	return PATH_ROOT;
    }
	
}
