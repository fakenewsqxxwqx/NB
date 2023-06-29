package com.example._weizhinote_.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
public class passwordEncoder {
    public static String encode(String password){
        //密码加密
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        password = encoder.encode(password);

        return password;
    }

    public static boolean matches(String password, String encodedPassword){
        //密码匹配
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(password, encodedPassword);
    }

}
