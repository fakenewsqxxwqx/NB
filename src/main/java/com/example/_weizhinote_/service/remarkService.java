package com.example._weizhinote_.service;

import com.example._weizhinote_.entity.remark;
import com.example._weizhinote_.entity.usr;

import java.util.List;

public interface remarkService {
    
    void addRemark(com.example._weizhinote_.entity.remark remark1);

    void updateRemark(int id, int flag);

    List<remark> getRemarkByNoteId(int id);

    usr getUserByRemarkId(int id);
}
