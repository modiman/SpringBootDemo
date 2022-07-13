package com.springboot.demo.mapper;

import com.springboot.demo.model.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: modige
 * @date: 2022/7/5 22:49
 * @description:
 */
@Mapper
@Component
public interface AccountMapper {

    @Select("select * from t_user")
    List<Account> selectAllAccounts();

    @Select("select * from t_user where id = #{id}")
    Account selectById(String id);

}
