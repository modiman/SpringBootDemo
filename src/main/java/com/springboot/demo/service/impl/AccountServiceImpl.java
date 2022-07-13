package com.springboot.demo.service.impl;

import com.springboot.demo.exception.GlobalException;
import com.springboot.demo.mapper.AccountMapper;
import com.springboot.demo.model.Account;
import com.springboot.demo.service.AccountService;
import com.springboot.demo.util.*;
import com.springboot.demo.vo.LoginVo;
import com.springboot.demo.vo.RespBean;
import com.springboot.demo.vo.RespBeanEnum;
import org.apache.commons.lang3.StringUtils;
import org.apache.jasper.runtime.JspSourceDependent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author: modige
 * @date: 2022/7/5 22:51
 * @description:
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private RedisTemplate redisTemplate;


    @Override
    public List<Account> selectAllAccount() {
        return accountMapper.selectAllAccounts();
    }

    @Override
    public Account selectById(String id) {
        return accountMapper.selectById(id);
    }

    @Override
    public RespBean login(LoginVo loginVo) {

        String mobile = loginVo.getMobile();
        String password = loginVo.getPassword();
//        if (StringUtils.isEmpty(mobile)||StringUtils.isEmpty(password)){
//            return RespBean.error(RespBeanEnum.LOGINVO_ERROR);
//        }
//        if (!ValidatorUtil.isMobile(mobile)){
//            return RespBean.error(RespBeanEnum.MOBILE_ERROR);
//        }
        //根据手机号获取用户


        Account account = accountMapper.selectById(mobile);

        if (null==account){
            return RespBean.error(RespBeanEnum.LOGINVO_ERROR);
        }
        //校验密码
        if
        (!MD5Util.formPassToDBPass(password,account.getSalt()).equals(account.getPassword())){
            throw new GlobalException(RespBeanEnum.LOGINVO_ERROR);

        }
        return RespBean.success();

    }

    @Override
    public RespBean login(HttpServletRequest request, HttpServletResponse response, LoginVo loginVo) {

            String mobile = loginVo.getMobile();
            String password = loginVo.getPassword();
            //根据手机号获取用户
            Account account= accountMapper.selectById(mobile);
            if (null==account){
                throw new GlobalException(RespBeanEnum.LOGINVO_ERROR);
            }
            //校验密码
            if
            (!MD5Util.formPassToDBPass(password,account.getSalt()).equals(account.getPassword())){
                throw new GlobalException(RespBeanEnum.LOGINVO_ERROR);
            }
            //生成cookie
            String ticket = UUIDUtil.uuid();
            System.out.println(ticket);
            System.out.println(account);
//            request.getSession().setAttribute(ticket,account);
        redisTemplate.opsForValue().set("accountTicket:"+ticket,JsonUtil.object2JsonStr(account));
        CookieUtil.setCookie(request,response,"accountTicket",ticket);
        System.out.println(RespBean.success(ticket));
        return RespBean.success(ticket);
    }
    @Override
    public Account getByAccountTicket(String accountTicket, HttpServletRequest request,
                                HttpServletResponse response) {
        if (StringUtils.isEmpty(accountTicket)) {
            return null;
        }
        String accountJson = (String) redisTemplate.opsForValue().get("accountTicket:" +
                accountTicket);


        Account account = JsonUtil.jsonStr2Object(accountJson, Account.class);
        if (null != account) {
            CookieUtil.setCookie(request,response,"accountTicket",accountTicket);
        }
        System.out.println(account);
        return account;
    }

}

