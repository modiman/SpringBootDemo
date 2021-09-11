package com.springboot.demo.mapper;

import com.springboot.demo.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserMapper {
    List<User> getAllUsers();

//    @Insert("insert into users values("+"'dsad'"+','+"'dsad'"+','+"'dsad'"+')')
//@Insert("insert into users values("+"'#{uid}'"+','+"'#{uname}'"+','+"'#{uage}'"+')')

void addUser(User user);
void editUser(User user);
void delUser(String uid);
}

