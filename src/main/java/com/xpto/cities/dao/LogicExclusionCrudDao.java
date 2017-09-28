package com.xpto.cities.dao;

import com.xpto.cities.entity.BaseEntity;
import com.xpto.cities.entity.LogicExclusion;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

public abstract class LogicExclusionCrudDao<E extends BaseEntity<ID> & LogicExclusion, ID extends Serializable> extends CrudDao<E, ID> {

    @Override
    public void remove(ID id) {
        E entity = findById(id);
        if (entity != null) {
            entity.setExcluded(true);
        }
    }
}
