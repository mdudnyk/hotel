package com.epam.elearn.controler.servlet.command;

import com.epam.elearn.controler.servlet.command.impl.get.ErrorPageFrontCommand;
import com.epam.elearn.controler.servlet.command.impl.get.SignInPageFrontCommand;
import com.epam.elearn.controler.servlet.command.impl.post.SignInHandler;
import com.epam.elearn.controler.servlet.command.impl.get.CategoryPageFrontCommand;
import com.epam.elearn.controler.servlet.command.impl.get.HomePageFrontCommand;

public enum CommandEnum {

    HOME_PAGE(new HomePageFrontCommand()),
    SIGN_IN_PAGE(new SignInPageFrontCommand()),
    SIGN_IN(new SignInHandler()),
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
