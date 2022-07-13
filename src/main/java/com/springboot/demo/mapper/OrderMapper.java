package com.springboot.demo.mapper;

import com.springboot.demo.model.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.demo.model.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhoubin
 * @since 2022-07-13
 */
@Component
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
