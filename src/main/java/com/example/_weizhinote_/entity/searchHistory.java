package com.example._weizhinote_.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class searchHistory {
    @TableId(type = IdType.AUTO)
    private String id;
    private String userid;
    private String keyword;
    private String url;
    private Date time;
}
