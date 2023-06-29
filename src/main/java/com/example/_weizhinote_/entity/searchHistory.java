package com.example._weizhinote_.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value="searchhistory")
public class searchHistory {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String userid;
    private String keyword;
    private String url;
    private Date time;
}
