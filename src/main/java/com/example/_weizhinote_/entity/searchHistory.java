package com.example._weizhinote_.entity;

import lombok.Data;

import java.util.Date;

@Data
public class searchHistory {
    private String id;
    private String userid;
    private String keyword;
    private String url;
    private Date time;
}
