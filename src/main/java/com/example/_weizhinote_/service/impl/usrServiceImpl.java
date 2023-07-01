package com.example._weizhinote_.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example._weizhinote_.entity.loginlog;
import com.example._weizhinote_.entity.usr;
import com.example._weizhinote_.mapper.loginlogMapper;
import com.example._weizhinote_.service.usrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example._weizhinote_.mapper.usrMapper;
import com.example._weizhinote_.utils.passwordEncoder;
import com.example._weizhinote_.utils.currentTime;

@Service
public class usrServiceImpl implements usrService {

    @Autowired
    private usrMapper usrMapper;
    @Autowired
    private loginlogMapper loginlogMapper;

    private void loginLogInsert(usr usr){
        //纪录登录日志
        loginlog loginlog=new loginlog();
        loginlog.setUserid(usr.getId());
        loginlog.setTime(currentTime.getCurrentTime());
        loginlogMapper.insert(loginlog);

    }

    @Override
    public usr getUsrById(int id) {

        usr usr=usrMapper.selectById(id);
        return usr;
    }



    @Override
    public String register(usr usr) {
        QueryWrapper<usr> wrapper= new QueryWrapper<>();
        wrapper.eq("username", usr.getUsername());
        usr usr1=usrMapper.selectOne(wrapper);
        if (usr1==null){
            usr.setPassw(passwordEncoder.encode(usr.getPassw()));
            usr.setVisitnum(0);
            if(usr.getRole()==null) usr.setRole("user");
            usr.setTime(currentTime.getCurrentTime());
            usrMapper.insert(usr);
            loginLogInsert(usr);
            return "注册成功";
        }
        else {
            return "用户名已存在";
        }
    }

    @Override
    public String login(String username, String password){
        QueryWrapper<usr> wrapper= new QueryWrapper<>();
        wrapper.eq("username", username);
        usr usr=usrMapper.selectOne(wrapper);
        if(usr==null){
            return "用户不存在";
        }
        else if(passwordEncoder.matches(password, usr.getPassw())){
            loginLogInsert(usr);
            return "登录成功";
        }
        else {
            return "密码错误";
        }
    }
    @Override
    public void update(usr usr) {
        QueryWrapper<usr> wrapper= new QueryWrapper<>();
        wrapper.eq("id", usr.getId());
        usr.setPassw(passwordEncoder.encode(usr.getPassw()));
        usr.setTime(currentTime.getCurrentTime());
        usrMapper.update(usr, wrapper);
    }

    @Override
    public usr getUsrByWeichatId(String weichatid) {
        QueryWrapper<usr> wrapper= new QueryWrapper<>();
        wrapper.eq("weichatid", weichatid);
        usr usr=usrMapper.selectOne(wrapper);
        loginLogInsert(usr);
        return usr;
    }

    @Override
    public void addVisitNum(int id) {
        usr usr=usrMapper.selectById(id);
        usr.setVisitnum(usr.getVisitnum()+1);
        usrMapper.updateById(usr);
    }

}
