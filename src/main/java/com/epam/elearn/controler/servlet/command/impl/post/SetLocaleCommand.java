package com.epam.elearn.controler.servlet.command.impl.post;

import com.epam.elearn.controler.servlet.command.FrontCommand;
import com.epam.elearn.dao.DBException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SetLocaleCommand implements FrontCommand {
    @Override
    public void execute(final HttpServletRequest request, final HttpServletResponse response) throws DBException, ServletException, IOException {
        String langParam = request.getParameter("lang");
        if (langParam != null) {
            request.getSession().setAttribute("lang", langParam);
        }
        response.sendRedirect(request.getHeader("Referer"));
    }
}
