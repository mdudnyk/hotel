package com.epam.elearn.controler.servlet.command.impl.post;

import com.epam.elearn.controler.servlet.command.FrontCommand;
import com.epam.elearn.dao.DBException;
import com.epam.elearn.model.User;
import com.epam.elearn.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SignInCommand implements FrontCommand {
    @Override
    public void execute(final HttpServletRequest request, final HttpServletResponse response) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = null;

        //TODO EMAIL AND PASSWORD VALIDATION

        UserService service = new UserService();

        try {
            user = service.signInUser(email, password);
        } catch (DBException e) {
            e.printStackTrace();
        }


        if (user != null) {
            response.addCookie(new Cookie("name", user.getName()));
        } else {
            try{
                response.sendError(460, "Can`t find such user");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
