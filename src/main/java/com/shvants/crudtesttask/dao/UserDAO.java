package com.shvants.crudtesttask.dao;

import com.shvants.crudtesttask.model.UserVO;

import java.util.List;

/**
 * Created by Shvantc.ao on 13.07.2016.
 */
public interface UserDAO {
     List<UserVO> getUsers();
}
