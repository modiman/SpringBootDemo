package com.springboot.demo.controller;

import com.github.pagehelper.PageInfo;
import com.springboot.demo.model.Student;
import com.springboot.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


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
        studentService.add(student);
    }

    @ResponseBody
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ModelAndView list() {
        List<Student> list = studentService.getAllStudents();
        PageInfo<Student> s = studentService.findAllStudentByPage(1, 5);
        ModelAndView mvc = new ModelAndView("/student");
        mvc.addObject("students", list);
        mvc.addObject("pageInfo", s);

        mvc.addObject("page", s.getList());
        return mvc;
    }
}
