package com.example._weizhinote_.service;

import com.example._weizhinote_.entity.star;

public interface starService {
    boolean isStar(star star1);

    void addStar(star star1);

    void deleteStar(star star1);

    //收藏功能集成
    void star(star star1);
}
