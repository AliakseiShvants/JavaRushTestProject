package com.shvants.crudtesttask.controller;

import com.shvants.crudtesttask.exception.UserNotFoundException;
import com.shvants.crudtesttask.model.User;
import com.shvants.crudtesttask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

//import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/user-module")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public String getUsers( Model model){

        model.addAttribute("userList", userService.getAllUsers());

        return "startPage";
    }

    @RequestMapping(value = "/addNewUser", method = RequestMethod.POST)
    public ModelAndView addNewUser(@RequestParam(value = "name") String name,
                                   @RequestParam(value = "age") String age,
                                   @RequestParam(value = "admin") String admin){

        if (name == null || age == null || admin == null || name.equals("")|| age.equals("") || admin.equals(""))
            throw new NullPointerException();

        User user = new User();
        user.setName(name);
        user.setAge(Integer.parseInt(age));
        user.setAdmin(Boolean.valueOf(admin));
        userService.add(user);

        return new ModelAndView("generalPage", "message", "Новый пользователь успешно добавлен!");
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public ModelAndView deleteUser(@RequestParam String id){
        try {
            userService.delete(Integer.parseInt(id));
            return new ModelAndView("generalPage", "message", "Пользователь c id=" + id + " успешно удален!");
        }
        catch (UserNotFoundException e) {
            return new ModelAndView("generalPage", "message", ":( Не в наших силах удалить этого пользователя! Такого id просто не существует!");
        }
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public String updateUser(Model model,
                             @RequestParam String id
                             /*@RequestParam(value = "name") String name,
                             @RequestParam(value = "age") String age,
                             @RequestParam(value = "admin") String admin*/){


            model.addAttribute("user", userService.getUser(Integer.parseInt(id)));
            return "updatePage";



//        User user = new User();
//        user.setName(name);
//        user.setAge(Integer.parseInt(age));
//        user.setAdmin(Boolean.valueOf(admin));
//        userService.add(user);
//        return new ModelAndView("generalPage", "message", "Пользователь c id=" + id + " успешно сохранён!");
    }
}
