package com.njit.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tbl_course")
public class Course implements Serializable {

//    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private int id;

    private String title;

    private String teacher;

    private String tecnology;

    @TableField("courseText")
    private String courseText;

    @TableField("tvTime")
    private String tvTime;

    private String currentnums;


}
