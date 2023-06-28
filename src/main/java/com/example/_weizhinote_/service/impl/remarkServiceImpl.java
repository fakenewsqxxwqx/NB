package com.example._weizhinote_.service.impl;

import com.example._weizhinote_.entity.remark;
import com.example._weizhinote_.service.remarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example._weizhinote_.mapper.remarkMapper;
@Service
public class remarkServiceImpl implements remarkService {

    @Autowired
    private remarkMapper remarkMapper;
    @Override
    public void addRemark(remark remark1) {
        remark1.setId(null);
        remark1.setFavornum(0);
        remarkMapper.insert(remark1);
    }

    @Override
    public void updateRemark(int id, int flag) {
        remark remark1 = remarkMapper.selectById(id);
        if(flag==1)
        {
            remark1.setFavornum(remark1.getFavornum()+1);
        }
        else
        {
            remark1.setFavornum(remark1.getFavornum()-1);
        }
        remarkMapper.updateById(remark1);
    }


}
