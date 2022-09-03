package com.epam.elearn.controler.servlet.command;

import com.epam.elearn.dao.DBException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface FrontCommand {
    void execute(HttpServletRequest request, HttpServletResponse response) throws DBException, ServletException, IOException;
}
