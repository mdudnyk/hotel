package com.epam.elearn.dao.mysql;

import com.epam.elearn.dao.ConnectionManager;
import com.epam.elearn.dao.DBException;
import com.epam.elearn.dao.RoomDao;
import com.epam.elearn.entity.Room;
import com.epam.elearn.entity.RoomStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDaoImpl implements RoomDao {
    private final ConnectionManager connectionPool;

    public RoomDaoImpl(ConnectionManager connectionManager) {
        connectionPool = connectionManager;
    }

    @Override
    public void create(final Room entity) throws DBException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(Queries.CREATE_ROOM)) {
            ps.setInt(1, entity.getRoomNumber());
            ps.setInt(2, entity.getCategoryId());
            ps.setString(3, entity.getCurrentStatus().name());
            ps.execute();
        } catch (SQLException e) {
            throw new DBException("Can not add new room to the database. ", e);
        }
    }

    @Override
    public List<Room> getAll() throws DBException {
        List<Room> rooms = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(Queries.GET_ALL_ROOMS);
             ResultSet rs = ps.getResultSet()) {
            while (rs.next()) {
                rooms.add(fillEntityFromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new DBException("Error while trying to get rooms list from database. " + e);
        }

        return rooms;
    }

    @Override
    public Room getEntityById(final Integer roomNumber) throws DBException {
        Room room;

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(Queries.GET_ROOM_BY_ROOM_NUMBER)) {
            ps.setInt(1, roomNumber);
            ResultSet rs = ps.executeQuery();
            rs.next();
            room = fillEntityFromResultSet(rs);
            rs.close();
        } catch (SQLException e) {
            throw new DBException("Error while trying to get room by it`s number. " + e);
        }

        return room;
    }

    @Override
    public void update(final Integer roomNumber, final Room entity) throws DBException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(Queries.UPDATE_ROOM)) {
            ps.setInt(1, entity.getRoomNumber());
            ps.setInt(2, entity.getCategoryId());
            ps.setString(3, entity.getCurrentStatus().name());
            ps.setInt(4, roomNumber);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("Can not update room in database. ", e);
        }
    }

    @Override
    public void delete(final Integer roomNumber) throws DBException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(Queries.DELETE_ROOM)) {
            ps.setInt(1, roomNumber);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("Can not delete room from database. ", e);
        }
    }

    private Room fillEntityFromResultSet(ResultSet resultSet) throws SQLException {
        int roomNumber = resultSet.getInt(1);
        int categoryId = resultSet.getInt(2);
        RoomStatus status = RoomStatus.valueOf(resultSet.getString(3));

        return new Room(roomNumber, categoryId, status);
    }
}
