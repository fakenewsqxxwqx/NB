package com.example._weizhinote_.controller;

import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class verifyCodeController {

    //生成验证码
    @GetMapping("/kaptcha")
    public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/gif");

        //生成验证码对象,三个参数分别是宽、高、位数
        SpecCaptcha captcha = new SpecCaptcha(130, 48, 5);
        //设置验证码的字符类型为数字和字母混合
        captcha.setCharType(Captcha.TYPE_DEFAULT);
        // 设置内置字体
        captcha.setCharType(Captcha.FONT_1);
        //验证码存入session
        httpServletRequest.getSession().setAttribute("verifyCode", captcha.text().toLowerCase());
        //输出图片流
        captcha.out(httpServletResponse.getOutputStream());
    }

    //校验验证码
    @GetMapping("/verify")
    public String verify(@RequestParam("code") String code, HttpSession session){
        if (!StringUtils.hasLength(code)){
            return "验证码不能为空";
        }
        String kaptchaCode = session.getAttribute("verifyCode")+"";
        if (!StringUtils.hasLength(kaptchaCode)||!code.toLowerCase().equals(kaptchaCode)){
            return "验证码错误";
        }
        return "验证成功";
    }

}