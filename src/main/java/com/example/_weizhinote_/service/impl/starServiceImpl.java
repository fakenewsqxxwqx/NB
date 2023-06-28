package com.example._weizhinote_.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example._weizhinote_.entity.star;
import com.example._weizhinote_.service.starService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example._weizhinote_.mapper.starMapper;

@Service
public class starServiceImpl implements starService {
    @Autowired
    private starMapper starMapper;

    @Override
    public boolean isStar(star star1)
    {
        QueryWrapper<star> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",star1.getId());
        star star2 = starMapper.selectOne(queryWrapper);
        if(star2!=null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public void addStar(star star1)
    {
       star1.setId(null);
       starMapper.insert(star1);
    }

    @Override
    public void deleteStar(star star1)
    {
        QueryWrapper<star> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",star1.getId());
        star star2 = starMapper.selectOne(queryWrapper);
        if(star2!=null)
        {
            starMapper.delete(queryWrapper);
        }
    }

    //收藏功能集成
    @Override
    public void star(star star1)
    {
        if(isStar(star1))
        {
            deleteStar(star1);
        }
        else
        {
            addStar(star1);
        }
    }
}
