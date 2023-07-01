package com.example._weizhinote_.service;

import com.example._weizhinote_.entity.loginlog;

import java.util.List;

public interface loginlogService {
    List<loginlog> getLoginLog();

    List<loginlog> getLoginLogByUserId(int id);
}
