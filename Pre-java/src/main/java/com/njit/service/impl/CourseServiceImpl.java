package com.njit.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.njit.entity.Course;
import com.njit.mapper.CourseMapper;
import com.njit.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {
    @Autowired
    CourseMapper courseMapper;
    @Override
    public List<Course> selectAll() {
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNotNull("title");
        List<Course> courses = courseMapper.selectList(queryWrapper);
        return courses;
    }

    @Override
    public int updateByIdi(Course course) {
        int byId = courseMapper.updateById(course);
        return byId;
    }

    @Override
    public Course queryById(Integer id) {
        Course course = courseMapper.selectById(id);
        return course;
    }


}
