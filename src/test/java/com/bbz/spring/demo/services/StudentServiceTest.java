package com.bbz.spring.demo.services;

import com.bbz.spring.demo.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {

    @Autowired
    StudentService studentService;
    @Test
    public void save() {
        Student student = new Student("test3", 100);
        studentService.save(student);
        System.out.println(student);
    }

    @Test
    public void findByNameTest(){
        Student student = studentService.findByName("liulaoye");
        System.out.println(student);
    }

    @Test
    public void updateTest(){
        String name = "bbz";

        Student student = studentService.findByName(name);
        System.out.println(student);

        int age = new Random().nextInt();
        student.setAge(age);
        studentService.update(student);

        Student student1 = studentService.findByName(name);
        System.out.println(student1);
    }

    @Test
    public void deleteTest(){
        Student student = new Student("test1", 20);
        studentService.save(student);
        System.out.println(student);

        studentService.delete(student);
        studentService.findByName(student.getName());
    }


}