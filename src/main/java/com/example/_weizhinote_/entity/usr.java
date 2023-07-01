package com.example._weizhinote_.entity;

import lombok.Data;

import java.util.Date;

@Data
public class usr {
    private Integer id;
    private String wechatid;
    private String username;
    private String passw;
    private long visitnum;
    private String role;
    private Date time;
    private String photourl;
}
