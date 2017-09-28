package com.xpto.cities.dao;

import com.xpto.cities.dto.CitiesByStateDto;
import com.xpto.cities.entity.City;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class CityDao extends LogicExclusionCrudDao<City, Long> {

    public List<City> getCapitals() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT c FROM City c ");
        sb.append("WHERE c.capital = TRUE ");
        sb.append("ORDER BY c.name ");

        TypedQuery<City> query = em.createQuery(sb.toString(), City.class);
        return query.getResultList();
    }

    public List<CitiesByStateDto> numberOfCitiesByState() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append("new ").append(CitiesByStateDto.class.getName());
        sb.append("(c.uf, COUNT(c)) ");
        sb.append("FROM City c ");
        sb.append("GROUP BY c.uf ");

        TypedQuery<CitiesByStateDto> query = em.createQuery(sb.toString(), CitiesByStateDto.class);
        return query.getResultList();
    }
}