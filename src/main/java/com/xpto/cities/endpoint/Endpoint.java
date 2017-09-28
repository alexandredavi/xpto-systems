package com.xpto.cities.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public abstract class Endpoint {

    public Response ok() {
        return Response.ok().build();
    }

    public Response ok(Object o) {
        return Response.ok(o).build();
    }

    public Response notFound() {
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    public Response created(Object o) {
        return Response.status(Response.Status.CREATED).build();
    }
}
