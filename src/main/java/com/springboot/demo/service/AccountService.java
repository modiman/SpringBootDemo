package com.springboot.demo.service;

import com.springboot.demo.model.Account;
import com.springboot.demo.vo.LoginVo;
import com.springboot.demo.vo.RespBean;
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
public interface AccountService {
    List<Account> selectAllAccount();

    Account selectById(String id);

    RespBean login(LoginVo loginVo);

    RespBean login(HttpServletRequest request, HttpServletResponse response,
                   LoginVo loginVo);

    Account getByAccountTicket(String accountTicket, HttpServletRequest request,
                                   HttpServletResponse response);






}
