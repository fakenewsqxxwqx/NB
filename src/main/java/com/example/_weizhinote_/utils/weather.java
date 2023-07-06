package com.example._weizhinote_.utils;

import lombok.Data;

@Data
public class weather {

    private String address;
    private String cityCode;
    private String temp;
    private String weather;
    private String windDirection;
    private String windPower;
    private String humidity;
    private String reportTime;
}
