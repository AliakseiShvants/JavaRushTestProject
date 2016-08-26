package com.shvants.crudtesttask.controller;

import com.shvants.crudtesttask.exception.UserNotFoundException;
import com.shvants.crudtesttask.model.User;
import com.shvants.crudtesttask.model.UserCriteria;
import com.shvants.crudtesttask.model.UserSearchCriteria;
import com.shvants.crudtesttask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user-module")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public String getUsers(@RequestParam(defaultValue = "1") Integer page, Model model){

        UserSearchCriteria userSearchCriteria = new  UserSearchCriteria();
        Integer pageSize = 10;
        Integer countUsers = userService.countUsers(userSearchCriteria);

        Integer pageCount;
        if (countUsers % 10 != 0)
            pageCount = countUsers/10 + 1;
        else pageCount = countUsers/10;

        if (page == null || page < 0 || page > pageCount)
            page = 1;

        model.addAttribute("page", page);

        userSearchCriteria.setCurrentPage(page);
        userSearchCriteria.setPageSize(pageSize);
        model.addAttribute("userList", userService.searchUsers(userSearchCriteria));
        model.addAttribute("maxPages", pageCount);

        return "startPage";
    }

    @RequestMapping(value = "/addNewUser", method = RequestMethod.POST)
    public ModelAndView addNewUser(@RequestParam(value = "name") String name,
                                   @RequestParam(value = "age") String age,
                                   @RequestParam(value = "admin") String admin){

            User user = new User();
            user.setName(name);

            try {
                user.setAge(Integer.parseInt(age));
            }
            catch (NumberFormatException e){
                return new ModelAndView("generalPage", "message", "Возраст должен быть целым числом!");
            }

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

    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public String editUser(Model model, @RequestParam String id){

            model.addAttribute("user", userService.getUser(Integer.parseInt(id)));
            return "updatePage";
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public ModelAndView updateUser(Model model,
                             @RequestParam String id,
                             @RequestParam(value = "name") String name,
                             @RequestParam(value = "age") String age,
                             @RequestParam(value = "admin") String admin) throws UserNotFoundException {

        User user = new User();
        user.setId(Integer.parseInt(id));
        user.setName(name);

        user.setAge(Integer.parseInt(age));

        user.setAdmin(Boolean.valueOf(admin));
        userService.update(user);

        return new ModelAndView("generalPage", "message", "Пользователь успешно сохранён!");
    }

    @RequestMapping(value = "/searchUser", method = RequestMethod.POST)
    public String searchUser(@RequestParam(defaultValue = "1") Integer page, Model model, HttpServletRequest request,
                                   @RequestParam(defaultValue = "", value = "name") String name,
                                   @RequestParam(defaultValue = "", value = "age") String age,
                                   @RequestParam(defaultValue = "", value = "admin") String admin) throws UserNotFoundException {

        UserSearchCriteria searchCriteria = new UserSearchCriteria();
        if (name != null && !name.equals(""))
            searchCriteria.setName(name);
        if (age != null && !age.equals(""))
            searchCriteria.setAge(Integer.parseInt(age));
        if (admin != null && !admin.equals(""))
            searchCriteria.setAdmin(Boolean.valueOf(admin));

        Integer pageSize = 10;
        Integer countUsers = userService.countUsers(searchCriteria);

        Integer pageCount;
        if (countUsers % 10 != 0)
            pageCount = countUsers/10 + 1;
        else pageCount = countUsers/10;

        if (page == null || page < 0 || page > pageCount)
            page = 1;

        model.addAttribute("page", page);

        searchCriteria.setCurrentPage(page);
        searchCriteria.setPageSize(pageSize);
        model.addAttribute("userList", userService.searchUsers(searchCriteria));
        model.addAttribute("maxPages", pageCount);

        HttpSession session = request.getSession();
        session.setAttribute("searchCriteria", new UserCriteria(name, age, admin));

        model.addAttribute("userList", userService.searchUsers(searchCriteria));

        return "startPage";
    }
}
