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
import com.example._weizhinote_.mapper.favorMapper;
import java.util.ArrayList;
import java.util.List;
import com.example._weizhinote_.mapper.remarkMapper;
import com.example._weizhinote_.mapper.starMapper;
import com.example._weizhinote_.utils.currentTime;
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
    @Autowired
    private favorMapper favorMapper;
    @Autowired
    private remarkMapper remarkMapper;
    @Autowired
    private starMapper starMapper;
    /*
    用户笔记界面管理笔记
     */

    @Override
    public void addNote(note note1){
        note1.setId(null);
        note1.setTime(currentTime.getCurrentTime());
        noteMapper.insert(note1);
    }

    @Override
    public void addTag(List<tag> list1){
        for (tag tag1:list1)
        {
            tag1.setId(null);
            tag1.setTime(currentTime.getCurrentTime());
            tagMapper.insert(tag1);
        }
    }

    @Override
    public void addPicture(List<picture> list2){
        for (picture picture1:list2)
        {
            picture1.setId(null);
            picture1.setTime(currentTime.getCurrentTime());
            pictureMapper.insert(picture1);
        }
    }

    @Override
    public void addLayercontent(List<layercontent> list3){
        for (layercontent layercontent1:list3)
        {
            layercontent1.setId(null);
            layercontent1.setTime(currentTime.getCurrentTime());
            layercontentMapper.insert(layercontent1);
        }
    }
    //修改笔记
    @Override
    public void updateNote(note note1){
        QueryWrapper<note> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",note1.getId());
        note note2 = noteMapper.selectOne(queryWrapper);
        if(note2!=null)
        {
            note2.setTime(currentTime.getCurrentTime());
            noteMapper.updateById(note1);
        }
    }

    @Override
    public void updateTag(List<tag> list1)
    {
        for(tag tag1:list1)
        {
            QueryWrapper<tag> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id",tag1.getId());
            tag tag2 = tagMapper.selectOne(queryWrapper);
            if(tag2!=null)
            {
                tag2.setTime(currentTime.getCurrentTime());
                tagMapper.updateById(tag1);
            }
        }
    }

    @Override
    public void updatePicture(List<picture> list2)
    {
        for(picture picture1:list2)
        {
            QueryWrapper<picture> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id",picture1.getId());
            picture picture2 = pictureMapper.selectOne(queryWrapper);
            if(picture2!=null)
            {
                picture2.setTime(currentTime.getCurrentTime());
                pictureMapper.updateById(picture1);
            }
        }
    }

    @Override
    public void updateLayercontent(List<layercontent> list3)
    {
        for(layercontent layercontent1:list3)
        {
            QueryWrapper<layercontent> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id",layercontent1.getId());
            layercontent layercontent2 = layercontentMapper.selectOne(queryWrapper);
            if(layercontent2!=null)
            {
                layercontent2.setTime(currentTime.getCurrentTime());
                layercontentMapper.updateById(layercontent1);
            }
        }
    }

    /*
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
     */

    /*
    用户笔记界面获取各种信息
     */
    @Override
    public List<note> getNoteByUserId(int userId) {
        QueryWrapper<note> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userid",userId);
        return noteMapper.selectList(queryWrapper);
    }

    @Override
    public List<tag> getTagByNoteId(int noteId) {
        QueryWrapper<tag> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("noteid",noteId);
        return tagMapper.selectList(queryWrapper);
    }

    @Override
    public List<picture> getPictureByNoteId(int noteId) {
        QueryWrapper<picture> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("noteid",noteId);
        return pictureMapper.selectList(queryWrapper);
    }

    @Override
    public List<layercontent> getLayercontentByNoteId(int noteId) {
        QueryWrapper<layercontent> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("noteid",noteId);
        return layercontentMapper.selectList(queryWrapper);
    }

    @Override
    public usr getUsrByUserId(int userId) {
        QueryWrapper<usr> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",userId);
        return usrMapper.selectOne(queryWrapper);
    }

    //删除功能
    @Override
    public void deleteNoteById(int noteId)
    {
        QueryWrapper<note> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",noteId);
        //删除tag
        QueryWrapper<tag> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.eq("noteid",noteId);
        tagMapper.delete(queryWrapper1);

        //删除picture
        QueryWrapper<picture> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.eq("noteid",noteId);
        pictureMapper.delete(queryWrapper2);

        //删除layercontent
        QueryWrapper<layercontent> queryWrapper3 = new QueryWrapper<>();
        queryWrapper3.eq("noteid",noteId);
        layercontentMapper.delete(queryWrapper3);

        //删除note
        noteMapper.delete(queryWrapper);
    }

    @Override
    public void deleteTagById(int tagId)
    {
        QueryWrapper<tag> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",tagId);
        tagMapper.delete(queryWrapper);
    }

    @Override
    public void deletePictureById(int pictureId)
    {
        QueryWrapper<picture> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",pictureId);
        pictureMapper.delete(queryWrapper);
    }

    @Override
    public void deleteLayercontentById(int layercontentId)
    {
        QueryWrapper<layercontent> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",layercontentId);
        layercontentMapper.delete(queryWrapper);
    }

    @Override
    public List<Integer> getCommunityNoteList() {
        QueryWrapper<note> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("permission",1);
        List<note> list = noteMapper.selectList(queryWrapper);
        List<Integer> list1 = new ArrayList<>();
        for(note note1:list)
        {
            list1.add(note1.getId());
        }
        return list1;
    }

    @Override
    public note getCommunityNote(int id) {
        QueryWrapper<note> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        note note1 = noteMapper.selectOne(queryWrapper);
        return note1;
    }

    @Override
    public List<Integer> getNoteIdByUserId(int id) {
        QueryWrapper<note> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userid",id);
        List<note> list = noteMapper.selectList(queryWrapper);
        List<Integer> list1 = new ArrayList<>();
        for(note note1:list)
        {
            list1.add(note1.getId());
        }
        return list1;
    }



}
