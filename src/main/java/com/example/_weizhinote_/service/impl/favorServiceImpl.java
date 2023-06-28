package com.example._weizhinote_.service.impl;

import com.example._weizhinote_.service.favorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class favorServiceImpl implements favorService {
    @Autowired
    private favorService favorService;
}
