package com.epam.elearn.command.impl.get;

import com.epam.elearn.command.FrontCommand;
import com.epam.elearn.dao.DBException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CategoryPageFrontCommand implements FrontCommand {
    @Override
    public String execute(final HttpServletRequest request, final HttpServletResponse response) throws DBException {
        return "WEB-INF/views/showDate";
    }
}
