package com.springboot.demo.service;

//import com.github.pagehelper.PageInfo;

import com.github.pagehelper.PageInfo;
import com.springboot.demo.model.Student;


import java.util.List;

public interface StudentService {
    int addStudent(Student student);

    int update(Student student);

    int delStudent(String sno);

    Student queryStudentBySno(String sno);

    List<Student> getAllStudents();

    PageInfo<Student> findAllStudentByPage(int pageNum, int pageSize);
}
