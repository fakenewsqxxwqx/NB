package com.example._weizhinote_.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example._weizhinote_.entity.layercontent;
import com.example._weizhinote_.entity.note;
import com.example._weizhinote_.entity.searchHistory;
import com.example._weizhinote_.entity.tag;
import com.example._weizhinote_.mapper.searchHistoryMapper;
import com.example._weizhinote_.service.searchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import com.example._weizhinote_.mapper.tagMapper;
import com.example._weizhinote_.utils.currentTime;
import com.example._weizhinote_.mapper.noteMapper;
import com.example._weizhinote_.mapper.layercontentMapper;
@Service
public class searchServiceImpl implements searchService {

    @Autowired
    private tagMapper tagMapper;

    @Autowired
    private noteMapper noteMapper;

    @Autowired
    private searchHistoryMapper searchHistoryMapper;

    @Autowired
    private layercontentMapper layercontentMapper;

    @Override
    public List<Integer> searchByTag(String tagname,int userId) {
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

    //根据标题模糊查询
    public List<Integer> searchByTitle(String keyword,int userId) {
        QueryWrapper<note> wrapper= new QueryWrapper<>();
        wrapper.like("notetitle", keyword);
        List<note> noteList=noteMapper.selectList(wrapper);
        List<Integer> noteIdList=noteList.stream().map(note::getId).toList();
        return noteIdList;
    }

    //根据内容模糊查询
    public List<Integer> searchByContent(String keyword,int userId) {
        QueryWrapper<layercontent> wrapper= new QueryWrapper<>();
        wrapper.like("content", keyword);
        List<layercontent> contentList=layercontentMapper.selectList(wrapper);
        List<Integer> noteIdList=contentList.stream().map(layercontent::getNoteid).distinct().toList();
        return noteIdList;
    }


    @Override
    public List<Integer> searchByKeyWord(String keyword, int userId) {
        //存浏览纪录
        searchHistory searchhistory = new searchHistory();
        searchhistory.setId(null);
        searchhistory.setKeyword(keyword);
        searchhistory.setUrl("/search/searchByKeyWord/" + keyword);
        searchhistory.setUserid(userId);
        searchhistory.setTime(currentTime.getCurrentTime());
        searchHistoryMapper.insert(searchhistory);

        List<Integer> noteIdList1 = searchByTitle(keyword, userId);
        List<Integer> noteIdList2 = searchByContent(keyword, userId);

        //合并相同笔记id
        if (noteIdList1.size() == 0) {
            noteIdList1 = new ArrayList<>(noteIdList2);
        } else {
            List<Integer> tempList = new ArrayList<>(noteIdList1); // 创建一个临时列表
            for (int i = 0; i < noteIdList2.size(); i++) {
                if (!tempList.contains(noteIdList2.get(i))) {
                    tempList.add(noteIdList2.get(i));
                }
            }
            noteIdList1 = tempList; // 将修改后的列表赋值回noteIdList1
        }
        return noteIdList1;

    }


}
