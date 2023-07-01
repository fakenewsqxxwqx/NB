package com.example._weizhinote_.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class remarkfavor {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private int remarkid;
    private Integer userid;
    private Date time;
}
