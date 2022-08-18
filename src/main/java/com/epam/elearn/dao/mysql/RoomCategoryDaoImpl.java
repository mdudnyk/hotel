package com.epam.elearn.dao.mysql;

import com.epam.elearn.dao.RoomCategoryDao;
import com.epam.elearn.dao.DBException;
import com.epam.elearn.entity.RoomCategory;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomCategoryDaoImpl implements RoomCategoryDao {
    private final DBConnectionManager dbManager;

    public RoomCategoryDaoImpl() {
        dbManager = new DBConnectionManager();
    }

    @Override
    public void create(final RoomCategory entity) throws DBException {
        PreparedStatement ps = dbManager.getPrepareStatement(Queries.CREATE_ROOM_CATEGORY);

        try {
            ps.setString(1, entity.title());
            ps.setInt(2, entity.priceDefault());
            ps.setInt(3, entity.area());
            ps.setInt(4, entity.guestsCapacity());
            ps.setString(5, entity.description());
            ps.execute();
        } catch (SQLException e) {
            throw new DBException("Can`t process PrepareStatement: " + e.getMessage());
        }

        dbManager.closePrepareStatement(ps);
        dbManager.returnConnection();
    }

    @Override
    public List<RoomCategory> getAll() {
        List<RoomCategory> list = new ArrayList<>();


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


//    public RoomCategoryDaoImpl() throws SQLException {
//    }
//
//    @Override
//    public void create(final RoomCategory entity) throws SQLException {
//        PreparedStatement ps =
//                getPrepareStatement("INSERT INTO category (title, " +
//                        "price_default, area, guests_capacity, description) " +
//                        "VALUES (?, ?, ?, ?, ?)");
//        ps.setString(1, entity.title());
//        ps.setInt(2, entity.priceDefault());
//        ps.setInt(3, entity.area());
//        ps.setInt(4, entity.guestsCapacity());
//        ps.setString(5, entity.description());
//
//        ps.execute();
//        ps.close();
//    }
//
//    @Override
//    public List<RoomCategory> getAll() {
//        return null;
//    }
//
//    @Override
//    public RoomCategory getEntityById(final Integer id) {
//        return null;
//    }
//
//    @Override
//    public void update(final RoomCategory entity) {
//
//    }
//
//    @Override
//    public void delete(final RoomCategory id) {
//
//    }
}
