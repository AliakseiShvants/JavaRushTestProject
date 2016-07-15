package com.shvants.crudtesttask.service;

import com.shvants.crudtesttask.model.User;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by aliaksei on 14.7.16.
 */
public class UserServiceTest {
    @Test
    public void testGetUser(){
        UserServiceImpl testUserService = new UserServiceImpl();

        int count = testUserService.getUsers().size();
        Assert.assertEquals(count, 5);

        for (User user : testUserService.getUsers()){
            Assert.assertNotNull(user.getId());
            Assert.assertNotNull(user.getName());
            Assert.assertNotNull(user.getAge());
            Assert.assertNotNull(user.isAdmin());
            Assert.assertNotNull(user.getCreatedDate());
        }
    }
}
