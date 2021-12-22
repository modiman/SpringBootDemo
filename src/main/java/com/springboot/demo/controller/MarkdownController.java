package com.springboot.demo.controller;

import org.junit.Test;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Controller
public class MarkdownController {
    @Test
    public void fileRead() throws IOException {
        String md = "";
        md = Files.readString(Paths.get("E:\\gitfile\\notes\\总结.md"));
        System.out.println(md);

    }
}
