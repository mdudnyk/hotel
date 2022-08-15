package com.epam.elearn.command.impl.get;

import com.epam.elearn.command.ICommand;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ErrorPageCommand implements ICommand {
    @Override
    public String execute(final HttpServletRequest request, final HttpServletResponse response) {
        return "ErrorPage";
    }
}
