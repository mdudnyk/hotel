package com.epam.elearn.dao.mysql;

import com.epam.elearn.dao.BookingDao;
import com.epam.elearn.dao.ConnectionManager;
import com.epam.elearn.dao.DBException;
import com.epam.elearn.entity.Booking;
import com.epam.elearn.entity.BookingStatus;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingDaoImpl implements BookingDao {
    private final ConnectionManager connectionPool;

    public BookingDaoImpl(ConnectionManager connectionManager) {
        connectionPool = connectionManager;
    }

    @Override
    public void create(final Booking entity) throws DBException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(Queries.CREATE_BOOKING, Statement.RETURN_GENERATED_KEYS)) {
            fillPreparedStatement(ps, entity);
            if (ps.executeUpdate() > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        entity.setId(rs.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            throw new DBException("Can not add new booking to the database. ", e);
        }
    }

    @Override
    public List<Booking> getAll() throws DBException {
        List<Booking> bookings = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(Queries.GET_ALL_BOOKINGS);
             ResultSet resultSet = ps.executeQuery()) {
            while (resultSet.next()) {
                bookings.add(fillEntityFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new DBException("Error while trying to get bookings list from database. " + e);
        }

        return bookings;
    }

    @Override
    public Booking getEntityById(final Integer id) throws DBException {
        Booking booking;

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(Queries.GET_BOOKING_BY_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            booking = fillEntityFromResultSet(rs);
            rs.close();
        } catch (SQLException e) {
            throw new DBException("Error while trying to get booking by it`s id. " + e);
        }

        return booking;
    }

    @Override
    public void update(final Integer id, final Booking entity) throws DBException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(Queries.UPDATE_BOOKING)) {
            fillPreparedStatement(ps, entity);
            ps.setInt(10, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("Can not update booking in database. ", e);
        }
    }

    @Override
    public void delete(final Integer id) throws DBException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(Queries.DELETE_BOOKING)) {

            //TODO  Implement realisation of code that delete all bookings and applications of user

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("Can not delete booking from database. ", e.getMessage());
        }
    }

    private void fillPreparedStatement(PreparedStatement ps, Booking entity) throws SQLException {
        ps.setInt(1, entity.getId());
        ps.setInt(2, entity.getUserId());
        ps.setInt(3, entity.getNumberOfGuests());
        ps.setInt(4, entity.getRoomsAmount());
        ps.setInt(5, entity.getTotalPrice());
        ps.setString(6, entity.getBookingStatus().name());
        ps.setDate(7, Date.valueOf(entity.getCheckInDate()));
        ps.setDate(8, Date.valueOf(entity.getCheckOutDate()));
        ps.setDate(9, Date.valueOf(entity.getLastUpdate()));
    }

    private Booking fillEntityFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        int userId = resultSet.getInt(2);
        int numberOfGuests = resultSet.getInt(3);
        int roomsAmount = resultSet.getInt(4);
        int totalPrice = resultSet.getInt(5);
        BookingStatus bookingStatus = BookingStatus.valueOf(resultSet.getString(6));
        LocalDate checkInDate = resultSet.getDate(7).toLocalDate();
        LocalDate checkOutDate = resultSet.getDate(8).toLocalDate();
        LocalDate lastUpdate = resultSet.getDate(9).toLocalDate();

        return new Booking(id, userId, numberOfGuests, roomsAmount, totalPrice,
                bookingStatus, checkInDate, checkOutDate, lastUpdate);
    }
}
