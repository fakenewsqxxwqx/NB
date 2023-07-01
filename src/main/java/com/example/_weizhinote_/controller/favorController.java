package com.example._weizhinote_.controller;

import com.example._weizhinote_.entity.favor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example._weizhinote_.service.favorService;

@RestController
@RequestMapping("/favor")
public class favorController {
    @Autowired
    private favorService favorService;

    //点赞功能（自动判断是否点赞）
    @PutMapping("/favorControl")//update
    public void favorControl(@RequestBody favor favor1)
    {
        favorService.favor(favor1);
    }

    //获取点赞数
    @GetMapping("/favorNum/{id}")
    public long getFavorNum(@PathVariable int id){
        return favorService.favorNum(id);
    }
}
