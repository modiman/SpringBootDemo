package com.springboot.demo.service;

//import com.github.pagehelper.PageInfo;

import com.github.pagehelper.PageInfo;
import com.springboot.demo.model.Employee;
import com.springboot.demo.model.Student;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface EmployeeService {


    List<Employee> getAllEmployees();

    PageInfo<Employee> findAllEmployeesByPage(int pageNum, int pageSize);
}
