package com.example._weizhinote_.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class remark {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private int noteid;
    private String userid;
    private String remarkcontent;
    private Date time;
    private long favornum;
}
