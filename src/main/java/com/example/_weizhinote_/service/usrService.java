package com.example._weizhinote_.service;

import com.example._weizhinote_.entity.usr;

public interface usrService {
    com.example._weizhinote_.entity.usr getUsrById(int id);

    String register(com.example._weizhinote_.entity.usr usr);

    String login(String username, String password);

    void update(com.example._weizhinote_.entity.usr usr);

    usr getUsrByWeichatId(String weichatid);

    void addVisitNum(int id);

    usr getUsrByUserName(String username);
}
