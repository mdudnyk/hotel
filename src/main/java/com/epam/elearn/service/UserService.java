package com.epam.elearn.service;

import com.epam.elearn.dao.DBException;
import com.epam.elearn.dao.FactoryDao;
import com.epam.elearn.model.User;

public class UserService {
    public User signInUser(final String email, final String password) throws DBException {
        User user = FactoryDao.create().getUserDao().getUserByEmail(email);

        if (user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }
}
