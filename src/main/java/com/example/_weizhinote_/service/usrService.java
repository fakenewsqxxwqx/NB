package com.example._weizhinote_.service;

public interface usrService {
    com.example._weizhinote_.entity.usr getUsrById(String id);

    String register(com.example._weizhinote_.entity.usr usr);

    String login(String username, String password);

    void update(com.example._weizhinote_.entity.usr usr);

}
