package com.miqi.springbootdemo;

import com.miqi.springbootdemo.domain.Student;
import com.miqi.springbootdemo.mapper.StudentMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@SpringBootApplication
@RestController
@MapperScan("com.miqi.springbootdemo.mapper")
public class SpringbootDemoApplication {
	@Resource
	StudentMapper studentMapper;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}

	@RequestMapping("/hello")
	public String sayHello(){
		return "hello,world,ao xuqiang ni shi shui wo de shu";
	}
	@RequestMapping(value = "/student/{id}",method = RequestMethod.POST)
	public Student getStudentById(@PathVariable int id){
		return studentMapper.getStudentById(id);
	}
}
