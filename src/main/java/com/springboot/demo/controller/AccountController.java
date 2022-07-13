package com.springboot.demo.controller;

import com.springboot.demo.mapper.AccountMapper;
import com.springboot.demo.model.Account;
import com.springboot.demo.service.AccountService;
import com.springboot.demo.vo.LoginVo;
import com.springboot.demo.vo.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author: modige
 * @date: 2022/7/5 22:53
 * @description:
 */
@RestController
@Slf4j
public class AccountController {
    @Autowired
    private AccountService accountService;
    @GetMapping("account")
    public String accountList() {

        List<Account> accountList = accountService.selectAllAccount();
        System.out.println(accountList.size());


        return "success";
    }
    @PostMapping("login/doLogin")
    @ResponseBody

    public RespBean doLogin(HttpServletRequest request, HttpServletResponse
            response, @Valid LoginVo loginVo) {//@Valid,判断手机号格式是否正确
        log.info(loginVo.toString());
        return accountService.login(request, response, loginVo);
    }






    @GetMapping("account/{id}")
    public String accountList(@PathVariable("id") String id) {
        long accountId = Integer.parseInt(id);
        System.out.println(id);

        System.out.println(accountService.selectById(accountId+""));



        return "success";
    }

}
