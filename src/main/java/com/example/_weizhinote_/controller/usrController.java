package com.example._weizhinote_.controller;

import com.example._weizhinote_.entity.usr;
import com.example._weizhinote_.service.impl.usrServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usr")
public class usrController {
    @Autowired
    private usrServiceImpl usrService;

    @GetMapping("/loginById/{id}")
    public usr getUsr(@PathVariable String id){
        return usrService.getUsrById(id);
    }

    @PostMapping("/register")
    public void register(@RequestBody usr usr){
        usrService.register(usr);
    }

    @GetMapping("/userlogin")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password){
        return usrService.login(username, password);
    }

    @PutMapping("/update")
    public void update(@RequestBody usr usr){
        System.out.println("updateController");
        usrService.update(usr);
    }
}
