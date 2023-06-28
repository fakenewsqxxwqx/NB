package com.example._weizhinote_.service;

import com.example._weizhinote_.entity.note;
import com.example._weizhinote_.entity.star;

import java.util.List;

public interface starService {
    boolean isStar(star star1);

    void addStar(star star1);

    void deleteStar(star star1);

    //收藏功能集成
    void star(star star1);

    //收藏数
    long starNum(int noteId);

    //用户收藏列表
    List<note> getStarList(String userId);

    //用户收藏列表
}
