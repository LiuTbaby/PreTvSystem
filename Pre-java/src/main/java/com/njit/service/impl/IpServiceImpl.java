package com.njit.service.impl;

import com.njit.entity.Ip;
import com.njit.mapper.IpMapper;
import com.njit.service.IpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 */
@Service
public class IpServiceImpl extends ServiceImpl<IpMapper, Ip> implements IpService {

    @Autowired
    IpMapper ipMapper;
    @Override
    public Ip selectByIdCourse(int id_course) {
        return ipMapper.selectByIdCourse(id_course);
    }

    @Override
    public Ip selectByIpAndId(Ip ip) {
        return ipMapper.selectByIpAndId(ip);
    }
}
