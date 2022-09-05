package com.epam.elearn.dao.mysql;

import com.epam.elearn.dao.ConnectionPoolManager;
import com.epam.elearn.dao.DBException;
import com.epam.elearn.dao.RoomDao;
import com.epam.elearn.entity.Room;

import java.sql.Connection;
import java.util.List;

public class RoomDaoImpl implements RoomDao {
    private final ConnectionPoolManager connectionPool;
    private final DBManagerMySQL dbManager;
    private Connection connection;

    public RoomDaoImpl(ConnectionPoolManager connectionPoolManager) {
        connectionPool = connectionPoolManager;
        dbManager = new DBManagerMySQL();
    }

    @Override
    public void create(final Room entity) throws DBException {

    }

    @Override
    public List<Room> getAll() throws DBException {
        return null;
    }

    @Override
    public Room getEntityById(final Integer id) throws DBException {
        return null;
    }

    @Override
    public void update(final Room entity) throws DBException {

    }

    @Override
    public void delete(final Integer id) throws DBException {

    }
}
