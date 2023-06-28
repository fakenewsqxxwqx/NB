package com.example._weizhinote_.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example._weizhinote_.entity.favor;
import com.example._weizhinote_.service.favorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example._weizhinote_.mapper.favorMapper;

@Service
public class favorServiceImpl implements favorService {
    @Autowired
    private favorMapper favorMapper;

    @Override
    public boolean isFavor(favor favor1)
    {
        QueryWrapper<favor> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",favor1.getId());
        favor favor2 = favorMapper.selectOne(queryWrapper);
        if(favor2!=null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public void addFavor(favor favor1)
    {
       favor1.setId(null);
       favorMapper.insert(favor1);
    }

    @Override
    public void deleteFavor(favor favor1)
    {
        QueryWrapper<favor> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",favor1.getId());
        favor favor2 = favorMapper.selectOne(queryWrapper);
        if(favor2!=null)
        {
            favorMapper.delete(queryWrapper);
        }
    }

    //收藏功能集成
    @Override
    public void favor(favor favor1)
    {
        if(isFavor(favor1))
        {
            deleteFavor(favor1);
        }
        else
        {
            addFavor(favor1);
        }
    }

    //笔记点赞数
    @Override
    public long favorNum(int NoteId)
    {
        QueryWrapper<favor> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("noteId",NoteId);
        return favorMapper.selectCount(queryWrapper);
    }
}
