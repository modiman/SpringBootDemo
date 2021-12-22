package com.springboot.demo.controller;

import com.github.pagehelper.PageInfo;
import com.springboot.demo.model.Student;
import com.springboot.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class StudentController {
    public int a = 5;
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/querystudent", method = RequestMethod.GET)
    public Student queryStudentBySno(String sno) {
        return this.studentService.queryStudentBySno(sno);
    }

    Student student = new Student();

    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public void add(Student student) {
        student.setSname("adad" + a++);
        student.setSsex("m");
        student.setSno("s" + a);
        studentService.addStudent(student);
    }
    @RequestMapping(value = "/delStudent")
    public void delString(@RequestParam("sno")String sno) {
        studentService.delStudent(sno);
    }



    @ResponseBody
    @RequestMapping(value = "/students")
    public ModelAndView list(@RequestParam(value = "curr",defaultValue = "1")int curr) {
        List<Student> list = studentService.getAllStudents();
        PageInfo<Student> pageInfo = studentService.findAllStudentByPage(1, 5);
        ModelAndView mvc = new ModelAndView("/student");
    
        mvc.addObject("pageInfo", pageInfo);


        System.out.println("收到请求");
        return mvc;
    }

    @ResponseBody
    @RequestMapping(value = "/dataTable")
    public Map<String,Object> dataTable(@RequestParam(value = "curr",defaultValue = "1")int curr) {
        List<Student> list = studentService.getAllStudents();
        Map<String,Object> map = new   HashMap();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count",list.size());
        map.put("data",list);
        System.out.println("收到请求");
        return map;
    }


}
