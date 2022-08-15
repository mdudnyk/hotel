package com.epam.elearn.command.factory;

import com.epam.elearn.command.CommandEnum;
import com.epam.elearn.command.ICommand;
import jakarta.servlet.http.HttpServletRequest;

public final class CommandFactory {

    private CommandFactory() {}

    public static ICommand getCommand(HttpServletRequest request) {
        String command = request.getParameter("command");
        ICommand iCommand;

        if (command != null) {
            try {
                iCommand = CommandEnum.valueOf(command).getCommand();
            }
            catch (IllegalArgumentException e) {
                e.printStackTrace();
                iCommand = CommandEnum.ERROR_PAGE.getCommand();
            }
        } else {
            iCommand = CommandEnum.ERROR_PAGE.getCommand();
        }
        return iCommand;
    }
}
