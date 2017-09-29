package com.xpto.cities.integration;

import com.xpto.cities.FileUtils;
import com.xpto.cities.dto.CitiesByStateDto;
import com.xpto.cities.entity.City;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataOutput;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.util.List;

public class CityTest extends AbstractTest {

    @Test
    @InSequence(1)
    public void importCsv() {
        File file = FileUtils.readFile("cidades.csv");
        MultipartFormDataOutput dataOutput = new MultipartFormDataOutput();
        dataOutput.addFormData("csv", file, MediaType.MULTIPART_FORM_DATA_TYPE);
        GenericEntity<MultipartFormDataOutput> entity = new GenericEntity<MultipartFormDataOutput>(dataOutput) {
        };

        Response response = client.target(url.toString())
                .path("city/import-csv")
                .request()
                .post(Entity.entity(entity, MediaType.MULTIPART_FORM_DATA_TYPE));
        Assert.assertTrue(response.getStatus() == 200);
    }

    @Test
    @InSequence(2)
    public void getCapitals() {
        Response response = client.target(url.toString())
                .path("city/capitals")
                .request(MediaType.APPLICATION_JSON)
                .get();

        Assert.assertTrue(response.getStatus() == 200);

        List<City> cities = response.readEntity(new GenericType<List<City>>() {
        });
        Assert.assertTrue(cities.size() == 27);
    }

    @Test
    @InSequence(3)
    public void statesBiggerAndSmallerNumberOfCities() {
        Response response = client.target(url.toString())
                .path("city/states-bigger-and-smaller-number-of-cities")
                .request(MediaType.APPLICATION_JSON)
                .get();

        Assert.assertTrue(response.getStatus() == 200);

        List<CitiesByStateDto> cities = response.readEntity(new GenericType<List<CitiesByStateDto>>() {
        });

        Assert.assertTrue(cities.size() == 2);
        Assert.assertTrue(cities.get(0).getState().equals("MG"));
        Assert.assertTrue(cities.get(1).getState().equals("DF"));
    }

    @Test
    @InSequence(4)
    public void numberOfCitiesByState() {
        Response response = client.target(url.toString())
                .path("city/number-of-cities-by-state")
                .request(MediaType.APPLICATION_JSON)
                .get();

        Assert.assertTrue(response.getStatus() == 200);

        List<CitiesByStateDto> cities = response.readEntity(new GenericType<List<CitiesByStateDto>>() {
        });

        Assert.assertTrue(cities.size() == 27);
        Assert.assertTrue(cities.get(0).getState().equals("RS"));
        Assert.assertTrue(cities.get(0).getNumber() == 496);
    }

    @Test
    @InSequence(5)
    public void findCityByIbge() {
        Response response = client.target(url.toString())
                .path("city/find-city-by-ibge/1100015")
                .request(MediaType.APPLICATION_JSON)
                .get();

        Assert.assertTrue(response.getStatus() == 200);

        City city = response.readEntity(City.class);
        Assert.assertTrue(city.getName().equals("Alta Floresta D'Oeste"));
    }

    @Test
    @InSequence(6)
    public void findCitiesByState() {
        Response response = client.target(url.toString())
                .path("city/find-cities-by-state/DF")
                .request(MediaType.APPLICATION_JSON)
                .get();

        Assert.assertTrue(response.getStatus() == 200);

        List<City> cities = response.readEntity(new GenericType<List<City>>() {
        });

        Assert.assertTrue(cities.size() == 1);
        Assert.assertTrue(cities.get(0).getUf().equals("DF"));
        Assert.assertTrue(cities.get(0).getName().equals("Braslia"));
    }

    @Test
    @InSequence(7)
    public void findCitiesByCsvColumn() {
        Response response = client.target(url.toString())
                .path("city/find-cities-by-csv-column/mesoregion/LesTe rondoniense")
                .request(MediaType.APPLICATION_JSON)
                .get();

        Assert.assertTrue(response.getStatus() == 200);

        List<City> cities = response.readEntity(new GenericType<List<City>>() {
        });

        Assert.assertTrue(cities.get(0).getUf().equals("RO"));
        Assert.assertTrue(cities.get(0).getName().equals("Alta Floresta D'Oeste"));
    }

    @Test
    @InSequence(8)
    public void countRegisterByColumn() {
        Response response = client.target(url.toString())
                .path("city/count-register-by-column/microregion")
                .request(MediaType.APPLICATION_JSON)
                .get();

        Assert.assertTrue(response.getStatus() == 200);

        Long count = response.readEntity(Long.class);
        Assert.assertTrue(count == 554);
    }

    @Test
    @InSequence(9)
    public void countAll() {
        Response response = client.target(url.toString())
                .path("city/count-all")
                .request(MediaType.APPLICATION_JSON)
                .get();

        Assert.assertTrue(response.getStatus() == 200);

        Long count = response.readEntity(Long.class);
        Assert.assertTrue(count == 5565);
    }

    @Test
    @InSequence(10)
    public void insertAndDelete() {
        Response response = client.target(url.toString())
                .path("city")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(FileUtils.readTextFile("json/city.json")));
        Assert.assertTrue(response.getStatus() == 200);
        City city = response.readEntity(City.class);

        response = client.target(url.toString())
                .path("city/" + city.getId())
                .request(MediaType.APPLICATION_JSON)
                .delete();
        Assert.assertTrue(response.getStatus() == 200);
    }


}
