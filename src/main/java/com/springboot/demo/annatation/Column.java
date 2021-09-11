
package com.springboot.demo.annatation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Column {
    String name() default ""; // name用来设置字段名

    //int length() default 0; // length用来设置字段长度
    String title() default "";

    String defaultValue() default ""; // defaultValue用来设置默认值

    int length();

    boolean nullable();
}
