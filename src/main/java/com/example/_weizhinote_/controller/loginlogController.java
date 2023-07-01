package com.example._weizhinote_.controller;

import com.example._weizhinote_.entity.loginlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example._weizhinote_.service.loginlogService;
import java.util.List;

@RestController
@RequestMapping("/loginlog")
public class loginlogController {

    @Autowired
    private loginlogService loginlogService;
    @GetMapping("/getLoginLog")
    public List<loginlog> getLoginLog(){
        return loginlogService.getLoginLog();
    }

    @GetMapping("/getLoginLogByUserId/{id}")
    public List<loginlog> getLoginLogByUserId(@PathVariable int id){
        return loginlogService.getLoginLogByUserId(id);
    }
}
