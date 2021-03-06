package com.shvants.crudtesttask.service;

import com.shvants.crudtesttask.dao.UserDAO;
import com.shvants.crudtesttask.dao.UserDAOService;
import com.shvants.crudtesttask.exception.UserNotFoundException;
import com.shvants.crudtesttask.model.User;
import com.shvants.crudtesttask.model.UserSearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAOService userDAOService;

    public List<User> getAllUsers() {

        List<User> result = new ArrayList<User>();
        List<UserDAO> userDaoList = userDAOService.getAllUsers();

        for(UserDAO userDAO : userDaoList){
            User user = transformUserDAOtoUser(userDAO);
            result.add(user);
        }
        return result;
    }

    private User transformUserDAOtoUser(UserDAO userDAO) {
        User user = new User();
        user.setId(userDAO.getId());
        user.setName(userDAO.getName());
        user.setAge(userDAO.getAge());
        user.setAdmin(userDAO.getAdmin());
        user.setCreatedDate(userDAO.getCreatedDate());
        return user;
    }
    private UserDAO transformUserToUserDAO(User user) {
        UserDAO userDAO = new UserDAO();
        userDAO.setId(user.getId());
        userDAO.setName(user.getName());
        userDAO.setAge(user.getAge());
        userDAO.setAdmin(user.getAdmin());
        userDAO.setCreatedDate(user.getCreatedDate());
        return userDAO;
    }

    public void add(User user) {
        userDAOService.addUser(transformUserToUserDAO(user));
    }

    public void delete(int id) throws UserNotFoundException {
        UserDAO userDAO = userDAOService.findUser(id);
        if (userDAO != null)
            userDAOService.removeUser(id);
        else throw new UserNotFoundException();
    }

    public User getUser(int id) {
        return transformUserDAOtoUser(userDAOService.findUser(id));
    }

    public void update(User user) throws UserNotFoundException {
        UserDAO userDAO = userDAOService.findUser(user.getId());

        if (userDAO != null){
            userDAO.setName(user.getName());
            userDAO.setAge(user.getAge());
            userDAO.setAdmin(user.getAdmin());

            userDAOService.updateUser(userDAO);
        }
        else throw new UserNotFoundException();
    }

    public List<User> searchUsers(UserSearchCriteria user) {
        List<User> result = new ArrayList<User>();
        List<UserDAO> userDaoList = userDAOService.searchUsers(user);

        for(UserDAO userDAO : userDaoList){
            User usr = transformUserDAOtoUser(userDAO);
            result.add(usr);
        }
        return result;
    }

    public Integer countUsers(UserSearchCriteria userSearchCriteria) {
        return userDAOService.countUsers(userSearchCriteria);
    }
}
