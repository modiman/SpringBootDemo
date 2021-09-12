package com.springboot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @RequestMapping(value = {"/frame"})
    public ModelAndView frameWork(String sno) {
        ModelAndView mvc = new ModelAndView("common/frame");
        return mvc;
    }
    @RequestMapping(value = {"/test"})
    public ModelAndView testWork(String sno) {
        ModelAndView mvc = new ModelAndView("test");
        return mvc;
    }

}
