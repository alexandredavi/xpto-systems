package com.xpto.cities.exception;

import javax.ejb.EJBException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CustomExceptionMapper implements ExceptionMapper<Exception> {

    private static final String INVALID_COLUMN = "%s is not a valid column";

    @Override
    public Response toResponse(Exception e) {
        if (e instanceof EJBException) {
            Exception cause = ((EJBException) e).getCausedByException();
            if (cause instanceof InvalidColumnNameException) {
                String message = String.format(INVALID_COLUMN, ((InvalidColumnNameException) cause).getColumn());
                return buildResponse(message, MediaType.TEXT_PLAIN, Response.Status.BAD_REQUEST);
            }
        }
        return buildResponse(e.getMessage(), MediaType.TEXT_PLAIN, Response.Status.BAD_REQUEST);
    }

    private Response buildResponse(Object entity, String mediaType, Response.Status status) {
        Response.ResponseBuilder builder = Response.status(status).entity(entity);
        builder.type(mediaType);
        builder.header("validation-exception", "true");
        return builder.build();
    }
}
