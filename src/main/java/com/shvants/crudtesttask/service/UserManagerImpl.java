package com.shvants.crudtesttask.service;

import com.shvants.crudtesttask.dao.UserDAO;
import com.shvants.crudtesttask.model.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Shvantc.ao on 18.07.2016.
 */
@Service
public class UserManagerImpl implements UserManager {
    @Autowired
    UserDAO dao;

    public List<UserVO> getUsers() {
        return dao.getUsers();
    }
}
