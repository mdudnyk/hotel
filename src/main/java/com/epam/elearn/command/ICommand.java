package com.epam.elearn.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ICommand {

    String execute(HttpServletRequest request, HttpServletResponse response);

}
