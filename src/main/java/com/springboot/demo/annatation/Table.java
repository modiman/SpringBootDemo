package com.springboot.demo.annatation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//自定义Table 注解
//目的是把@Table(name = "Student")转换成类似如下的SQL语句：
//create table Student(age NUMBER(3),userName VARCHAR2(10),birthday DATE default sysdate)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Table {
    String name(); // name用来设置表名


}
