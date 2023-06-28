package com.example._weizhinote_.controller;

import com.example._weizhinote_.entity.note;
import com.example._weizhinote_.entity.picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example._weizhinote_.service.noteService;

import java.util.List;

@RestController
@RequestMapping("/community")
public class communityController {
    @Autowired
    private noteService noteService;



    @GetMapping("/getCommunityNoteList")
    public List<Integer> getCommunityNoteList() {
        return noteService.getCommunityNoteList();
    }

    @GetMapping("/getCommunityNote/{id}")
    public note getCommunityNote(@PathVariable int id) {
        return noteService.getCommunityNote(id);
    }

    @GetMapping("/getPictureByNoteId/{id}")
    public List<picture> getPictureByNoteId(@PathVariable int id){
        return noteService.getPictureByNoteId(id);
    }


}
