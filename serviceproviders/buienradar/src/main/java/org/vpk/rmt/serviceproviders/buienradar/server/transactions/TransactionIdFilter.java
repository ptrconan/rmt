package org.vpk.rmt.serviceproviders.buienradar.server.transactions;

import javax.annotation.Priority;
import javax.ws.rs.container.*;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import org.slf4j.MDC;

import static org.vpk.rmt.serviceproviders.buienradar.server.transactions.TransactionId.HEADER_NAME;

/**
 * Created by Pieter on 9-11-2016.
 */
@Provider
@Priority(TransactionIdFilter.PRIORITY_BEFORE_ANY_OTHER_FILTERS)
@PreMatching
public class TransactionIdFilter implements ContainerRequestFilter, ContainerResponseFilter {

    private static final long serialVersionUID = 1L;

    static final int PRIORITY_BEFORE_ANY_OTHER_FILTERS = 0;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String reqId = requestContext.getHeaders().entrySet().stream()
                .filter(x -> HEADER_NAME.equalsIgnoreCase(x.getKey()))
                .flatMap(x -> x.getValue().stream())
                .findFirst()
                .orElseGet(TransactionId::generate);
        MDC.put(HEADER_NAME, reqId);
    }

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException {
        MDC.remove(HEADER_NAME);
    }
}
