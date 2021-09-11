package com.springboot.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@RestController
@Slf4j   //可以使用日志，能在手动在控制台打印一些信息
@Controller
public class IndexController {
    private static final String INDEX = "index";

    /**
     * 来登录页
     *
     * @return
     */
    @RequestMapping("login")
    public ModelAndView getIndex() {

        ModelAndView mvc = new ModelAndView("login");
        return mvc;
    }

    @RequestMapping(value = {"/", "index"})
    public ModelAndView indexPage() {
        log.info("启动成功，美滋儿滋儿");
        ModelAndView mvc = new ModelAndView("index");
        return mvc;
    }

    @RequestMapping("test")
    public ModelAndView testPage() {

        ModelAndView mvc = new ModelAndView("index1");
        return mvc;
    }


}