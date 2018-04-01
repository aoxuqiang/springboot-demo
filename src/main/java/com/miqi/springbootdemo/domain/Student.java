package com.miqi.springbootdemo.domain;

import org.springframework.stereotype.Repository;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 *  对应 student表
 */
public class Student implements Serializable{

    private static final long serialVersionUID = -3407538386422822084L;
    @Max(value=20,message="id不能超过20")
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
