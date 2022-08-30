package com.epam.elearn.controler.servlet.command;

import com.epam.elearn.controler.servlet.command.impl.get.*;
import com.epam.elearn.controler.servlet.command.impl.post.SignInCommand;

public enum CommandEnum {

    HOME_PAGE(new HomePageCommand()),
    SIGN_IN(new SignInCommand()),
    SIGN_OUT(new SignOutCommand()),
    ROOM_SEARCHER_PAGE(new RoomSearcherPageCommand()),
    ERROR_PAGE(new ErrorPageCommand());


    private final FrontCommand frontCommand;

    CommandEnum(FrontCommand frontCommand) {
        this.frontCommand = frontCommand;
    }

    public FrontCommand getCommand() {
        return frontCommand;
    }

}
