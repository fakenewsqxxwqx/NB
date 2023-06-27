package com.example._weizhinote_.entity;

import lombok.Data;

import java.util.Date;

@Data
public class usr {
    private String id;
    private String username;
    private String passw;
    private long notenum;
    private long visitnum;
    private String role;
    private Date time;
    private String photourl;
}
