package com.shvants.crudtesttask.service;

import com.shvants.crudtesttask.dao.UserDAO;
import com.shvants.crudtesttask.dao.UserDAOService;
import com.shvants.crudtesttask.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shvantc.ao on 18.07.2016.
 */
@Service("userService")
//@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAOService userDAOService;


    public List<User> getAllUsers() {

        List<User> result = new ArrayList<User>();
        List<UserDAO> userDaoList = userDAOService.getAllUsers();

        for(UserDAO userDAO : userDaoList){
            User user = new User();
            user.setId(userDAO.getId());
            user.setName(userDAO.getName());
            user.setAge(userDAO.getAge());
            user.setAdmin(userDAO.isAdmin());
            user.setCreatedDate(userDAO.getCreatedDate());
            result.add(user);
        }
        return result;
    }
}
