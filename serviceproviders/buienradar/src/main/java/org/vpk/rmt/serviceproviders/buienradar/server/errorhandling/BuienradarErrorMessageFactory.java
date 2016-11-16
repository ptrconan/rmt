package org.vpk.rmt.serviceproviders.buienradar.server.errorhandling;

//import org.joda.time.DateTime;
import org.joda.time.DateTime;
import org.vpk.rmt.common.datamodel.api.MessageHeaders;

/**
 * Created by Pieter on 9-11-2016.
 */
public class BuienradarErrorMessageFactory implements ErrorMessageFactory {

    private static final long serialVersionUID = 1L;

    private static final String ERROR_CODE = "BuienradarServiceproviderError";
    private static final String ERROR_SOURCE = "buienradar";

    @Override
    public MessageHeaders create(String errorDescription, String transactionId) {
        MessageHeaders messageHeaders = new MessageHeaders();
//        messageHeaders.setCreationTimestamp(DateTime.now().toString());
        messageHeaders.setErrorCode(ERROR_CODE);
        messageHeaders.setErrorDescription(errorDescription);
        messageHeaders.setErrorSource(ERROR_SOURCE);
        messageHeaders.setTransactionId(transactionId);
        return messageHeaders;
    }
}
