package com.example._weizhinote_.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example._weizhinote_.entity.searchHistory;
import com.example._weizhinote_.entity.tag;
import com.example._weizhinote_.mapper.searchHistoryMapper;
import com.example._weizhinote_.service.searchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import com.example._weizhinote_.mapper.tagMapper;
import com.example._weizhinote_.utils.currentTime;

@Service
public class searchServiceImpl implements searchService {

    @Autowired
    private tagMapper tagMapper;

    @Autowired
    private searchHistoryMapper searchHistoryMapper;

    @Override
    public List<Integer> searchByTag(String tagname,String userId) {
        //存浏览纪录
        searchHistory searchhistory=new searchHistory();
        searchhistory.setId(null);
        searchhistory.setKeyword(tagname);
        searchhistory.setUrl("/search/searchByTag/"+tagname);
        searchhistory.setUserid(userId);

        searchhistory.setTime(currentTime.getCurrentTime());
        searchHistoryMapper.insert(searchhistory);

        //查找tag
        QueryWrapper<tag> wrapper= new QueryWrapper<>();
        wrapper.eq("tagname", tagname);
        List<tag> tagList=tagMapper.selectList(wrapper);
        //合并相同笔记id
        List<Integer> noteIdList=tagList.stream().map(tag::getNoteid).distinct().toList();


        return noteIdList;
    }
}
