package com.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//@RestController
//少了上面这个注解会报错 Whitelabel Error Page
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =

                SpringApplication.run(DemoApplication.class, args);

    //    JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

    }



}