package com.example._weizhinote_.entity;

import lombok.Data;

import java.util.Date;

@Data
public class picture {
    private String id;
    private String noteid;
    private String pictureurl;
    private Date time;
}
