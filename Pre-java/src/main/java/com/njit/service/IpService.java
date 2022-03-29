package com.njit.service;

import com.njit.entity.Ip;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 */
public interface IpService extends IService<Ip> {

    Ip selectByIdCourse(int id_course);

    Ip selectByIpAndId(Ip ip);
}
