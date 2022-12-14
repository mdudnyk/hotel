package com.epam.elearn.controler.servlet.command;

import com.epam.elearn.controler.servlet.command.impl.get.*;
import com.epam.elearn.controler.servlet.command.impl.post.*;

public enum CommandEnum {

    HOME_PAGE(new HomePageCommand()),
    SET_LOCALE(new SetLocaleCommand()),
    SIGN_UP_PAGE(new SignUpPageCommand()),
    SIGN_UP(new SignUpCommand()),
    SIGN_IN(new SignInCommand()),
    SIGN_OUT(new SignOutCommand()),
    SHOW_AVAILABLE_ROOMS_FOR_DATES(new ShowAvailableRoomsForDatesCommand()),
    ERROR_PAGE(new ErrorPageCommand());


    private final FrontCommand frontCommand;

    CommandEnum(FrontCommand frontCommand) {
        this.frontCommand = frontCommand;
    }

    public FrontCommand getCommand() {
        return frontCommand;
    }

}
