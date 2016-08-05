package com.shvants.crudtesttask.controller;

import com.shvants.crudtesttask.model.User;
import com.shvants.crudtesttask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

//import javax.servlet.http.HttpServletRequest;

/**
 * Created by Shvantc.ao on 12.07.2016.
 */
@Controller
@RequestMapping("/user-module")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsers( Model model){
        model.addAttribute("user", new User());
        model.addAttribute("users", userService.getAllUsers());

        return "userListDisplay";
    }

    @RequestMapping(value = "/addNewUser", method = RequestMethod.POST)
    public ModelAndView addNewUser(/*HttpServletRequest request,*/
                                   @RequestParam(value = "name", required = true) String name,
                                   @RequestParam(value = "age", required = true) String age,
                                   @RequestParam(value = "admin", required = true) String admin){

        if (name == null || age == null || admin == null || name.equals("")|| age.equals("") || admin.equals(""))
            throw new NullPointerException();

        User user = new User();
        user.setName(name);
        user.setAge(Integer.parseInt(age));
        user.setAdmin(Boolean.valueOf(admin));

        ModelAndView mav = new ModelAndView("successAction", "message", "Новый пользователь успешно добавлен!");
        return mav;
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public ModelAndView deleteUser(@RequestParam String id){

        ModelAndView mav = new ModelAndView("successAction", "message", "Пользователь c id=" + id + " успешно удален!");
        return mav;
    }

}
