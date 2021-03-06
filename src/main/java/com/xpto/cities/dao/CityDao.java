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
        sb.append("AND").append(notExcludedFilter());
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
        sb.append("WHERE").append(notExcludedFilter());
        sb.append("GROUP BY c.uf ");

        TypedQuery<CitiesByStateDto> query = em.createQuery(sb.toString(), CitiesByStateDto.class);
        return query.getResultList();
    }

    public City findCityByIbge(Integer igbe) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT c FROM City c ");
        sb.append("WHERE c.ibge = :ibge ");
        sb.append("AND").append(notExcludedFilter());

        TypedQuery<City> query = em.createQuery(sb.toString(), City.class);
        query.setParameter("ibge", igbe);
        query.setMaxResults(1);

        return query.getSingleResult();
    }

    public List<City> findCitiesByState(String state) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT c FROM City c ");
        sb.append("WHERE c.uf = :uf ");
        sb.append("AND").append(notExcludedFilter());

        TypedQuery<City> query = em.createQuery(sb.toString(), City.class);
        query.setParameter("uf", state);

        return query.getResultList();
    }

    public List<City> findCitiesByAttribute(String attribute, String filter) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT c FROM City c ");
        sb.append("WHERE UPPER(CAST(c.").append(attribute).append(" AS string)) = UPPER(:filter) ");
        sb.append("AND").append(notExcludedFilter());

        TypedQuery<City> query = em.createQuery(sb.toString(), City.class);
        query.setParameter("filter", filter);

        return query.getResultList();
    }

    public Long countRegisterByAttribute(String attribute) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT COUNT(DISTINCT c.").append(attribute).append(") FROM City c ");
        sb.append("WHERE").append(notExcludedFilter());

        TypedQuery<Long> query = em.createQuery(sb.toString(), Long.class);
        query.setMaxResults(1);

        return query.getSingleResult();
    }

    private String notExcludedFilter() {
        return " c.excluded = FALSE ";
    }
}
