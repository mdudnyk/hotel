package com.epam.elearn.controler.servlet.command;

import com.epam.elearn.dao.DBException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface FrontCommand {

    String execute(HttpServletRequest request, HttpServletResponse response) throws DBException;

}
