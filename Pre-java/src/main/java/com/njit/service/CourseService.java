package com.njit.service;

import com.njit.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 */
public interface CourseService extends IService<Course> {

    List<Course> selectAll();

    int updateByIdi(Course course);

    Course queryById(Integer id);
}
