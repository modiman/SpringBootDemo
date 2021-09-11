package com.springboot.demo.mapper;

import com.springboot.demo.model.Employee;
import com.springboot.demo.model.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface EmployeeMapper {

    @Select("select * from employee ")
    List<Employee> getAllEmployees();


}
