package com.springboot.demo.controller;
//import generator

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
    @GetMapping("employee")
    public ModelAndView employeeList() {
        ModelAndView mvc = new ModelAndView();

        return mvc;
    }
}
