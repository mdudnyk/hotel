package com.epam.elearn.command.factory;

import com.epam.elearn.command.CommandEnum;
import com.epam.elearn.command.Command;
import jakarta.servlet.http.HttpServletRequest;

public final class CommandFactory {

    private CommandFactory() {
    }

    public static Command getCommand(HttpServletRequest request) {
        String commandFromRequest = request.getParameter("command");
        Command command;

        if (commandFromRequest != null) {
            try {
                command = CommandEnum.valueOf(commandFromRequest).getCommand();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                command = CommandEnum.ERROR_PAGE.getCommand();
            }
        } else {
            command = CommandEnum.ERROR_PAGE.getCommand();
        }
        return command;
    }
}
