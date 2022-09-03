package com.epam.elearn.controler.servlet.command.impl.get;

import com.epam.elearn.controler.servlet.command.FrontCommand;
import com.epam.elearn.dao.DBException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RoomSearcherPageCommand implements FrontCommand {
    @Override
    public void execute(final HttpServletRequest request, final HttpServletResponse response) throws DBException, IOException, ServletException {
        request.getRequestDispatcher("WEB-INF/views/RoomSearcherPage.jsp").forward(request, response);
    }
}
