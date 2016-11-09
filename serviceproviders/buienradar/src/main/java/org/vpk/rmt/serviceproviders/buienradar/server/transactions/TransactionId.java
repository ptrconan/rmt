package org.vpk.rmt.serviceproviders.buienradar.server.transactions;

import java.util.UUID;
import org.slf4j.MDC;

/**
 * Created by Pieter on 9-11-2016.
 */
public final class TransactionId {

    private static final long serialVersionUID = 1L;

    public static final String HEADER_NAME = "X-Request-ID";

    private TransactionId() {
    }

    /**
     * Retrieves the correlation ID from the MDC. Returns {@code null} when no correlation ID was set.
     *
     * @return Correlation ID or {@code null}
     */
    public static String retrieve() {
        return MDC.get(HEADER_NAME);
    }

    public static String generate() {
        return UUID.randomUUID().toString();
    }
}
