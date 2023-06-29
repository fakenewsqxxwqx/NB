package com.example._weizhinote_.controller;


import com.example._weizhinote_.entity.searchHistory;
import com.example._weizhinote_.service.searchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example._weizhinote_.service.searchService;
import java.util.List;

@RestController
@RequestMapping("/search")
public class searchController {
    @Autowired
    private searchHistoryService searchHistoryService;
    @Autowired
    private searchService searchService;

    @GetMapping("/getSearchHistoryByUserId/{id}")
    public List<searchHistory> getSearchHistoryByUserId(@PathVariable("id") String id) {
        return searchHistoryService.getSearchHistoryByUserId(id);
    }

    @DeleteMapping("/deleteSearchHistoryById/{id}")
    public void deleteSearchHistoryById(@PathVariable("id") int id) {
        searchHistoryService.deleteSearchHistoryById(id);
    }


    @GetMapping("/searchByTag/{userId}/{tagname}")
    public List<Integer> searchByTag(@PathVariable String tagname,@PathVariable String userId){
        return searchService.searchByTag(tagname,userId);
    }

    @GetMapping("/searchByKeyWord/{userId}/{keyword}")
    public List<Integer> searchByKeyWord(@PathVariable String keyword,@PathVariable String userId){
        return searchService.searchByKeyWord(keyword,userId);
    }
}
