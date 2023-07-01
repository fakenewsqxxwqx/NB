package com.example._weizhinote_.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example._weizhinote_.entity.searchHistory;
import com.example._weizhinote_.service.searchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example._weizhinote_.mapper.searchHistoryMapper;

import java.util.List;

@Service
public class searchHistoryServiceImpl implements searchHistoryService {
    @Autowired
    private searchHistoryMapper searchHistoryMapper;

    @Override
    public List<searchHistory> getSearchHistoryByUserId(int userId) {
        QueryWrapper<searchHistory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userid", userId);
        return searchHistoryMapper.selectList(queryWrapper);
    }

    @Override
    public void deleteSearchHistoryById(int id) {
        QueryWrapper<searchHistory> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        searchHistoryMapper.delete(queryWrapper);
    }


}
