package com.njit.mapper;

import com.njit.entity.Ip;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 */
public interface IpMapper extends BaseMapper<Ip> {

    Ip selectByIdCourse(int id_course);

    Ip selectByIpAndId(Ip ip);


}
