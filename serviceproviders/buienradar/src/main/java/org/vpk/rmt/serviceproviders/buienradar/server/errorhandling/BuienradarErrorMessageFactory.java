package org.vpk.rmt.serviceproviders.buienradar.server.errorhandling;

/**
 * Created by Pieter on 9-11-2016.
 */
public class BuienradarErrorMessageFactory implements ErrorMessageFactory {

    private static final long serialVersionUID = 1L;

    @Override
    public String create(String errorDescription, String transactionId) {
        // TODO: add DateTime.now().toString()
        // TODO: add ERROR_SOURCE
        // TODO: add ERROR_CODE
        return "{errorDescription:\"" + errorDescription + "\",transactionId:\"" + transactionId + "\"}";
    }
}
