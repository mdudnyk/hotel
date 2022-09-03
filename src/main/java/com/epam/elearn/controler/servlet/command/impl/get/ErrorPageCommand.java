package com.epam.elearn.controler.servlet.command.impl.get;

import com.epam.elearn.controler.servlet.command.FrontCommand;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ErrorPageCommand implements FrontCommand {
    @Override
    public void execute(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/ErrorPage.jsp").forward(request, response);
    }
}
