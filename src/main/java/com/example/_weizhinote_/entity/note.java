package com.example._weizhinote_.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class note {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String notetitle;
    private String userid;
    private Date time;
    private String type;
    private long starnum;
    private long favornum;
    private long remarknum;
    private byte permission;
}
