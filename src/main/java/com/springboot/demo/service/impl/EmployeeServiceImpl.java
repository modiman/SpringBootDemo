package com.springboot.demo.service.impl;

import com.github.pagehelper.PageInfo;
import com.springboot.demo.model.Employee;
import com.springboot.demo.model.User;
import com.springboot.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeService employeeService;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @Override
    public PageInfo<Employee> findAllEmployeesByPage(int pageNum, int pageSize) {
        return employeeService.findAllEmployeesByPage(pageNum, pageSize);
    }

}
