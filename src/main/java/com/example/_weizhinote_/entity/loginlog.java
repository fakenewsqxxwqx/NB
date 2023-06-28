package com.example._weizhinote_.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class loginlog {
    @TableId(type = IdType.AUTO)
    private int id;
    private String userid;
    private Date time;
}
