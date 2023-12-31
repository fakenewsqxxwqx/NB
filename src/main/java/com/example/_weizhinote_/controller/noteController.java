package com.example._weizhinote_.controller;

import com.example._weizhinote_.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example._weizhinote_.service.noteService;
import com.example._weizhinote_.service.favorService;
import com.example._weizhinote_.service.starService;

import java.util.List;

@RestController
@RequestMapping("/note")
public class noteController {
    @Autowired
    private noteService noteService;

    //读取
    @GetMapping("/getNoteByUserId/{id}")
    public List<note> getNoteByUserId(@PathVariable int id){
        return noteService.getNoteByUserId(id);
    }

    @GetMapping("/getNoteIdByUserId/{id}")
    public List<Integer> getNoteIdByUserId(@PathVariable int id){
        return noteService.getNoteIdByUserId(id);
    }

    @GetMapping("/getTagByNoteId/{id}")
    public List<tag> getTagByNoteId(@PathVariable int id){
        return noteService.getTagByNoteId(id);
    }

    @GetMapping("/getPictureByNoteId/{id}")
    public List<picture> getPictureByNoteId(@PathVariable int id){
        return noteService.getPictureByNoteId(id);
    }

    @GetMapping("/getLayercontentByNoteId/{id}")
    public List<layercontent> getLayercontentByNoteId(@PathVariable int id){
        return noteService.getLayercontentByNoteId(id);
    }

    @GetMapping("/getUsrByUserId/{id}")
    public usr getUsrByUserId(@PathVariable int id){
        return noteService.getUsrByUserId(id);
    }

    @GetMapping("/getNoteByType/{type}")
    public List<note> getNoteByType(@PathVariable String type){
        return noteService.getNoteByType(type);
    }



 //添加
    @PostMapping("/addNote")
    public int addNote(@RequestBody note note1){
        return noteService.addNote(note1);
    }

    @PostMapping("/addTag")
    public void addTag(@RequestBody List<tag> list1){
        noteService.addTag(list1);
    }

    @PostMapping("/addPicture")
    public void addPicture(@RequestBody List<picture> list2){
        noteService.addPicture(list2);
    }

    @PostMapping("/addLayercontent")
    public void addLayercontent(@RequestBody List<layercontent> list3){
        noteService.addLayercontent(list3);
    }


    //修改
    @PutMapping("/updateNote")
    public void updateNote(@RequestBody note note1){
        noteService.updateNote(note1);
    }

    @PutMapping("/updateTag")
    public void updateTag(@RequestBody List<tag> list1){
        noteService.updateTag(list1);
    }

    @PutMapping("/updatePicture")
    public void updatePicture(@RequestBody List<picture> list2){
        noteService.updatePicture(list2);
    }

    @PutMapping("/updateLayercontent")
    public void updateLayercontent(@RequestBody List<layercontent> list3){
        noteService.updateLayercontent(list3);
    }

    //删除功能
    @DeleteMapping("/deleteNoteById/{id}")
    public void deleteNoteById(@PathVariable int id){
        noteService.deleteNoteById(id);
    }

    @DeleteMapping("/deleteTagById/{id}")
    public void deleteTagById(@PathVariable int id){
        noteService.deleteTagById(id);
    }

    @DeleteMapping("/deletePictureById/{id}")
    public void deletePictureById(@PathVariable int id){
        noteService.deletePictureById(id);
    }

    @DeleteMapping("/deleteLayercontentById/{id}")
    public void deleteLayercontentById(@PathVariable int id){
        noteService.deleteLayercontentById(id);
    }
}
