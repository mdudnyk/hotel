package com.epam.elearn.dao.mysql;

import com.epam.elearn.dao.DBException;
import com.epam.elearn.dao.UserDao;
import com.epam.elearn.entity.UserRoles;
import com.epam.elearn.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl implements UserDao {
    private final DBManagerMySQL dbManager;

    public UserDaoImpl() {
        dbManager = new DBManagerMySQL();
    }

    @Override
    public void create(final User entity) throws DBException {
        Connection connection = dbManager.getConnection();

        try (PreparedStatement ps = dbManager.getPrepareStmt(connection, Queries.CREATE_USER)) {
            fillPreparedStatement(ps, entity);
            ps.execute();
        } catch (SQLException e) {
            throw new DBException("Can not add new user to the database.", e);
        }

        dbManager.returnConnection(connection);
    }

    @Override
    public List<User> getAll() throws DBException {
        Connection connection = dbManager.getConnection();
        List<User> list = new ArrayList<>();

        try (ResultSet resultSet = dbManager.getResultSet(connection, Queries.GET_ALL_USERS)) {
            while (resultSet.next()) {
                list.add(fillEntityFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new DBException("Error while trying to get users list from database." + e);
        }

        dbManager.returnConnection(connection);
        return list;
    }

    @Override
    public User getEntityById(final Integer id) throws DBException {
        Connection connection = dbManager.getConnection();
        User user;

        try (ResultSet resultSet = dbManager.getResultSet(connection, Queries.GET_USER_BY_ID)) {
            resultSet.next();
            user = fillEntityFromResultSet(resultSet);
        } catch (SQLException e) {
            throw new DBException("Error while trying to get user by it`s id." + e);
        }

        dbManager.returnConnection(connection);
        return user;
    }

    @Override
    public void update(final User entity) throws DBException {
        Connection connection = dbManager.getConnection();

        try (PreparedStatement ps = dbManager.getPrepareStmt(connection, Queries.UPDATE_USER)) {
            fillPreparedStatement(ps, entity);
            ps.setInt(6, entity.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("Can not update user in database.", e);
        }

        dbManager.returnConnection(connection);
    }

    @Override
    public void delete(final Integer id) throws DBException {
        Connection connection = dbManager.getConnection();

        try (PreparedStatement ps = dbManager.getPrepareStmt(connection, Queries.DELETE_USER)) {

            //TODO  Implement realisation of code that delete all bookings and applications of user

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DBException("Can not delete room category from database.", e.getMessage());
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
        String password = resultSet.getString(4);
        UserRoles role = UserRoles.valueOf(resultSet.getString(6));

        return new User(id, name, surname, email, password, role);
    }
}
