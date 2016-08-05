package com.shvants.crudtesttask.dao;

import java.util.List;

/**
 * Created by Shvantc.ao on 13.07.2016.
 */
public interface UserDAOService {

     public void addUser(UserDAO userDAO);
     public void updateUser(UserDAO userDAO);
     public void removeUser(int id);
     public List<UserDAO> getAllUsers();

}
