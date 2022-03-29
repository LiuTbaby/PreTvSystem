package com.njit.controller;


import com.njit.entity.Ip;
import com.njit.service.IpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/ip")
public class IpController {

    @Autowired
    IpService ipService;

    @RequestMapping("/selectPreIp")
    public Object selectPreIp(HttpServletRequest request, Ip ip,int id_course) {
        //获得访问Ip
        String localAddr = request.getLocalAddr();
        //通过课程id查询Ip是否存在
        Ip count = ipService.selectByIdCourse(id_course);
        Map<String,Object> map = new HashMap<>();
        if (count!=null){
            map.put("code",1);
            map.put("massage","你已经预约过了");
            return map;
        }

        ip.setIp(localAddr);
        ip.setId_course(id_course);
        boolean save = ipService.save(ip);
        if (save){
            map.put("code",0);
            map.put("massage","预约成功");
            return  map;
        }
        return "系统忙，请稍后......";
    }


    @RequestMapping("/selectDelIp")
    public Object selectDelIp(HttpServletRequest request,Ip ip,int id_course) {
        //获得访问Ip
        String localAddr = request.getLocalAddr();
        //通过Ip查询Ip是否存在
        ip.setIp(localAddr);
        ip.setId_course(id_course);
        Ip count = ipService.selectByIpAndId(ip);
        Map<String,Object> map = new HashMap<>();
        //存在，删除对应的ip记录
        if (count!=null){
            boolean removeById = ipService.removeById(count.getId());
            if (removeById) {
                map.put("code",1);
                map.put("massage","取消预约成功");
                return map;
            }
            return "系统忙.请稍后......";
        }
        //不存在，返回结果，不删除
            map.put("code",0);
            map.put("massage","请先预约");
            return  map;
    }
}
