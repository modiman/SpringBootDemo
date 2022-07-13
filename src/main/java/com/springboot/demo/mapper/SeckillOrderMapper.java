package com.springboot.demo.mapper;

import com.springboot.demo.model.SeckillOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 秒杀订单表 Mapper 接口
 * </p>
 *
 * @author zhoubin
 * @since 2022-07-13
 */
@Mapper
@Component
public interface SeckillOrderMapper extends BaseMapper<SeckillOrder> {
    boolean save(SeckillOrder seckillOrder);
}
