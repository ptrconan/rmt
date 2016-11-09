package org.vpk.rmt.serviceproviders.buienradar.server.errorhandling;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.vpk.rmt.serviceproviders.buienradar.server.transactions.TransactionId;

/**
 * Created by Pieter on 9-11-2016.
 */
public class CatchAllExceptionMapper implements ExceptionMapper<Throwable> {

    private static final long serialVersionUID = 1L;

    private final ErrorMessageFactory errorMessageFactory;

    public CatchAllExceptionMapper(ErrorMessageFactory errorMessageFactory) {
        this.errorMessageFactory = errorMessageFactory;
    }

    @Override
    public Response toResponse(Throwable exception) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(errorMessageFactory.create(exception.getMessage(), TransactionId.retrieve()))
                .build();
    }
}
