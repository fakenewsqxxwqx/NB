package com.example._weizhinote_.service;

import com.example._weizhinote_.entity.*;

import java.util.List;

public interface noteService {
    /*
    用户笔记界面管理笔记
     */
    void addNote(note note1);

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
    List<note> getNoteByUserId(String userId);

    List<tag> getTagByNoteId(String noteId);

    List<picture> getPictureByNoteId(String noteId);

    List<layercontent> getLayercontentByNoteId(String noteId);

    usr getUsrByUserId(String userId);

    //删除功能
    void deleteNoteById(String noteId);

    void deleteTagById(String tagId);

    void deletePictureById(String pictureId);

    void deleteLayercontentById(String layercontentId);
}
