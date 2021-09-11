package com.springboot.demo.model;

import com.springboot.demo.annatation.Table;
import lombok.Data;

import javax.persistence.Id;

@Data
@Table(name = "employee")
public class Employee {
    @Id
    private String employee_id;

    private String employee_name;
    private String employee_birthday;
    private String department_id;

}
