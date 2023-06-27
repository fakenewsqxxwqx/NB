package com.example._weizhinote_.service;

import com.example._weizhinote_.entity.*;

import java.util.List;

public interface noteService {
    /*
    用户笔记界面管理笔记
     */
    void addNote(note note1, List<tag> list1, List<picture> list2, List<layercontent> list3);

    //修改笔记
    void updateNoteById(note note1, List<tag> list1, List<picture> list2, List<layercontent> list3);

    List<note> getNoteByUserId(String userId);

    List<tag> getTagByNoteId(String noteId);

    List<picture> getPictureByNoteId(String noteId);

    List<layercontent> getLayercontentByNoteId(String noteId);

    usr getUsrByUserId(String userId);
}
