package com.springboot.demo.vo;

import lombok.AllArgsConstructor;
import lombok.ToString;


/**
 * @author: modige
 * @date: 2022/6/28 22:38
 * @description:添加公共结果返回对象
 */

@ToString
@AllArgsConstructor
public enum RespBeanEnum {
    //通用状态码
    SUCCESS(200,"success"),
    ERROR(500,"服务端异常"),
    //登录模块5002xx
    SESSION_ERROR(500210,"session不存在或者已经失效"),
    LOGINVO_ERROR(500211,"用户名或者密码错误"),
    MOBILE_ERROR(500212,"手机号码格式错误"),
    BIND_ERROR(500213,"bind_error") ,
    REPEATE_ERROR (500214,"REPEATE_ERROR"),
    EMPTY_STOCK(500215,"EMPTY_STOCK");
    private final Integer code;
    private final String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
