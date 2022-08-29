package com.epam.elearn.dao;

import java.util.List;

public interface GeneralDao<E, K> {

    void create(E entity) throws DBException;

    List<E> getAll() throws DBException;

    E getEntityById(K id) throws DBException;

    void update(E entity) throws DBException;

    void delete(K id) throws DBException;

}
