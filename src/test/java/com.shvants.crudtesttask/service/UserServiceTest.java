package com.shvants.crudtesttask.service;

import com.shvants.crudtesttask.dao.UserDAO;
import com.shvants.crudtesttask.dao.UserDAOServiceImpl;
import com.shvants.crudtesttask.model.User;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class UserServiceTest {
   @Ignore
   @Test
    public void testGetUser(){

        UserDAOServiceImpl testUserService = new UserDAOServiceImpl();

        int count = testUserService.getAllUsers().size();
        Assert.assertEquals(count, 5);

        for (UserDAO user : testUserService.getAllUsers()){
            Assert.assertNotNull(user.getId());
            Assert.assertNotNull(user.getName());
            Assert.assertNotNull(user.getAge());
            Assert.assertNotNull(user.getAdmin());
            Assert.assertNotNull(user.getCreatedDate());
        }
    }
}
