package com.example._weizhinote_.entity;

import lombok.Data;

import java.util.Date;

@Data
public class remark {
    private String id;
    private String noteid;
    private String userid;
    private String remarkcontent;
    private Date time;
    private long favornum;
}
