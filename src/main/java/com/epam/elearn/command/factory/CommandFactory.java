package com.epam.elearn.command.factory;

import com.epam.elearn.command.CommandEnum;
import com.epam.elearn.command.FrontCommand;
import jakarta.servlet.http.HttpServletRequest;

public final class CommandFactory {

    private CommandFactory() {
    }

    public static FrontCommand getCommand(HttpServletRequest request) {
        String commandFromRequest = request.getParameter("cmd");
        FrontCommand frontCommand = null;

        if (commandFromRequest != null) {
            try {
                frontCommand = CommandEnum.valueOf(commandFromRequest).getCommand();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                frontCommand = CommandEnum.ERROR_PAGE.getCommand();
            }
        } else {
            frontCommand = CommandEnum.ERROR_PAGE.getCommand();
        }
        return frontCommand;
    }
}
