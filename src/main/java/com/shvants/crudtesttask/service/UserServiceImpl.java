package com.shvants.crudtesttask.service;

import com.shvants.crudtesttask.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Shvantc.ao on 13.07.2016.
 */
public class UserServiceImpl implements UserService{

    private List<User> createUser(){
        List<User> createdList = new ArrayList<User>();

        User user0 = new User();
        user0.setName("Baushevich");
        user0.setAge(29);
        user0.setAdmin(true);
        user0.setCreatedDate(new Date());

        User user1 = new User();
        user1.setName("Shvants");
        user1.setAge(24);
        user1.setAdmin(true);
        user1.setCreatedDate(new Date());

        User user2 = new User();
        user2.setName("Ivanov");
        user2.setAge(24);
        user2.setAdmin(false);
        user2.setCreatedDate(new Date());

        User user3 = new User();
        user3.setName("Ivanov");
        user3.setAge(20);
        user3.setAdmin(false);
        user3.setCreatedDate(new Date());

        User user4 = new User();
        user4.setName("Sidorov");
        user4.setAge(21);
        user4.setAdmin(false);
        user4.setCreatedDate(new Date());

        createdList.add(user0);
        createdList.add(user1);
        createdList.add(user2);
        createdList.add(user3);
        createdList.add(user4);

        return createdList;
    }

    public List<User> getUsers() {
        return createUser();
    }
}
