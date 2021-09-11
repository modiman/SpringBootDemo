package com.springboot.demo.controller;

import com.springboot.demo.model.Student;
import com.springboot.demo.model.User;
import com.springboot.demo.service.UserService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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


}

