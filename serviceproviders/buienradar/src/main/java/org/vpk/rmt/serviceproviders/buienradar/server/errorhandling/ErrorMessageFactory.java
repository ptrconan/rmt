package org.vpk.rmt.serviceproviders.buienradar.server.errorhandling;

/**
 * Created by Pieter on 9-11-2016.
 */
public interface ErrorMessageFactory {

    String create(String errorDescription, String transactionId);
}
