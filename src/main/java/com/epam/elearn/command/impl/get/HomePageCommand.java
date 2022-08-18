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
        RoomCategory rc = new RoomCategory(1, "Triple Room", 100, 20, 3, "Best room");
        rcDao.create(rc);
        return "HomePage";
    }
}
