package com.example._weizhinote_.controller;


import com.example._weizhinote_.utils.verity;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/verityCode")
public class verityCodeController {

    @GetMapping("/getVerityCodeImg")
    public String getVerityCodeImg( HttpSession session) throws Exception {
        return verity.verfityCodeImg(session);
    }

    @PostMapping("/checkVerityCode")
    public boolean verityCode(@RequestBody Map<String, String> requestBody, HttpSession session) throws Exception {
        String code=requestBody.get("code");

        boolean result=verity.verfityCode(code, session);
        return result;
    }

}
