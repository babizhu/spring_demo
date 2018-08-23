package com.bbz.spring.demo.mapper;

import com.bbz.spring.demo.pojo.Student;
import org.apache.ibatis.annotations.*;
import org.mapstruct.Mapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
@CacheConfig(cacheNames = "student")
public interface StudentMapper {


    @Select("select * from student")
    @Options(flushCache = Options.FlushCachePolicy.DEFAULT)
    @Cacheable
    List<Student> getAllStudent();

    @Select("SELECT * FROM student WHERE name = #{name}")
    Student findByName(@Param("name") String name);


    @Insert({"INSERT INTO student(name, age) VALUES(#{name}, #{age})"})
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Student student);


    @Update("UPDATE student SET age=#{age} WHERE name=#{name}")
    void update(Student Student);

//    @CacheEvict(value = "user", key = "#user.id", beforeInvocation = false, condition = "#result.username ne 'zhang'")
    @Delete("DELETE FROM student WHERE id =#{id}")
    void delete(Student student);

    @Results({
            @Result(property = "totalAges", column = "totalAges")
    })
    @Select("select sum(age) as totalAges from student")
    int getTotalAge();

    /**
     * 测试标签@Cacheable各种属性
     * 1、自定义key
     * 2、如果结果为null则不缓存
     * 3、value是什么意思？
     * @param name
     * @return
     */
    @Cacheable()
    @CachePut()
    @Select("SELECT * FROM student WHERE name = #{name}")
    Student noCacheIfResultIsNull(@Param("name") String name);
}

