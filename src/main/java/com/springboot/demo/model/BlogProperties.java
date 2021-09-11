package com.springboot.demo.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity
//@Table(name = "blog")
@Component
public class BlogProperties {

//    @Id
//
//    //@Column(name = "name")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//
//    @Column(name = "name", length = 20, nullable = false)
//    //private String name;

    @Value("${mrbird.blog.name}")
    private String name;
    //  @Column(name = "title")
    @Value("${mrbird.blog.title}")
    private String title;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}