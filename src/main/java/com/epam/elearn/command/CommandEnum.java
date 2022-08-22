package com.epam.elearn.command;

import com.epam.elearn.command.impl.get.CategoryPageFrontCommand;
import com.epam.elearn.command.impl.get.ErrorPageFrontCommand;
import com.epam.elearn.command.impl.get.HomePageFrontCommand;
import com.epam.elearn.command.impl.get.SignUpPageFrontCommand;

public enum CommandEnum {

    HOME_PAGE(new HomePageFrontCommand()),
    SIGN_UP_PAGE(new SignUpPageFrontCommand()),
    CATEGORY_PAGE(new CategoryPageFrontCommand()),
    ERROR_PAGE(new ErrorPageFrontCommand());


    private final FrontCommand frontCommand;

    CommandEnum(FrontCommand frontCommand) {
        this.frontCommand = frontCommand;
    }

    public FrontCommand getCommand() {
        return frontCommand;
    }
}
