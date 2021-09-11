package com.springboot.demo.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;


@Data
public class Word {
    private int wid;
    private String wname;
    private String wmeaning;
    private String wbuchong;
}
