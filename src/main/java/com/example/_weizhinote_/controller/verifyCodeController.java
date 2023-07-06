package com.example._weizhinote_.controller;

import com.example._weizhinote_.utils.verifyCode;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/verifyCode")
public class verifyCodeController {

    //生成验证码
    @GetMapping("/getVerifyCode")
    public void getVerifyCode(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception{
        verifyCode.generateVerifyCode(httpServletRequest, httpServletResponse);
    }

    //校验验证码
    @GetMapping("/verify")
    public String verify(@RequestBody Map<String, String> requestBody, HttpSession session){
        return verifyCode.verify(requestBody, session);
    }
}
