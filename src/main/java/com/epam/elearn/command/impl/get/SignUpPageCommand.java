package com.epam.elearn.command.impl.get;

import com.epam.elearn.command.Command;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SignUpPageCommand implements Command {
    @Override
    public String execute(final HttpServletRequest request, final HttpServletResponse response) {
        return "SignUpPage";
    }
}

