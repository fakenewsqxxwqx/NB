package com.example._weizhinote_.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class tag {
    @TableId(type = IdType.AUTO)
    private String id;
    private String tagname;
    private String noteid;
    private Date time;
}
