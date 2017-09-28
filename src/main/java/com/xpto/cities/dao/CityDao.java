package com.xpto.cities.dao;

import com.xpto.cities.entity.City;

import javax.ejb.Stateless;

@Stateless
public class CityDao extends LogicExclusionCrudDao<City, Long> {
}
