package com.springboot.demo.mapper;

import com.springboot.demo.model.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.demo.vo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author modige
 * @since 2022-07-08
 */

@Component
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {

    List<GoodsVo> findGoodsVo();
    GoodsVo findGoodsVoByGoodsId(Long goodsId);


}
