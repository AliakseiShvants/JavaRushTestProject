package com.shvants.crudtesttask.controller;

import com.shvants.crudtesttask.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Shvantc.ao on 12.07.2016.
 */
@Controller
@RequestMapping("/user-module")
public class UserController {

    @Autowired
    UserManager manager;

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public String getUsers( Model model){
        model.addAttribute("userList", manager.getUsers());
        return "userListDisplay";
    }
}
