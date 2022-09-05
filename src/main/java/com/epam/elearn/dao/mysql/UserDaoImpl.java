package com.epam.elearn.dao.mysql;

import com.epam.elearn.dao.ConnectionManager;
import com.epam.elearn.dao.UserDao;
import com.epam.elearn.entity.User;
import com.epam.elearn.dao.DBException;
import com.epam.elearn.entity.UserRoles;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class UserDaoImpl implements UserDao {
    private final ConnectionManager connectionPool;

    public UserDaoImpl(ConnectionManager connectionManager) {
        connectionPool = connectionManager;
    }

    @Override
    public void create(final User entity) throws DBException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(Queries.CREATE_USER, Statement.RETURN_GENERATED_KEYS)) {
            fillPreparedStatement(ps, entity);
            if (ps.executeUpdate() > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        entity.setId(rs.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            throw new DBException("Can not add new user to the database. ", e);
        }
    }

    @Override
    public List<User> getAll() throws DBException {
        List<User> users = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(Queries.GET_ALL_USERS);
             ResultSet resultSet = ps.executeQuery()) {
            while (resultSet.next()) {
                users.add(fillEntityFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new DBException("Error while trying to get users list from database. " + e);
        }

        return users;
    }

    @Override
    public User getEntityById(final Integer id) throws DBException {
        User user;

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(Queries.GET_USER_BY_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            user = fillEntityFromResultSet(rs);
            rs.close();
        } catch (SQLException e) {
            throw new DBException("Error while trying to get user by it`s id. " + e);
        }

        return user;
    }

    @Override
    public User getUserByEmail(final String email) throws DBException {
        User user;

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(Queries.GET_USER_BY_EMAIL)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            rs.next();
            user = fillEntityFromResultSet(rs);
            rs.close();
        } catch (SQLException e) {
            throw new DBException("Error while trying to get user by it`s id. " + e);
        }

        return user;
    }

    @Override
    public boolean checkIfEmailExists(final String email) throws DBException {
        boolean isEmailExists = true;

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement pSt = connection.prepareStatement(Queries.CHECK_IF_EMAIL_EXISTS)) {
            pSt.setString(1, email);
            ResultSet rs = pSt.executeQuery();
            rs.next();
            isEmailExists = rs.getBoolean(1);
            rs.close();
        } catch (SQLException e) {
            throw new DBException("Error while trying to check if given email has already exist in user table: " + email + ". " + e);
        }

        return isEmailExists;
    }

    @Override
    public void update(final Integer id, final User entity) throws DBException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(Queries.UPDATE_USER)) {
            fillPreparedStatement(ps, entity);
            ps.setInt(6, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("Can not update user in database. ", e);
        }
    }

    @Override
    public void delete(final Integer id) throws DBException {
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(Queries.DELETE_USER)) {

            //TODO  Implement realisation of code that delete all bookings and applications of user

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("Can not delete room category from database. ", e.getMessage());
        }
    }

    private void fillPreparedStatement(PreparedStatement ps, User entity) throws SQLException {
        ps.setString(1, entity.getName());
        ps.setString(2, entity.getSurname());
        ps.setString(3, entity.getEmail());
        ps.setString(4, entity.getPassword());
        ps.setString(5, entity.getRole().name());
    }

    private User fillEntityFromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        String name = resultSet.getString(2);
        String surname = resultSet.getString(3);
        String email = resultSet.getString(4);
        String password = resultSet.getString(5);
        UserRoles role = UserRoles.valueOf(resultSet.getString(6));

        return new User(id, name, surname, email, password, role);
    }
}
