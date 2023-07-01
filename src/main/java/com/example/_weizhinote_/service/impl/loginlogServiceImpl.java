package com.example._weizhinote_.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example._weizhinote_.entity.loginlog;
import com.example._weizhinote_.service.loginlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example._weizhinote_.mapper.loginlogMapper;
import java.util.List;

@Service
public class loginlogServiceImpl implements loginlogService {

    @Autowired
    private loginlogMapper loginlogMapper;

    @Override
    public List<loginlog> getLoginLog() {
        return loginlogMapper.selectList(null);
    }

    @Override
    public List<loginlog> getLoginLogByUserId(int id) {
        QueryWrapper<loginlog> wrapper= new QueryWrapper<>();
        wrapper.eq("userid", id);
        return loginlogMapper.selectList(wrapper);
    }


}
