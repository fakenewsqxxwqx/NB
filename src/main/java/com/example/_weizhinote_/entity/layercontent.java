package com.example._weizhinote_.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class layercontent {
    @TableId(type = IdType.AUTO)
    private int id;
    private int noteid;
    private Date time;
    private String content;
    private int layer;
}
