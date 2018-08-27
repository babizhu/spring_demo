package com.bbz.spring.demo.services;

import com.bbz.spring.demo.mapper.StudentMapper;
import com.bbz.spring.demo.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = "student")
@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @CachePut(key = "#student.name",unless = "#result eq null")
    public Student save(Student student){
        studentMapper.insert(student);
        return student;
    }

    @Cacheable(unless = "#result eq null ")
    public Student findByName(@Param("name") String name){
        return studentMapper.findByName(name);
    }

    @CachePut(key = "#p0.name")
    public Student update(Student student){
        studentMapper.update(student);
        return student;
    }

    @CacheEvict(key = "#student.name")
    public Student delete(Student student){
        studentMapper.delete(student);
        return student;
    }
}
