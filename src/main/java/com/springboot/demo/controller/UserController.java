package com.springboot.demo.controller;

import com.springboot.demo.model.Student;
import com.springboot.demo.model.User;
import com.springboot.demo.service.UserService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getUsers() {
        ModelAndView mvc = new ModelAndView("users");
        List<User> list = userService.getAllUsers();
        mvc.addObject("users", list);

        return mvc;
    }
    @RequestMapping(value = "/addUser")
    public ModelAndView addUser(@RequestParam("uname")String uName, @RequestParam("uid")String uId,
                                @RequestParam("uage")String uAge) {
        User user = new User(uId,uName,uAge);
        userService.addUser(user);
        System.out.println(user.getUname());


        ModelAndView mvc = new ModelAndView("users");
        List<User> list = userService.getAllUsers();
        mvc.addObject("users", list);

        return mvc;
    }

    @RequestMapping(value = "/editUser")
    public ModelAndView editUser(@RequestParam("uname")String uName, @RequestParam("uid")String uId,
                                @RequestParam("uage")String uAge) {
        User user = new User(uId,uName,uAge);

        userService.editUser(user);
        System.out.println(user.getUname());


        ModelAndView mvc = new ModelAndView("users");
        List<User> list = userService.getAllUsers();
        mvc.addObject("users", list);

        return mvc;
    }

    @RequestMapping(value = "/delUser")
    public ModelAndView delUser(@RequestParam("uId")String uId){
        String uid = uId;

        userService.delUser(uid);


        ModelAndView mvc = new ModelAndView("users");
        List<User> list = userService.getAllUsers();
        mvc.addObject("users", list);

        return mvc;

    }



}

