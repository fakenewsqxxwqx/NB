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

    @PostMapping("/addFavor")
    public void addFavor(@RequestBody favor favor1)
    {
        favorService.addFavor(favor1);
    }

    @PutMapping("/favorControl")//update
    public void favorControl(@RequestBody favor favor1)
    {
        favorService.favor(favor1);
    }

    @GetMapping("/favorNum/{id}")
    public long getFavorNum(@PathVariable int id){
        return favorService.favorNum(id);
    }
}
