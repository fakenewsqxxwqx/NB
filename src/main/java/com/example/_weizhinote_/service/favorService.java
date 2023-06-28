package com.example._weizhinote_.service;

import com.example._weizhinote_.entity.favor;

public interface favorService {
    boolean isFavor(favor favor1);

    void addFavor(favor favor1);

    void deleteFavor(favor favor1);

    //收藏功能集成
    void favor(favor favor1);

    //笔记点赞数
    long favorNum(int NoteId);
}
