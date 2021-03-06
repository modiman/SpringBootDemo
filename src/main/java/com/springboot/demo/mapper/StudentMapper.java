package com.springboot.demo.mapper;

import com.springboot.demo.model.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface StudentMapper {
//    @Insert("insert into student(sno,sname,ssex) values(#{sno},#{name},#{sex})")
    int addStudent(Student student);

    @Update("update student set sname=#{name},ssex=#{sex} where sno=#{sno}")
    int update(Student student);

//    @Delete("delete from student where sno=#{sno}")
    int delStudent(String sno);

    @Select("select * from student where sno=#{sno}")
    @Results(id = "student", value = {
            @Result(property = "sno", column = "sno", javaType = String.class),
            @Result(property = "name", column = "sname", javaType = String.class),
            @Result(property = "sex", column = "ssex", javaType = String.class)
    })
    Student queryStudentBySno(String sno);



    List<Student> getAllStudents();


}