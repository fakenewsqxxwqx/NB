package com.example._weizhinote_.controller;

import com.example._weizhinote_.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example._weizhinote_.service.noteService;

import java.util.List;

@RestController
@RequestMapping("/note")
public class noteController {
    @Autowired
    private noteService noteService;
    @GetMapping("/getNoteByUserId/{id}")
    public List<note> getNoteByUserId(@PathVariable String id){
        return noteService.getNoteByUserId(id);
    }

    @GetMapping("/getTagByNoteId/{id}")
    public List<tag> getTagByNoteId(@PathVariable String id){
        return noteService.getTagByNoteId(id);
    }

    @GetMapping("/getPictureByNoteId/{id}")
    public List<picture> getPictureByNoteId(@PathVariable String id){
        return noteService.getPictureByNoteId(id);
    }

    @GetMapping("/getLayercontentByNoteId/{id}")
    public List<layercontent> getLayercontentByNoteId(@PathVariable String id){
        return noteService.getLayercontentByNoteId(id);
    }

    @GetMapping("/getUsrByUserId/{id}")
    public usr getUsrByUserId(@PathVariable String id){
        return noteService.getUsrByUserId(id);
    }

    //前端需要将id设置为NULL
    @PostMapping("/addNoteById")
    public void addNoteById(@RequestParam note note1,@RequestParam List<tag> list1,@RequestParam List<picture> list2,@RequestParam List<layercontent> list3){
        noteService.addNote(note1,list1,list2,list3);
    }

    @PutMapping("/updateNoteById")
    public void updateNoteById(@RequestParam note note1,@RequestParam List<tag> list1,@RequestParam List<picture> list2,@RequestParam List<layercontent> list3){
        noteService.updateNoteById(note1,list1,list2,list3);
    }
}
