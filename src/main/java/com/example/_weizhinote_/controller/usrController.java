package com.example._weizhinote_.controller;

import com.example._weizhinote_.entity.usr;
import com.example._weizhinote_.service.usrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usr")
public class usrController {
    @Autowired
    private usrService usrService;

    @GetMapping("/getUsrById/{id}")
    public usr getUsr(@PathVariable int id){
        return usrService.getUsrById(id);
    }

    //小程序端登录
    @GetMapping("/loginByWeichatId/{weichatid}")
    public usr getUsrByWeichatId(@PathVariable String weichatid){
        return usrService.getUsrByWeichatId(weichatid);
    }

    @PostMapping("/register")
    public void register(@RequestBody usr usr){
        usrService.register(usr);
    }

    @GetMapping("/userlogin/{username}/{password}")
    public String login(@PathVariable String username, @PathVariable String password){
        return usrService.login(username, password);
    }

    @PutMapping("/update")
    public void update(@RequestBody usr usr){
        usrService.update(usr);
    }

    @PutMapping("/addVisitNum/{id}")
    public void addVisitNum(@PathVariable int id){
        usrService.addVisitNum(id);
    }
}
