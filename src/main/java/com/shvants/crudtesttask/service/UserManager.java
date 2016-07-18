package com.shvants.crudtesttask.service;


import com.shvants.crudtesttask.model.UserVO;

import java.util.List;

/**
 * Created by Shvantc.ao on 18.07.2016.
 */
public interface UserManager {
    public List<UserVO> getUsers();
}
