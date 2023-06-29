package com.example._weizhinote_.controller;

import com.example._weizhinote_.entity.searchHistory;
import com.example._weizhinote_.service.searchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/search")
public class searchController {
    @Autowired
    private searchHistoryService searchService;

    @GetMapping("/getSearchHistoryByUserId/{id}")
    public List<searchHistory> getSearchHistoryByUserId(@PathVariable("id") String id) {
        return searchService.getSearchHistoryByUserId(id);
    }

    @DeleteMapping("/deleteSearchHistoryById/{id}")
    public void deleteSearchHistoryById(@PathVariable("id") int id) {
        searchService.deleteSearchHistoryById(id);
    }
}
