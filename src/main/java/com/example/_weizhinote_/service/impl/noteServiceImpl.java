package com.example._weizhinote_.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example._weizhinote_.entity.*;
import com.example._weizhinote_.service.noteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example._weizhinote_.mapper.noteMapper;
import com.example._weizhinote_.mapper.layercontentMapper;
import com.example._weizhinote_.mapper.tagMapper;
import com.example._weizhinote_.mapper.pictureMapper;
import com.example._weizhinote_.mapper.usrMapper;

import java.util.List;

@Service
public class noteServiceImpl implements noteService {
    @Autowired
    private noteMapper noteMapper;
    @Autowired
    private layercontentMapper layercontentMapper;
    @Autowired
    private tagMapper tagMapper;
    @Autowired
    private pictureMapper pictureMapper;
    @Autowired
    private usrMapper usrMapper;

    /*
    用户笔记界面管理笔记
     */
    @Override
    //添加笔记
    public void addNote(note note1,List<tag> list1,List<picture> list2,List<layercontent> list3)
    {
        note1.setId(null);
        noteMapper.insert(note1);
        for (tag tag1:list1)
        {
            tag1.setId(null);
            tagMapper.insert(tag1);
        }
        for (picture picture1:list2)
        {
            picture1.setId(null);
            pictureMapper.insert(picture1);
        }
        for (layercontent layercontent1:list3)
        {
            layercontent1.setId(null);
            layercontentMapper.insert(layercontent1);
        }

    }

    //修改笔记
    @Override
    public void updateNoteById(note note1,List<tag> list1,List<picture> list2,List<layercontent> list3)
    {
        QueryWrapper<note> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",note1.getId());
        note note2 = noteMapper.selectOne(queryWrapper);
        if(note2!=null)
        {
            noteMapper.updateById(note1);
            for (tag tag1:list1)
            {
                tagMapper.updateById(tag1);
            }
            for (picture picture1:list2)
            {
                pictureMapper.updateById(picture1);
            }
            for (layercontent layercontent1:list3)
            {
                layercontentMapper.updateById(layercontent1);
            }
        }
    }

    /*
    用户笔记界面获取各种信息
     */
    @Override
    public List<note> getNoteByUserId(String userId) {
        QueryWrapper<note> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userid",userId);
        return noteMapper.selectList(queryWrapper);
    }

    @Override
    public List<tag> getTagByNoteId(String noteId) {
        QueryWrapper<tag> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("noteid",noteId);
        return tagMapper.selectList(queryWrapper);
    }

    @Override
    public List<picture> getPictureByNoteId(String noteId) {
        QueryWrapper<picture> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("noteid",noteId);
        return pictureMapper.selectList(queryWrapper);
    }

    @Override
    public List<layercontent> getLayercontentByNoteId(String noteId) {
        QueryWrapper<layercontent> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("noteid",noteId);
        return layercontentMapper.selectList(queryWrapper);
    }

    @Override
    public usr getUsrByUserId(String userId) {
        QueryWrapper<usr> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",userId);
        return usrMapper.selectOne(queryWrapper);
    }

}
