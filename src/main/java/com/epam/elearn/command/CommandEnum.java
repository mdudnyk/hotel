package com.epam.elearn.command;

import com.epam.elearn.command.impl.get.ErrorPageCommand;
import com.epam.elearn.command.impl.get.HomePageCommand;
import com.epam.elearn.command.impl.get.SignUpPageCommand;

public enum CommandEnum {

    HOME_PAGE(new HomePageCommand()),
    ERROR_PAGE(new ErrorPageCommand()),
    SIGN_UP_PAGE(new SignUpPageCommand());

    private final ICommand command;

    CommandEnum(ICommand command) {
        this.command = command;
    }

    public ICommand getCommand() {
        return command;
    }
}
