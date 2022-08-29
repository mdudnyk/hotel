package com.epam.elearn.controler.servlet;

import com.epam.elearn.controler.servlet.command.FrontCommand;
import com.epam.elearn.controler.servlet.command.factory.CommandFactory;
import com.epam.elearn.dao.DBException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "FrontController", value = "/controller")
public class FrontController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = null;
        try {
            forward = handleRequest(request, response);
        } catch (DBException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher(forward + ".jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            handleRequest(request, response);
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

    private String handleRequest(HttpServletRequest req, HttpServletResponse resp) throws DBException {
        FrontCommand frontCommand = CommandFactory.getCommand(req);
        return frontCommand.execute(req, resp);
    }
}
