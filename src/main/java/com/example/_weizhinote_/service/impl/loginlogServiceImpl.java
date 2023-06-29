package com.example._weizhinote_.service.impl;

import com.example._weizhinote_.service.loginlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example._weizhinote_.mapper.loginlogMapper;

@Service
public class loginlogServiceImpl implements loginlogService {
    @Autowired
    private loginlogMapper loginlogMapper;
}
