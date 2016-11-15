package org.vpk.rmt.serviceproviders.buienradar.server.api;

import org.vpk.rmt.serviceproviders.buienradar.server.api.BuienradarServerException;

/**
 * Created by Pieter on 15-11-2016.
 */
public class BuienradarWeerstationNotFoundException extends BuienradarServerException {

    private static final long serialVersionUID = 1L;

    public BuienradarWeerstationNotFoundException() { super();}

    public BuienradarWeerstationNotFoundException(String message) { super(message);}
}
