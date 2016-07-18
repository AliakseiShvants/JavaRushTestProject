package com.shvants.crudtesttask.service;

import com.shvants.crudtesttask.dao.UserDAOImpl;
import com.shvants.crudtesttask.model.UserVO;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by aliaksei on 14.7.16.
 */
public class UserVOServiceTest {
    @Test
    public void testGetUser(){
        UserDAOImpl testUserService = new UserDAOImpl();

        int count = testUserService.getUsers().size();
        Assert.assertEquals(count, 5);

        for (UserVO userVO : testUserService.getUsers()){
            Assert.assertNotNull(userVO.getId());
            Assert.assertNotNull(userVO.getName());
            Assert.assertNotNull(userVO.getAge());
            Assert.assertNotNull(userVO.isAdmin());
            Assert.assertNotNull(userVO.getCreatedDate());
        }
    }
}
