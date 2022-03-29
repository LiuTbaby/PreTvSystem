package com.njit;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.njit.entity.Course;
import com.njit.entity.Ip;
import com.njit.mapper.CourseMapper;
import com.njit.mapper.IpMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PreJavaApplicationTests {

    @Autowired
    CourseMapper courseMapper;
    @Autowired
    IpMapper ipMapper;
    @Test
    void contextLoads() {
        Course course = new Course();
        course.setId(150);
        course.setCurrentnums("35");
        int updateById = courseMapper.updateById(course);
        System.out.println(updateById);
    }

    @Test
    void testselectList() {
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNotNull("title");
        List<Course> courses = courseMapper.selectList(queryWrapper);
        courses.forEach(System.out::println);
    }
    @Test
    void testselectByIp() {
        Ip ip = new Ip();
        ip.setIp("0:0:0:0:0:0:0:1");
        ip.setId_course(1);
        Ip ip1 = ipMapper.selectByIpAndId(ip);
        System.out.println(ip1);
    }

}
