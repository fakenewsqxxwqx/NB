package com.example._weizhinote_.controller;

import com.example._weizhinote_.utils.verifyCode;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class verifyCodeController {

    //生成验证码
    @GetMapping("/kaptcha")
    public void generateVerifyCode(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        verifyCode.defaultKaptcha(httpServletRequest, httpServletResponse);
    }


    //校验验证码
    @GetMapping("/verify")
    public String verify(@RequestBody Map<String, String> requestBody, HttpSession session){
        return verifyCode.verify(requestBody, session);
    }

}
