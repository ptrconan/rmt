package org.vpk.rmt.serviceproviders.buienradar.server.errorhandling;


import org.vpk.rmt.common.datamodel.api.MessageHeaders;

/**
 * Created by Pieter on 9-11-2016.
 */
public interface ErrorMessageFactory {

    MessageHeaders create(String errorDescription, String transactionId);
}
