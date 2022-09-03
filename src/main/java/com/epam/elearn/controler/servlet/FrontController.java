package com.epam.elearn.controler.servlet;

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
        handleRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        handleRequest(request, response);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            CommandFactory.getCommand(request).execute(request, response);
        } catch (Exception e) {
            //TODO logging and error management
            e.printStackTrace();
        }
    }
}
