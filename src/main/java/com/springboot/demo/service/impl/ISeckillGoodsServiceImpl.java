package com.springboot.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.demo.mapper.SeckillGoodsMapper;
import com.springboot.demo.model.SeckillGoods;
import com.springboot.demo.model.SeckillOrder;
import com.springboot.demo.service.ISeckillGoodsService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @author: modige
 * @date: 2022/7/13 21:03
 * @description:
 */
@Primary
@Service
public class ISeckillGoodsServiceImpl extends ServiceImpl<SeckillGoodsMapper, SeckillGoods> implements ISeckillGoodsService {


}
