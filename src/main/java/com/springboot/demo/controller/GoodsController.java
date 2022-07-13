package com.springboot.demo.controller;

/**
 * @author: modige
 * @date: 2022/7/6 13:09
 * @description:登陆成功跳转页
 */
import com.springboot.demo.model.Account;
import com.springboot.demo.service.AccountService;
import com.springboot.demo.service.IGoodsService;
import com.springboot.demo.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 商品
 *
 * @author zhoubin
 * @since 1.0.0
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private IGoodsService iGoodsService;

    /**
     * 跳转登录页
     *
     * @return
     */
    @RequestMapping("/toList")
    public String toLogin(HttpServletRequest request, HttpServletResponse
            response, Model model, @CookieValue("accountTicket") String ticket) {
        System.out.println(ticket);
        if (StringUtils.isEmpty(ticket)) {
            return "login";
        }
        Account account = accountService.getByAccountTicket(ticket,request,response);

        if (null == account) {
            return "login";
        }
        List<GoodsVo> goods = iGoodsService.findGoodsVo();
        System.out.println(goods);
        model.addAttribute("goods", goods);

        model.addAttribute("user", account);
        return "goodsInfo";
    }


    @RequestMapping("/toDetail/{goodsId}")
    public String toDetail(Model model, @CookieValue("accountTicket") String ticket, @PathVariable Long goodsId,HttpServletRequest request, HttpServletResponse
            response) {
        Account account = accountService.getByAccountTicket(ticket,request,response);

        model.addAttribute("user", account);

        GoodsVo goods = iGoodsService.findGoodsVoByGoodsId(goodsId);
        model.addAttribute("goods", goods);
        Date startDate = goods.getStartDate();
        Date endDate = goods.getEndDate();
        Date nowDate = new Date();
        //秒杀状态
        int secKillStatus = 0;
        //剩余开始时间
        int remainSeconds = 0;
        //秒杀还未开始
        if (nowDate.before(startDate)) {
            remainSeconds = (int) ((startDate.getTime()-nowDate.getTime())/1000);
            // 秒杀已结束
        } else if (nowDate.after(endDate)) {
            secKillStatus = 2;
            remainSeconds = -1;
            // 秒杀中
        } else {
            secKillStatus = 1;
            remainSeconds = 0;
        }
        model.addAttribute("secKillStatus",secKillStatus);
        model.addAttribute("remainSeconds",remainSeconds);
        return "goodsDetail";
    }




}
