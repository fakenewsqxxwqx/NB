package com.example._weizhinote_.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example._weizhinote_.entity.loginlog;
import com.example._weizhinote_.entity.note;
import com.example._weizhinote_.entity.usr;
import com.example._weizhinote_.mapper.loginlogMapper;
import com.example._weizhinote_.service.usrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example._weizhinote_.mapper.usrMapper;
import com.example._weizhinote_.mapper.noteMapper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class usrServiceImpl implements usrService {

    @Autowired
    private noteMapper noteMapper;
    @Autowired
    private usrMapper usrMapper;
    @Autowired
    private loginlogMapper loginlogMapper;

    public usr getUsrById(String id) {
        //计算用户笔记数
        QueryWrapper<note> wrapper= new QueryWrapper<>();
        wrapper.eq("id", id);
        long noteNum=noteMapper.selectCount(wrapper);

        usr usr=usrMapper.selectById(id);
        usr.setNotenum(noteNum);

        //纪录登录日志
        loginlog loginlog=new loginlog();
        loginlog.setUserid(usr.getId());
        LocalDateTime localDateTime = LocalDateTime.now();
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);
        loginlog.setTime(date);
        loginlogMapper.insert(loginlog);

        return usr;
    }

    public String register(usr usr) {
        QueryWrapper<usr> wrapper= new QueryWrapper<>();
        wrapper.eq("username", usr.getUsername());
        usr usr1=usrMapper.selectOne(wrapper);
        if (usr1==null){
            usrMapper.insert(usr);
            return "注册成功";
        }
        else {
            return "用户名已存在";
        }
    }

    public String login(String username, String password) {
        QueryWrapper<usr> wrapper= new QueryWrapper<>();
        wrapper.eq("username", username);
        usr usr=usrMapper.selectOne(wrapper);
        if (usr==null){
            return "用户不存在";
        }
        else if (usr.getPassw().equals(password)){
            //登录成功，记录登录日志
            loginlog loginlog=new loginlog();
            loginlog.setUserid(usr.getId());
            LocalDateTime localDateTime = LocalDateTime.now();
            Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
            Date date = Date.from(instant);
            loginlog.setTime(date);
            loginlogMapper.insert(loginlog);

            return "登录成功";
        }
        else {
            return "密码错误";
        }
    }

    public void update(usr usr) {
        System.out.println("updateService");
        QueryWrapper<usr> wrapper= new QueryWrapper<>();
        wrapper.eq("id", usr.getId());
        usrMapper.update(usr, wrapper);
    }
}
