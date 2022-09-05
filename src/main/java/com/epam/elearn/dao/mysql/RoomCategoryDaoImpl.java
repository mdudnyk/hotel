package com.epam.elearn.dao.mysql;

import com.epam.elearn.dao.ConnectionManager;
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
    private final ConnectionManager connectionPool;

    public RoomCategoryDaoImpl(ConnectionManager connectionManager) {
        connectionPool = connectionManager;
    }

    @Override
    public void create(final RoomCategory entity) throws DBException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(Queries.CREATE_ROOM_CATEGORY)) {
            fillPreparedStatement(ps, entity);
            if (ps.executeUpdate() > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        entity.setId(rs.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            throw new DBException("Can not add new room category to the database. ", e);
        }
    }

    @Override
    public List<RoomCategory> getAll() throws DBException {
        List<RoomCategory> list = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(Queries.GET_ALL_ROOM_CATEGORY);
             ResultSet rs = ps.getResultSet()) {
            while (rs.next()) {
                list.add(fillEntityFromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new DBException("Error while trying to get room categories list from database. " + e);
        }

        return list;
    }

    @Override
    public RoomCategory getEntityById(Integer id) throws DBException {
        RoomCategory roomCategory;

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(Queries.GET_ROOM_CATEGORY_BY_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.getResultSet();
            rs.next();
            roomCategory = fillEntityFromResultSet(rs);
            rs.close();
        } catch (SQLException e) {
            throw new DBException("Error while trying to get room category by it`s id. " + e);
        }

        return roomCategory;
    }

    @Override
    public void update(final Integer id, final RoomCategory entity) throws DBException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(Queries.UPDATE_ROOM_CATEGORY)) {

            //TODO  Implement realisation of code that checks if such room category exists
            //      in someones booking or application and forbids to update in case of it

            fillPreparedStatement(ps, entity);
            ps.setInt(6, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("Can not update room category in database. ", e);
        }
    }

    @Override
    public void delete(final Integer id) throws DBException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(Queries.DELETE_ROOM_CATEGORY)) {

            //TODO  Implement realisation of code that checks if such room category exists
            //      in someones booking or application and forbids to delete in case of it

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("Can not delete room category from database. ", e.getMessage());
        }
    }

    private void fillPreparedStatement(PreparedStatement ps, RoomCategory entity) throws SQLException {
        ps.setString(1, entity.getTitle());
        ps.setInt(2, entity.getPriceDefault());
        ps.setInt(3, entity.getArea());
        ps.setInt(4, entity.getGuestsCapacity());
        ps.setString(5, entity.getDescription());
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
