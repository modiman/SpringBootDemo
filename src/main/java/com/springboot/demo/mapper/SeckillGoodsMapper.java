package com.springboot.demo.mapper;

import com.springboot.demo.model.SeckillGoods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 秒杀商品表 Mapper 接口
 * </p>
 *
 * @author zhoubin
 * @since 2022-07-13
 */
@Component
@Mapper
public interface SeckillGoodsMapper extends BaseMapper<SeckillGoods> {

}
