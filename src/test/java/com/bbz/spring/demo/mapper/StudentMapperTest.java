package com.bbz.spring.demo.mapper;

import com.bbz.spring.demo.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void findByName() {
        Student bbz0;
        for (int i = 0; i < 2; i++) {

            bbz0 = studentMapper.findByName("bbz");
            System.out.println(bbz0);
        }

    }
}