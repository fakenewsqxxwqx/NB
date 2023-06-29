package com.example._weizhinote_.controller;

import com.example._weizhinote_.entity.usr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example._weizhinote_.entity.remark;
import com.example._weizhinote_.service.remarkService;

import java.util.List;

@RestController
@RequestMapping("/remark")
public class remarkController {

    @Autowired
    private remarkService remarkService;

    @PostMapping ("/addRemark")
    public void addRemark(@RequestBody remark remark1)
    {
        remarkService.addRemark(remark1);
    }

    //flag=1表示点赞，flag=0表示取消点赞
    @PutMapping ("/updateRemark/{id}/{flag}")
    public void likeRemark(@PathVariable int flag,@PathVariable int id)
    {
        remarkService.updateRemark(id,flag);
    }

    @GetMapping("/getRemarkByNoteId/{id}")
    public List<remark> getRemarkByNoteId(@PathVariable int id){
        return remarkService.getRemarkByNoteId(id);
    }

    @GetMapping("/getUserByRemarkId/{id}")
    public usr getUserByRemarkId(@PathVariable int id){
        return remarkService.getUserByRemarkId(id);
    }

}
