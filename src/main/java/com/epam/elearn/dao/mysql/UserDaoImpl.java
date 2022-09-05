package com.epam.elearn.dao.mysql;

import com.epam.elearn.dao.ConnectionPoolManager;
import com.epam.elearn.dao.UserDao;
import com.epam.elearn.entity.User;
import com.epam.elearn.dao.DBException;
import com.epam.elearn.entity.UserRoles;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class UserDaoImpl implements UserDao {
    private final ConnectionPoolManager connectionPool;
    private final DBManagerMySQL dbManager;
    private Connection connection;

    public UserDaoImpl(ConnectionPoolManager connectionPoolManager) {
        connectionPool = connectionPoolManager;
        dbManager = new DBManagerMySQL();
    }

    @Override
    public void create(final User entity) throws DBException {
        connection = connectionPool.getConnection();

        try (PreparedStatement ps = dbManager.getPrepareStmt(connection,
                Queries.CREATE_USER, Statement.RETURN_GENERATED_KEYS)) {
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

        dbManager.returnConnection(connection);
    }

    @Override
    public List<User> getAll() throws DBException {
        connection = connectionPool.getConnection();
        List<User> list = new ArrayList<>();

        try (ResultSet resultSet = dbManager.getResultSet(connection, Queries.GET_ALL_USERS)) {
            while (resultSet.next()) {
                list.add(fillEntityFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new DBException("Error while trying to get users list from database. " + e);
        }

        dbManager.returnConnection(connection);
        return list;
    }

    @Override
    public User getEntityById(final Integer id) throws DBException {
        connection = connectionPool.getConnection();
        User user;

        try (ResultSet resultSet = dbManager.getResultSet(connection, Queries.GET_USER_BY_ID, id)) {
            resultSet.next();
            user = fillEntityFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DBException("Error while trying to get user by it`s id. " + e);
        }

        dbManager.returnConnection(connection);
        return user;
    }

    @Override
    public User getUserByEmail(final String email) throws DBException {
        connection = connectionPool.getConnection();
        User user;

        try (PreparedStatement pSt = connection.prepareStatement(Queries.GET_USER_BY_EMAIL)) {
            pSt.setString(1, email);
            ResultSet rSet = pSt.executeQuery();
            rSet.next();
            user = fillEntityFromResultSet(rSet);
            rSet.close();
        } catch (SQLException e) {
            throw new DBException("Error while trying to get user by it`s email: " + email + ". " + e);
        }

        dbManager.returnConnection(connection);
        return user;
    }

    @Override
    public boolean checkIfEmailExists(final String email) throws DBException {
        connection = connectionPool.getConnection();
        boolean isEmailExists = true;

        try (PreparedStatement pSt = connection.prepareStatement(Queries.CHECK_IF_EMAIL_EXISTS)) {
            pSt.setString(1, email);
            ResultSet rSet = pSt.executeQuery();
            rSet.next();
            isEmailExists = rSet.getBoolean(1);
            rSet.close();
        } catch (SQLException e) {
            throw new DBException("Error while trying to check if given email has already exist in user table: " + email + ". " + e);
        }

        dbManager.returnConnection(connection);
        return isEmailExists;
    }

    @Override
    public void update(final User entity) throws DBException {
        connection = connectionPool.getConnection();

        try (PreparedStatement ps = dbManager.getPrepareStmt(connection, Queries.UPDATE_USER)) {
            fillPreparedStatement(ps, entity);
            ps.setInt(6, entity.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("Can not update user in database. ", e);
        }

        dbManager.returnConnection(connection);
    }

    @Override
    public void delete(final Integer id) throws DBException {
        connection = connectionPool.getConnection();

        try (PreparedStatement ps = dbManager.getPrepareStmt(connection, Queries.DELETE_USER)) {

            //TODO  Implement realisation of code that delete all bookings and applications of user

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("Can not delete room category from database. ", e.getMessage());
        }

        dbManager.returnConnection(connection);
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
