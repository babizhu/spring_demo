package com.bbz.spring.demo.services;

import com.bbz.spring.demo.pojo.Student;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class StudentServiceTest {

    @Autowired
    StudentService studentService;
    @Test
    public void save() {
        Student student = new Student("test1", 100);
        studentService.save(student);
        log.info(student.toString());
    }

    @Test
    public void findByNameTest(){
        Student student = studentService.findByName("liulaoye");
        System.out.println(student);

    }

    @Test
    public void updateTest(){
        String name = "test1";

        Student student = studentService.findByName(name);
        System.out.println(student);

        int age = new Random().nextInt(100);
        student.setAge(age);
        studentService.update(student);

        Student student1 = studentService.findByName(name);
        System.out.println(student1);
    }

    @Test
    public void deleteTest(){
        Student student = new Student("test", 20);
        studentService.save(student);
        System.out.println(student);
        studentService.delete(student);
        studentService.findByName(student.getName());
    }


}