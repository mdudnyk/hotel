package com.epam.elearn.controler;

import com.epam.elearn.command.ICommand;
import com.epam.elearn.command.factory.CommandFactory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "FrontController", value = "/controller")
public class FrontController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = handleRequest(request, response);
        request.getRequestDispatcher(forward + ".jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirect = handleRequest(request, response);
        response.sendRedirect(redirect);
    }

    private String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        ICommand command = CommandFactory.getCommand(request);
        return command.execute(request, response);
    }
}
