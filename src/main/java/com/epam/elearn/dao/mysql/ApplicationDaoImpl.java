package com.epam.elearn.dao.mysql;

import com.epam.elearn.dao.ApplicationDao;
import com.epam.elearn.dao.ConnectionManager;
import com.epam.elearn.dao.DBException;
import com.epam.elearn.entity.Application;
import com.epam.elearn.entity.enums.ApplicationStatus;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class ApplicationDaoImpl implements ApplicationDao {
    private final ConnectionManager connectionPool;

    public ApplicationDaoImpl(ConnectionManager connectionManager) {
        connectionPool = connectionManager;
    }

    @Override
    public void create(final Application entity) throws DBException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(Queries.CREATE_APPLICATION, Statement.RETURN_GENERATED_KEYS)) {
            fillPreparedStatement(ps, entity);
            if (ps.executeUpdate() > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        entity.setId(rs.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            throw new DBException("Can not add new application to the database. ", e);
        }
    }

    @Override
    public List<Application> getAll() throws DBException {
        List<Application> applications = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(Queries.GET_ALL_APPLICATIONS);
             ResultSet resultSet = ps.executeQuery()) {
            while (resultSet.next()) {
                applications.add(fillEntityFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new DBException("Error while trying to get applications list from database. " + e);
        }

        return applications;
    }

    @Override
    public Application getEntityById(final Integer id) throws DBException {
        Application application;

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(Queries.GET_APPLICATION_BY_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            application = fillEntityFromResultSet(rs);
            rs.close();
        } catch (SQLException e) {
            throw new DBException("Error while trying to get application by it`s id. " + e);
        }

        return application;
    }

    @Override
    public void update(final Integer id, final Application entity) throws DBException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(Queries.UPDATE_APPLICATION)) {
            fillPreparedStatement(ps, entity);
            ps.setInt(9, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("Can not update application in database. ", e);
        }
    }

    @Override
    public void delete(final Integer id) throws DBException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(Queries.DELETE_APPLICATION)) {

            //TODO  Implement realisation of code that delete all bookings and applications of user

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("Can not delete application from database. ", e.getMessage());
        }
    }

    private void fillPreparedStatement(PreparedStatement ps, Application entity) throws SQLException {
        ps.setInt(1, entity.getId());
        ps.setInt(2, entity.getUserId());
        ps.setInt(3, entity.getCategoryId());
        ps.setInt(4, entity.getNumberOfGuests());
        ps.setString(5, entity.getCurrentStatus().name());
        ps.setDate(6, Date.valueOf(entity.getCheckInDate()));
        ps.setDate(7, Date.valueOf(entity.getCheckOutDate()));
        ps.setDate(8, Date.valueOf(entity.getLastUpdate()));
    }

    private Application fillEntityFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        int userId = resultSet.getInt(2);
        int categoryId = resultSet.getInt(3);
        int numberOfGuests = resultSet.getInt(4);
        ApplicationStatus currentStatus = ApplicationStatus.valueOf(resultSet.getString(5));
        LocalDate checkInDate = resultSet.getDate(6).toLocalDate();
        LocalDate checkOutDate = resultSet.getDate(7).toLocalDate();
        LocalDate lastUpdate = resultSet.getDate(8).toLocalDate();

        return new Application(id, userId, categoryId, numberOfGuests,
                currentStatus, checkInDate, checkOutDate, lastUpdate);
    }
}
