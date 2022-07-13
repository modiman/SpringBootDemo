package com.springboot.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springboot.demo.service.AccountService;
import org.springframework.ui.Model;
import com.springboot.demo.model.Account;
import com.springboot.demo.model.Order;
import com.springboot.demo.model.SeckillOrder;
import com.springboot.demo.service.IGoodsService;
import com.springboot.demo.service.ISeckillOrderService;
import com.springboot.demo.service.OrderService;
import com.springboot.demo.vo.GoodsVo;
import com.springboot.demo.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: modige
 * @date: 2022/7/13 20:03
 * @description:
 */
@Controller
@RequestMapping("/seckill")

public class SeckillController {
    @Autowired
    private IGoodsService goodsService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private ISeckillOrderService seckillOrderService;
    @Autowired
    private OrderService orderService;
    @RequestMapping("/doSeckill")
    public String doSeckill(Model model, @CookieValue("accountTicket") String ticket, Long goodsId, HttpServletRequest request, HttpServletResponse
            response) {
        Account user =  accountService.getByAccountTicket(ticket,request,response);


        if (user == null) {
            return "login";
        }
        model.addAttribute("user", user);
        GoodsVo goods = goodsService.findGoodsVoByGoodsId(goodsId);

        //判断库存
        if (goods.getStockCount() < 1) {
            model.addAttribute("errmsg", RespBeanEnum.EMPTY_STOCK.getMessage());
            return "seckillFail";
        }
//        //判断是否重复抢购
        SeckillOrder seckillOrder = seckillOrderService.getOne(new
                QueryWrapper<SeckillOrder>().eq("user_id", user.getId()).eq(
                "goods_id",
                goodsId));
        if (seckillOrder != null) {
            model.addAttribute("errmsg", RespBeanEnum.REPEATE_ERROR.getMessage());
            return "seckillFail";
        }
        //添加订单
        Order order = orderService.seckill(user, goods);
        model.addAttribute("order",order);
        model.addAttribute("goods",goods);
        return "orderDetail";
    }
}
