package com.springboot.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.demo.mapper.StudentMapper;
import com.springboot.demo.model.Student;
import com.springboot.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int add(Student student) {
        return this.studentMapper.add(student);
    }

    @Override
    public int update(Student student) {
        return this.studentMapper.update(student);
    }

    @Override
    public int deleteBysno(String sno) {
        return this.studentMapper.deleteBysno(sno);
    }

    @Override
    public Student queryStudentBySno(String sno) {
        return this.studentMapper.queryStudentBySno(sno);
    }

    @Override
    public List<Student> getAllStudents() {
        return this.studentMapper.getAllStudents();
    }

    @Override
    public PageInfo<Student> findAllStudentByPage(int pageNum, int pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        List<Student> lists = studentMapper.getAllStudents();
        PageInfo<Student> pageInfo = new PageInfo<>(lists);
        return pageInfo;
    }
}