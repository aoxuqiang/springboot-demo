package com.miqi.springbootdemo;

import com.miqi.springbootdemo.domain.Student;
import com.miqi.springbootdemo.dto.ApiRet;
import com.miqi.springbootdemo.mapper.StudentMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

@SpringBootApplication
@RestController
@MapperScan("com.miqi.springbootdemo.mapper")
public class SpringbootDemoApplication {
    private Logger log = LoggerFactory.getLogger(SpringbootDemoApplication.class);
    @Resource
    StudentMapper studentMapper;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }

    @RequestMapping("/hello")
    public String sayHello() {
        return "hello,world,ao xuqiang ni shi shui wo de shu";
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.POST)
    public Student getStudentById(@PathVariable int id) {
        return studentMapper.getStudentById(id);
    }

    @RequestMapping(value = "/student")
    @Transactional
    public ApiRet addStudents() {
        ApiRet ret = new ApiRet();
        Student s1 = new Student(2, "gaomin");
        studentMapper.insertStudent(s1);
        Student s2 = new Student(3, "gaojinpingjfkdfkajfjkadfjakdfjkdfkaksdfas");
        studentMapper.insertStudent(s2);

        ret.setRet(0);
        ret.setMsg("insert successfully!");
        return ret;
    }

    @RequestMapping("/addStudent")
    public ApiRet addStudent(@Valid Student student, BindingResult result){
        ApiRet ret = new ApiRet();
        if(result.hasErrors()){
            ret.setRet(1002);
            ret.setMsg(result.getFieldError().getDefaultMessage());
            return ret;
        }
        studentMapper.insertStudent(student);
        ret.setRet(0);
        ret.setMsg("insert successfully!");
        return ret;
    }

}
