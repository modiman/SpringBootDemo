package com.springboot.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.demo.mapper.SeckillOrderMapper;
import com.springboot.demo.model.Account;
import com.springboot.demo.model.SeckillOrder;
import com.springboot.demo.service.ISeckillOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: modige
 * @date: 2022/7/13 21:09
 * @description:
 */
@Service
@Primary
public class ISeckillOrderServiceImpl extends ServiceImpl<SeckillOrderMapper, SeckillOrder> implements ISeckillOrderService {

    @Autowired
    private SeckillOrderMapper tSeckillOrderMapper;
    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public boolean save(SeckillOrder seckillOrder) {
        return false;
    }

    @Override
    public Long getResult(Account tUser, Long goodsId) {

        SeckillOrder tSeckillOrder = tSeckillOrderMapper.selectOne(new QueryWrapper<SeckillOrder>().eq("user_id", tUser.getId()).eq("goods_id", goodsId));
        if (null != tSeckillOrder) {
            return tSeckillOrder.getOrderId();
        } else if (redisTemplate.hasKey("isStockEmpty:" + goodsId)) {
            return -1L;
        } else {
            return 0L;
        }

    }
}