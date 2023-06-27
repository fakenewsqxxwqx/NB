package com.example._weizhinote_.entity;

import lombok.Data;

import java.util.Date;

@Data
public class note {
    private String id;
    private String notetitle;
    private String userid;
    private Date time;
    private String type;
    private long starnum;
    private long favornum;
}
