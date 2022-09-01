package com.epam.elearn.controler.servlet.command.impl.post;

import com.epam.elearn.controler.servlet.command.FrontCommand;
import com.epam.elearn.dao.DBException;
import com.epam.elearn.model.User;
import com.epam.elearn.model.UserRoles;
import com.epam.elearn.service.ServiceException;
import com.epam.elearn.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class SignUpCommand implements FrontCommand {
    @Override
    public String execute(final HttpServletRequest request, final HttpServletResponse response) {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = new User(1, name, surname, email, password, UserRoles.CUSTOMER);

        UserService service = new UserService();

        try {
            service.signUpUser(user);
        } catch (DBException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            response.setStatus(461);
            response.setContentType("text/plain");
            try {
                PrintWriter out = response.getWriter();
                out.print(e.getMessage());
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return null;
    }
}