package com.epam.elearn.dao;

import com.epam.elearn.entity.User;

public interface UserDao extends GeneralDao<User, Integer> {
    User getUserByEmail(String email) throws DBException;
    boolean checkIfEmailExists(String email) throws DBException;
}
