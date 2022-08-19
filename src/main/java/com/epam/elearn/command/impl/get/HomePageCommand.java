package com.epam.elearn.command.impl.get;

import com.epam.elearn.command.Command;
import com.epam.elearn.dao.FactoryDao;
import com.epam.elearn.dao.RoomCategoryDao;
import com.epam.elearn.dao.DBException;
import com.epam.elearn.entity.RoomCategory;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HomePageCommand implements Command {
    @Override
    public String execute(final HttpServletRequest request, final HttpServletResponse response) throws DBException {
        FactoryDao dao = FactoryDao.create("MYSQL");
        RoomCategoryDao rcDao = dao.getRoomCategoryDao();

        RoomCategory rc1 = new RoomCategory(1, "Single Room", 100, 15, 1, "room for one person");
        rcDao.create(rc1);

        RoomCategory rc2 = new RoomCategory(1, "Double Room", 160, 25, 2, "room for two person");
        rcDao.create(rc2);

        RoomCategory rc3 = new RoomCategory(1, "Triple Room", 200, 30, 3, "room for three person");
        rcDao.create(rc2);

        rcDao.getAll().forEach(System.out::println);

        return "HomePage";
    }
}
