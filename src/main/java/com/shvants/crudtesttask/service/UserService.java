package com.shvants.crudtesttask.service;


import com.shvants.crudtesttask.dao.UserDAO;
import com.shvants.crudtesttask.exception.UserNotFoundException;
import com.shvants.crudtesttask.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void add(User user);
    void delete(int id) throws UserNotFoundException;
    User getUser(int id);
}
