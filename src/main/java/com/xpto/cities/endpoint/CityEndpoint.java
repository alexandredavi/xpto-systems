package com.xpto.cities.endpoint;

import com.xpto.cities.dao.CityDao;
import com.xpto.cities.entity.City;
import com.xpto.cities.service.CityService;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
}
