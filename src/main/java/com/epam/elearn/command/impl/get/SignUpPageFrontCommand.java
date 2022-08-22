package com.epam.elearn.command.impl.get;

import com.epam.elearn.command.FrontCommand;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SignUpPageFrontCommand implements FrontCommand {
    @Override
    public String execute(final HttpServletRequest request, final HttpServletResponse response) {
        return "WEB-INF/views/SignUpPage";
    }
}

