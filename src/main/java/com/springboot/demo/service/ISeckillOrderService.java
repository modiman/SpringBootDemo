package com.springboot.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.demo.model.Account;
import com.springboot.demo.model.SeckillGoods;
import com.springboot.demo.model.SeckillOrder;
import org.springframework.stereotype.Service;

/**
 * @author: modige
 * @date: 2022/7/13 19:49
 * @description:
 */
@Service
public interface ISeckillOrderService   extends IService<SeckillOrder>{
        boolean save(SeckillOrder seckillOrder);
        Long getResult(Account tUser, Long goodsId);

}
