package com.example._weizhinote_.entity;

import lombok.Data;

import java.util.Date;

@Data
public class layercontent {
    private String id;
    private String noteid;
    private Date time;
    private String content;
    private int layer;
}
