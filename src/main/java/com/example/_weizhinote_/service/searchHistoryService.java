package com.example._weizhinote_.service;

import com.example._weizhinote_.entity.searchHistory;

import java.util.List;

public interface searchHistoryService {
    List<searchHistory> getSearchHistoryByUserId(int userId);

    void deleteSearchHistoryById(int id);
}
