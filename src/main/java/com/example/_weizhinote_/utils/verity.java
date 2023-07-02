package com.example._weizhinote_.utils;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpSession;

public class verity {

    //https://www.mxnzp.com/api/verifycode/code?len=5&type=0&app_id=mijooythgnsjqrkk&app_secret=N09GN2x2d255dmpHVmduWFBnUXcxdz09
    public static String verfityCodeImg(HttpSession session) throws IOException {
        //发出http请求
        String url = "https://www.mxnzp.com/api/verifycode/code?len=5&type=0&app_id=mijooythgnsjqrkk&app_secret=N09GN2x2d255dmpHVmduWFBnUXcxdz09";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // 解析 JSON 响应
        ObjectMapper objectMapper = new ObjectMapper();
        MyResponse myResponse = objectMapper.readValue(response.toString(), MyResponse.class);


        session.setAttribute("verifyCode", myResponse.getData().getVerifyCode());
        session.setAttribute("verifyCodeImgUrl", myResponse.getData().getVerifyCodeImgUrl());

        return myResponse.getData().getVerifyCodeImgUrl();

    }

    public static boolean verfityCode(String code, HttpSession session){
        String verifyCode = (String) session.getAttribute("verifyCode");
        if (verifyCode.equals(code)) {
            return true;
        } else {
            return false;
        }
    }

}

class MyResponse {
    private int code;
    private String msg;
    private Data data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }


    static class Data {
        private String verifyCode;
        private String verifyCodeImgUrl;
        private String verifyCodeBase64;
        private String whRatio;

        public String getVerifyCode() {
            return verifyCode;
        }

        public void setVerifyCode(String verifyCode) {
            this.verifyCode = verifyCode;
        }

        public String getVerifyCodeImgUrl() {
            return verifyCodeImgUrl;
        }

        public void setVerifyCodeImgUrl(String verifyCodeImgUrl) {
            this.verifyCodeImgUrl = verifyCodeImgUrl;
        }

        public String getVerifyCodeBase64() {
            return verifyCodeBase64;
        }

        public void setVerifyCodeBase64(String verifyCodeBase64) {
            this.verifyCodeBase64 = verifyCodeBase64;
        }

        public String getWhRatio() {
            return whRatio;
        }

        public void setWhRatio(String whRatio) {
            this.whRatio = whRatio;
        }
    }
}
