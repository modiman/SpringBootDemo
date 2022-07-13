package com.springboot.demo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: modige
 * @date: 2022/7/5 22:47
 * @description:
 */
@Data
public class Account implements Serializable {
    long id;
    String nickname;
    String salt;
    String password;
}
