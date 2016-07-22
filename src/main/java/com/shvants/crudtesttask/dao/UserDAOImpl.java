package com.shvants.crudtesttask.dao;

import com.shvants.crudtesttask.model.UserVO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Shvantc.ao on 13.07.2016.
 */
@Repository
public class UserDAOImpl implements UserDAO {

    private List<UserVO> createUser(){
        List<UserVO> createdList = new ArrayList<UserVO>();

        UserVO userVO0 = new UserVO();
        userVO0.setId(0);
        userVO0.setName("Baushevich Anna");
        userVO0.setAge(29);
        userVO0.setAdmin(true);
        userVO0.setCreatedDate(new Date());

        UserVO userVO1 = new UserVO();
        userVO1.setId(1);
        userVO1.setName("Shvants Aliaksei");
        userVO1.setAge(24);
        userVO1.setAdmin(true);
        userVO1.setCreatedDate(new Date());

        UserVO userVO2 = new UserVO();
        userVO2.setId(2);
        userVO2.setName("Ivanov Ivan");
        userVO2.setAge(24);
        userVO2.setAdmin(false);
        userVO2.setCreatedDate(new Date());

        UserVO userVO3 = new UserVO();
        userVO3.setId(3);
        userVO3.setName("Ivanov Petr");
        userVO3.setAge(20);
        userVO3.setAdmin(false);
        userVO3.setCreatedDate(new Date());

        UserVO userVO4 = new UserVO();
        userVO4.setId(4);
        userVO4.setName("Sidorov Nikofor");
        userVO4.setAge(21);
        userVO4.setAdmin(false);
        userVO4.setCreatedDate(new Date());

        createdList.add(userVO0);
        createdList.add(userVO1);
        createdList.add(userVO2);
        createdList.add(userVO3);
        createdList.add(userVO4);

        return createdList;
    }

    public List<UserVO> getUsers() {
        return createUser();
    }
}
