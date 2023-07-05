package com.example._weizhinote_.service;

import com.example._weizhinote_.entity.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface noteService {
    /*
    用户笔记界面管理笔记
     */
    int addNote(note note1);

    void addTag(List<tag> list1);

    void addPicture(List<picture> list2);

    void addLayercontent(List<layercontent> list3);


    //修改笔记


    //修改笔记
    void updateNote(note note1);

    void updateTag(List<tag> list1);

    void updatePicture(List<picture> list2);

    void updateLayercontent(List<layercontent> list3);


    //read
    List<note> getNoteByUserId(int userId);

    List<tag> getTagByNoteId(int noteId);

    List<picture> getPictureByNoteId(int noteId);

    List<layercontent> getLayercontentByNoteId(int noteId);

    usr getUsrByUserId(int userId);

    //删除功能
    void deleteNoteById(int noteId);

    void deleteTagById(int tagId);

    void deletePictureById(int pictureId);

    void deleteLayercontentById(int layercontentId);

    //community
    List<Integer> getCommunityNoteList();

    //community
    note getCommunityNote(@PathVariable int id);

    List<Integer> getNoteIdByUserId(int id);
}
