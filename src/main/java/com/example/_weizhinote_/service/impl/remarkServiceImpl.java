package com.example._weizhinote_.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example._weizhinote_.entity.note;
import com.example._weizhinote_.entity.remark;
import com.example._weizhinote_.entity.remarkfavor;
import com.example._weizhinote_.entity.usr;
import com.example._weizhinote_.mapper.remarkfavorMapper;
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
    private remarkfavorMapper remarkfavorMapper;
    @Override
    public void addRemark(remark remark1) {
        remark1.setId(null);
        remark1.setTime(currentTime.getCurrentTime());
        remarkMapper.insert(remark1);
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
        int userid = remark1.getUserid();
        QueryWrapper<usr> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",userid);
        usr usr1 = usrMapper.selectOne(queryWrapper);

        return usr1;
    }

    @Override
    public long getRemarkNum(int id) {
        QueryWrapper<remark> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("noteid",id);
        return remarkMapper.selectCount(queryWrapper);
    }

    @Override
    public void updateRemarkFavor(int userid, int remarkid) {
        QueryWrapper<remarkfavor> wrapper1=new QueryWrapper<>();
        wrapper1.eq("remarkid",remarkid).eq("userid",userid);
        remarkfavor remarkfavor1=remarkfavorMapper.selectOne(wrapper1);
        if(remarkfavor1==null){
            remarkfavor remarkfavor2=new remarkfavor();
            remarkfavor2.setRemarkid(remarkid);
            remarkfavor2.setUserid(userid);
            remarkfavor2.setTime(currentTime.getCurrentTime());
            remarkfavorMapper.insert(remarkfavor2);
        }
        else{
            remarkfavorMapper.deleteById(remarkfavor1.getId());
        }
    }

    @Override
    public long getRemarkFavorNum(int id) {
        QueryWrapper<remarkfavor> wrapper1=new QueryWrapper<>();
        wrapper1.eq("remarkid",id);
        return remarkfavorMapper.selectCount(wrapper1);
    }


}
