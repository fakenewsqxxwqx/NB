package com.example._weizhinote_.entity;

import lombok.Data;

import java.util.Date;

@Data
public class tag {
    private String id;
    private String tagname;
    private String noteid;
    private Date time;
}
