package com.epam.elearn.controler.servlet.listeners;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(final ServletContextEvent sce) {

        //TODO set up dao and services

        ServletContextListener.super.contextInitialized(sce);
    }

    @Override
    public void contextDestroyed(final ServletContextEvent sce) {

        //TODO close dao

        ServletContextListener.super.contextDestroyed(sce);
    }
}
