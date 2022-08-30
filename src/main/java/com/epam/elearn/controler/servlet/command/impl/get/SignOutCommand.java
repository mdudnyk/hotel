package com.epam.elearn.controler.servlet.command.impl.get;

import com.epam.elearn.controler.servlet.command.FrontCommand;
import com.epam.elearn.dao.DBException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class SignOutCommand implements FrontCommand {
    @Override
    public String execute(final HttpServletRequest request, final HttpServletResponse response) throws DBException {

        Cookie[] cookies = request.getCookies();
        String cookieName = "name";

        if  (cookies != null) {
            for (Cookie c: cookies) {
                if (cookieName.equals(c.getName())) {
                    c.setValue("");
                    c.setMaxAge(0);
                    response.addCookie(c);
                    break;
                }
            }
        }
        request.getSession().invalidate();

        return "/hotel";
    }
}
