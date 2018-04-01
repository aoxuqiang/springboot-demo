package com.miqi.springbootdemo.mapper;

import com.miqi.springbootdemo.domain.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMapper {
    Student getStudentById(int id);
}
