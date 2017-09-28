package com.xpto.cities.service;

import com.xpto.cities.dao.CityDao;
import com.xpto.cities.entity.City;

import javax.ejb.Stateless;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import static com.xpto.cities.utils.CsvUtils.*;

@Stateless
public class CityService extends CrudService<City, Long, CityDao> {

    public void importCsv(InputStream inputStream) throws IOException {
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream))) {
            List<City> cities = buffer.lines().skip(1).map((String line) -> {
                String[] coluns = line.split(",");
                City city = new City();
                city.setIbge(getIntegerValue(coluns[0]));
                city.setUf(getStringValue(coluns[1]));
                city.setName(getStringValue(coluns[2]));
                city.setCapital(getBooleanValue(coluns[3]));
                city.setLongitude(getBigDecimalValue(coluns[4]));
                city.setLatitude(getBigDecimalValue(coluns[5]));
                city.setNoAccentsName(getStringValue(coluns[6]));
                city.setAlternativenames(getStringValue(coluns[7]));
                city.setMicroRegion(getStringValue(coluns[8]));
                city.setMesoregion(getStringValue(coluns[9]));
                return city;
            }).collect(Collectors.toList());
            insert(cities);
        }
    }
}
