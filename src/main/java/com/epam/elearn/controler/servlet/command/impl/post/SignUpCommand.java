package com.epam.elearn.controler.servlet.command.impl.post;

import com.epam.elearn.controler.servlet.command.FrontCommand;
import com.epam.elearn.dao.DBException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SignUpCommand implements FrontCommand {
    @Override
    public String execute(final HttpServletRequest request, final HttpServletResponse response) throws DBException {
        return null;
    }
}
