package com.epam.elearn.dao;

import java.util.List;

public interface CommonDao<E, K> {

    void create(E entity) throws DBException;

    List<E> getAll();

    E getEntityById(K id);

    void update(E entity);

    void delete(E id);

}
