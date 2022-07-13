package com.springboot.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.demo.model.Account;
import com.springboot.demo.model.Order;
import com.springboot.demo.vo.GoodsVo;
import org.springframework.stereotype.Service;

/**
 * @author: modige
 * @date: 2022/7/13 17:23
 * @description:订单
 */
@Service
public interface OrderService extends IService<Order> {
    Order seckill(Account user, GoodsVo goods);

}
