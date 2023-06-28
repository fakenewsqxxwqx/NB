package com.example._weizhinote_.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class tag {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String tagname;
    private int noteid;
    private Date time;
}
