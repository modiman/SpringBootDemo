package com.springboot.demo.service;

import com.springboot.demo.model.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.demo.vo.GoodsVo;

import java.util.List;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author modige
 * @since 2022-07-08
 */
public interface IGoodsService extends IService<Goods> {
    List<GoodsVo> findGoodsVo();
    GoodsVo findGoodsVoByGoodsId(Long goodsId);

}
