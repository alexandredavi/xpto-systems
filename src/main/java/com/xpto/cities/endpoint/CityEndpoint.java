package com.xpto.cities.endpoint;

import com.xpto.cities.dao.CityDao;
import com.xpto.cities.entity.City;
import com.xpto.cities.service.CityService;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Path("/city")
public class CityEndpoint extends CrudEndpoint<City, Long, CityDao, CityService> {

    @POST
    @Path("/import-csv")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response importCsv(@MultipartForm MultipartFormDataInput multipartFormData) throws IOException {
        Map<String, List<InputPart>> formDataMap = multipartFormData.getFormDataMap();
        InputPart inputPart = formDataMap.get("csv").get(0);
        InputStream inputStream = inputPart.getBody(InputStream.class, null);
        service.get().importCsv(inputStream);
        return ok();
    }

    @GET
    @Path("/capitals")
    public Response getCapitals() {
        return ok(service.get().getCapitals());
    }

    @GET
    @Path("/states-bigger-and-smaller-number-of-cities")
    public Response statesBiggerAndSmallerNumberOfCities() {
        return ok(service.get().statesBiggerAndSmallerNumberOfCities());
    }

    @GET
    @Path("/number-of-cities-by-state")
    public Response numberOfCitiesByState() {
        return ok(service.get().numberOfCitiesByState());
    }

    @GET
    @Path("/find-city-by-ibge/{ibge}")
    public Response findCityByIbge(@PathParam("ibge") Integer ibge) {
        return ok(service.get().findCityByIbge(ibge));
    }

    @GET
    @Path("/find-cities-by-state/{state}")
    public Response findCitiesByState(@PathParam("state") String state) {
        return ok(service.get().findCitiesByState(state));
    }

    @GET
    @Path("/find-cities-by-csv-column/{column}/{filter}")
    public Response findCitiesByCsvColumn(@PathParam("column") String column, @PathParam("filter") String filter) {
        return ok(service.get().findCitiesByCsvColumn(column, filter));
    }

    @GET
    @Path("/count-register-by-column/{column}")
    public Response countRegisterByColumn(@PathParam("column") String column) {
        return ok(service.get().countRegisterByColumn(column));
    }

    @GET
    @Path("/count-all")
    public Response countAll() {
        return ok(service.get().findAll().size());
    }

}
