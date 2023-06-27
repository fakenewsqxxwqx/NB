package com.example._weizhinote_.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example._weizhinote_.entity.usr;
import com.example._weizhinote_.service.usrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example._weizhinote_.mapper.usrMapper;
@Service
public class usrServiceImpl implements usrService {

    @Autowired
    private usrMapper usrMapper;

    public usr getUsrById(String id) {
        return usrMapper.selectById(id);
    }

    public void register(usr usr) {
        usrMapper.insert(usr);
    }

    public String login(String username, String password) {
        QueryWrapper<usr> wrapper= new QueryWrapper<>();
        wrapper.eq("username", username);
        usr usr=usrMapper.selectOne(wrapper);
        if (usr==null){
            return "用户不存在";
        }
        else if (usr.getPassw().equals(password)){
            return "登录成功";
        }
        else {
            return "密码错误";
        }
    }

    public void update(usr usr) {
        QueryWrapper<usr> wrapper= new QueryWrapper<>();
        wrapper.eq("id", usr.getId());
        usrMapper.update(usr, wrapper);
    }
}
