package com.example._weizhinote_.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example._weizhinote_.entity.note;
import com.example._weizhinote_.entity.remark;
import com.example._weizhinote_.entity.usr;
import com.example._weizhinote_.service.remarkService;
import com.example._weizhinote_.utils.currentTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example._weizhinote_.mapper.remarkMapper;
import com.example._weizhinote_.mapper.usrMapper;
import java.util.List;
import com.example._weizhinote_.mapper.noteMapper;
@Service
public class remarkServiceImpl implements remarkService {

    @Autowired
    private remarkMapper remarkMapper;

    @Autowired
    private usrMapper usrMapper;

    @Autowired
    private noteMapper noteMapper;
    @Override
    public void addRemark(remark remark1) {
        remark1.setId(null);
        remark1.setFavornum(0);
        remark1.setTime(currentTime.getCurrentTime());
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
        remark1.setTime(currentTime.getCurrentTime());
        remarkMapper.updateById(remark1);
    }

    @Override
    public List<remark> getRemarkByNoteId(int id){
        QueryWrapper<remark> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("noteid",id);
        return remarkMapper.selectList(queryWrapper);
    }

    @Override
    public usr getUserByRemarkId(int id) {
        remark remark1 = remarkMapper.selectById(id);
        String userid = remark1.getUserid();
        QueryWrapper<usr> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",userid);
        usr usr1 = usrMapper.selectOne(queryWrapper);
        //计算笔记数
        QueryWrapper<note> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("id",userid);
        long noteNum = noteMapper.selectCount(queryWrapper1);
        usr1.setNotenum(noteNum);
        return usr1;
    }




}
