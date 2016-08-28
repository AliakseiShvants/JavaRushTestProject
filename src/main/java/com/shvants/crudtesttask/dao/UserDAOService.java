package com.shvants.crudtesttask.dao;

import com.shvants.crudtesttask.model.UserSearchCriteria;
import java.util.List;

public interface UserDAOService {
    void addUser(UserDAO userDAO);
    void updateUser(UserDAO userDAO);
    void removeUser(int id);
    List<UserDAO> getAllUsers();
    UserDAO findUser(int id);
    List<UserDAO> searchUsers(UserSearchCriteria userCriteria);
    Integer countUsers(UserSearchCriteria userCriteria);
}
