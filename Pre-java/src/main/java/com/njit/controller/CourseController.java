package com.njit.controller;


import com.njit.entity.Course;
import com.njit.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping("/select")
    public Object select() {
        return courseService.selectAll();
    }

    @RequestMapping("/save")
    public Object save(Course course) {
        boolean save = courseService.save(course);
        if (save){
            return "保存成功";
        }else {
            return "保存失败";
        }
    }

    @RequestMapping("/updateNumsById")
    public Object addnums(Course course) {

        int idi = courseService.updateByIdi(course);
        if (idi>0){
            return "修改成功";
        }else {
            return "修改失败";
        }
    }

    @RequestMapping("/delCouresById")
    public Object delCouresById(Integer id) {
        boolean byId = courseService.removeById(id);
        if (byId){
            return "删除成功";
        }else {
            return "删除失败";
        }
    }

    @RequestMapping("/getCourseById")
    public Object getCourseById(Integer id) {
        Course course = courseService.queryById(id);
        if (course!=null){
            return course;
        }
        return "查询失败";
    }

    @RequestMapping("/updateCourse")
    public Object updateCourse(Course course) {
        boolean update = courseService.updateById(course);
        if (update){
            return "修改成功";
        }
        return "修改失败";
    }

}
