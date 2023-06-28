package com.example._weizhinote_.controller;

import com.example._weizhinote_.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example._weizhinote_.service.starService;
import com.example._weizhinote_.service.noteService;
import com.example._weizhinote_.service.favorService;

import java.util.List;

@RestController
@RequestMapping("/star")
public class starController {
    @Autowired
    private starService starService;
    @Autowired
    private noteService noteService;
    @Autowired
    private favorService favorService;

    @PostMapping("/addStar")
    public void addStar(star star1)
    {
        starService.addStar(star1);
    }

    @PutMapping("/starControl")//update
    public void starControl(star star1)
    {
        starService.star(star1);
    }

    //收藏列表，需要获取笔记的整个内容以及点赞，收藏，评论数
    @GetMapping("/starList/{id}")
    public List<note> getStarList(@PathVariable String userid){
        return starService.getStarList(userid);
    }


    @GetMapping("/starList/content/{id}")
    public List<layercontent> getContent(@PathVariable int noteid){
        return noteService.getLayercontentByNoteId(noteid);
    }

    @GetMapping("/starList/tag/{id}")
    public List<tag> getTag(@PathVariable int noteid){
        return noteService.getTagByNoteId(noteid);
    }

    @GetMapping("/starList/picture/{id}")
    public List<picture> getPicture(@PathVariable int noteid){
        return noteService.getPictureByNoteId(noteid);
    }

    @GetMapping("/starList/starNum/{id}")
    public long getStarNum(@PathVariable int noteid){
        return starService.starNum(noteid);
    }

    @GetMapping("/starList/favorNum/{id}")
    public long getFavorNum(@PathVariable int noteid){
        return favorService.favorNum(noteid);
    }
}
