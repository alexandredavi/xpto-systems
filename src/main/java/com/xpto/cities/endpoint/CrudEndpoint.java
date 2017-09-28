package com.xpto.cities.endpoint;

import com.xpto.cities.dao.CrudDao;
import com.xpto.cities.entity.BaseEntity;
import com.xpto.cities.service.CrudService;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

public class CrudEndpoint<E extends BaseEntity<ID>, ID, D extends CrudDao<E, ID>, S extends CrudService<E, ID, D>> extends Endpoint {

    @Inject
    Instance<S> service;

    @POST
    public Response insert(E entity) {
        return ok(service.get().insert(entity));
    }

    @PUT
    public Response update(E entity) {
        return ok(service.get().update(entity));
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") ID id) {
        return ok(service.get().findById(id));
    }

    @GET
    public Response findAll() {
        return ok(service.get().findAll());
    }

    @DELETE
    @Path("/{id}")
    public Response remove(@PathParam("id") ID id) {
        service.get().remove(id);
        return ok();
    }
}
