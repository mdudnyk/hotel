package com.epam.elearn.dao.mysql;

import com.epam.elearn.dao.ConnectionPoolManager;
import com.epam.elearn.dao.DBException;
import com.epam.elearn.dao.RoomCategoryDao;
import com.epam.elearn.entity.RoomCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class RoomCategoryDaoImpl implements RoomCategoryDao {
    private final ConnectionPoolManager connectionPool;
    private final DBManagerMySQL dbManager;
    private Connection connection;

    public RoomCategoryDaoImpl(ConnectionPoolManager connectionPoolManager) {
        connectionPool = connectionPoolManager;
        dbManager = new DBManagerMySQL();
    }

    @Override
    public void create(final RoomCategory entity) throws DBException {
        connection = connectionPool.getConnection();

        try (PreparedStatement ps = dbManager.getPrepareStmt(connection, Queries.CREATE_ROOM_CATEGORY)) {
            fillPreparedStatement(ps, entity);
            ps.execute();
        } catch (SQLException e) {
            throw new DBException("Can not add new room category to the database. ", e);
        }

        dbManager.returnConnection(connection);
    }

    @Override
    public List<RoomCategory> getAll() throws DBException {
        connection = connectionPool.getConnection();
        List<RoomCategory> list = new ArrayList<>();

        try (ResultSet resultSet = dbManager.getResultSet(connection, Queries.GET_ALL_ROOM_CATEGORY)) {
            while (resultSet.next()) {
                list.add(fillEntityFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new DBException("Error while trying to get room categories list from database. " + e);
        }

        dbManager.returnConnection(connection);
        return list;
    }

    @Override
    public RoomCategory getEntityById(final Integer id) throws DBException {
        connection = connectionPool.getConnection();
        RoomCategory roomCategory;

        try (ResultSet resultSet = dbManager.getResultSet(connection, Queries.GET_ROOM_CATEGORY_BY_ID, id)) {
            resultSet.next();
            roomCategory = fillEntityFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DBException("Error while trying to get room category by it`s id. " + e);
        }

        dbManager.returnConnection(connection);
        return roomCategory;
    }

    @Override
    public void update(final RoomCategory entity) throws DBException {
        connection = connectionPool.getConnection();

        try (PreparedStatement ps = dbManager.getPrepareStmt(connection, Queries.UPDATE_ROOM_CATEGORY)) {

            //TODO  Implement realisation of code that checks if such room category exists
            //      in someones booking or application and forbids to update in case of it

            fillPreparedStatement(ps, entity);
            ps.setInt(6, entity.id());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("Can not update room category in database. ", e);
        }

        dbManager.returnConnection(connection);
    }

    @Override
    public void delete(final Integer id) throws DBException {
        connection = connectionPool.getConnection();

        try (PreparedStatement ps = dbManager.getPrepareStmt(connection, Queries.DELETE_ROOM_CATEGORY)) {

            //TODO  Implement realisation of code that checks if such room category exists
            //      in someones booking or application and forbids to delete in case of it

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("Can not delete room category from database. ", e.getMessage());
        }

        dbManager.returnConnection(connection);
    }

    private void fillPreparedStatement(PreparedStatement ps, RoomCategory entity) throws SQLException {
        ps.setString(1, entity.title());
        ps.setInt(2, entity.priceDefault());
        ps.setInt(3, entity.area());
        ps.setInt(4, entity.guestsCapacity());
        ps.setString(5, entity.description());
    }

    private RoomCategory fillEntityFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        String title = resultSet.getString(2);
        int priceDefault = resultSet.getInt(3);
        int area = resultSet.getInt(4);
        int guestCapacity = resultSet.getInt(5);
        String description = resultSet.getString(6);

        return new RoomCategory(id, title, priceDefault, area, guestCapacity, description);
    }
}
