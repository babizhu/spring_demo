package com.bbz.spring.demo;

import com.bbz.spring.demo.mapper.StudentMapper;
import com.bbz.spring.demo.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Function;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DemoApplicationTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
//    private CacheManager cacheManager;


    @Test
    public void index() throws Exception {
        this.mvc.perform(get("/")).andExpect(status().isOk())
                .andExpect(content().string("index111"));
    }

    @Test
    public void name() throws Exception {
        mvc.perform(get("/name")).andExpect(status().isOk())
                .andExpect(content().string("刘老爷"));
    }

    @Autowired
    private StudentMapper studentMapper;

    @Test
    @Rollback
    public void getAllStudent() throws Exception {
        List<Student> allStudent = studentMapper.getAllStudent();
        System.out.println(allStudent);
    }

    @Test
    public void cacheTest(){
        List<Student> allStudent = null;
        for (int i = 0; i < 2; i++) {
            allStudent = studentMapper.getAllStudent();
        }
        System.out.println(allStudent);

        Student student = allStudent.get(0);
        student.setAge(1000);
        studentMapper.update(student);
        System.out.println(studentMapper.getAllStudent());

        System.out.println(studentMapper.findByName(student.getName()));

    }
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;
    @Test
    public void RedisTests() {

        try {
            redisTemplate.opsForValue().set("name", "张三");
            Object object = redisTemplate.opsForValue().get("name");
            System.out.println(object);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    @Transactional
    @Rollback
    public void dbTest() throws Exception {

        for (int i = 0; i < 5; i++) {
            Student student = new Student("bbz" + i, i + 30);
            System.out.println(studentMapper.insert(student));
        }

        Student student = studentMapper.findByName("bbz0");
        System.out.println(student);

        student.setAge(-1);

        studentMapper.update(student);
        student = studentMapper.findByName(student.getName());
        System.out.println(student);

//        studentMapper.delete(student.getId());

        student = studentMapper.findByName(student.getName());
        System.out.println(student);

        int totalAge = studentMapper.getTotalAge();
        System.out.println(totalAge);
    }

    @Test
    public void FunctionTest(){
        Function<Integer, String> function = integer -> integer+"";
        String apply = function.apply(10);
        System.out.println(apply);
    }
}