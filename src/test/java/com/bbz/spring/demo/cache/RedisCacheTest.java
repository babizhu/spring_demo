package com.bbz.spring.demo.cache;

import com.bbz.spring.demo.mapper.StudentMapper;
import com.bbz.spring.demo.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest

public class RedisCacheTest {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private CacheManager cacheManager;


    @Test
    public void cacheManagerTest() {
        Collection<String> cacheNames = cacheManager.getCacheNames();
        for (String cacheName : cacheNames) {
            System.out.println(cacheName);
        }

        System.out.println(cacheManager.getClass().getCanonicalName());
    }

    @Test
    public void noCacheIfResultIsNull() {
        Student student = studentMapper.noCacheIfResultIsNull("bbz");
        System.out.println(student);
    }

    @Test
    public void deleteAndAddTest() {
        Student student = new Student("test2", 100);
        studentMapper.insert(student);
        Student result = studentMapper.findByName(student.getName());//测试是否查询了数据库
        System.out.println(result);

    }
}