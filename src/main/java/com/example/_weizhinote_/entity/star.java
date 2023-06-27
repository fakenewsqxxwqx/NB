package com.example._weizhinote_.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class star {
    @TableId(type = IdType.AUTO)
    private String id;
    private String noteid;
    private String userid;
    private Date time;
}
