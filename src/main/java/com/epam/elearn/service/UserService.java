package com.epam.elearn.service;

import com.epam.elearn.dao.DBException;
import com.epam.elearn.dao.FactoryDao;
import com.epam.elearn.dao.UserDao;
import com.epam.elearn.entity.User;

public class UserService {
    public User signInUser(final String email, final String password) throws DBException {
        User user = FactoryDao.create().getUserDao().getUserByEmail(email);

        if (user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }

    public String signUpUser(final User user) throws ServiceException, DBException {
        UserDao dao = FactoryDao.create().getUserDao();

        if(dao.checkIfEmailExists(user.getEmail())) {
            throw new ServiceException("Sorry, this email is already being used");
        }

        FactoryDao.create().getUserDao().create(user);

        return null;
    }
}
