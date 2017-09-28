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
                String[] columns = line.split(",");
                City city = new City();
                city.setIbge(getIntegerValue(columns[0]));
                city.setUf(getStringValue(columns[1]));
                city.setName(getStringValue(columns[2]));
                city.setCapital(getBooleanValue(columns[3]));
                city.setLongitude(getBigDecimalValue(columns[4]));
                city.setLatitude(getBigDecimalValue(columns[5]));
                city.setNoAccentsName(getStringValue(columns[6]));
                city.setAlternativenames(getStringValue(columns[7]));
                city.setMicroRegion(getStringValue(columns[8]));
                city.setMesoregion(getStringValue(columns[9]));
                return city;
            }).collect(Collectors.toList());
            insert(cities);
        }
    }

    public List<City> getCapitals() {
        return dao.get().getCapitals();
    }
}
