package com.example._weizhinote_.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example._weizhinote_.entity.remark;
import com.example._weizhinote_.service.remarkService;
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

    @PutMapping ("/updateRemark/{id}/{flag}")
    public void likeRemark(@PathVariable int flag,@PathVariable int id)
    {
        remarkService.updateRemark(id,flag);
    }

}
