package com.epam.elearn.command;

import com.epam.elearn.command.impl.get.ErrorPageCommand;
import com.epam.elearn.command.impl.get.HomePageCommand;
import com.epam.elearn.command.impl.get.SignUpPageCommand;

public enum CommandEnum {

    HOME_PAGE(new HomePageCommand()),
    SIGN_UP_PAGE(new SignUpPageCommand()),
    ERROR_PAGE(new ErrorPageCommand());

    private final Command command;

    CommandEnum(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
