package com.epam.elearn.dao.impl.mysql;

import com.epam.elearn.dao.HikariPooledConnectionBuilder;
import com.epam.elearn.dao.RoomCategoryDao;
import com.epam.elearn.dao.DBException;
import com.epam.elearn.entity.RoomCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomCategoryDaoImpl implements RoomCategoryDao {
    private final DBManagerMySQL dbManager;

    public RoomCategoryDaoImpl() {
        dbManager = new DBManagerMySQL();
    }

    @Override
    public void create(final RoomCategory entity) throws DBException {
        Connection conn = dbManager.getConnection();

        try (PreparedStatement ps = conn.prepareStatement(Queries.CREATE_ROOM_CATEGORY)) {
            ps.setString(1, entity.title());
            ps.setInt(2, entity.priceDefault());
            ps.setInt(3, entity.area());
            ps.setInt(4, entity.guestsCapacity());
            ps.setString(5, entity.description());
            ps.execute();
        } catch (SQLException e) {
            throw new DBException("Can not add new room category to the database");
        }
    }

    @Override
    public List<RoomCategory> getAll() throws DBException {
        List<RoomCategory> list = new ArrayList<>();

//        ResultSet resultSet = dbManager.getResultSet(Queries.GET_ALL_ROOM_CATEGORY);
//        try {
//            while (resultSet.next()) {
//                int id = resultSet.getInt(1);
//                String title = resultSet.getString(2);
//                int priceDefault = resultSet.getInt(3);
//                int area = resultSet.getInt(4);
//                int guestCapacity = resultSet.getInt(5);
//                String description = resultSet.getString(6);
//                list.add(new RoomCategory(id, title, priceDefault, area, guestCapacity, description));
//            }
//        } catch (SQLException e) {
//            throw new DBException("Error while trying get room categories list: " + e.getMessage());
//        }

//        dbManager.returnConnection();
        return list;
    }

    @Override
    public RoomCategory getEntityById(final Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(final RoomCategory entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(final RoomCategory id) {
        throw new UnsupportedOperationException();
    }
}
