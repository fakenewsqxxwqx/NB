package com.example._weizhinote_.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class weatherShow {
    //发出http请求，获取天气信息
    public static weather getWeather(String city) throws Exception {

        String cityEncoded = URLEncoder.encode(city, "UTF-8");
        String url = "https://www.mxnzp.com/api/weather/current/" + cityEncoded + "?app_id=mijooythgnsjqrkk&app_secret=N09GN2x2d255dmpHVmduWFBnUXcxdz09";

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

        ObjectMapper objectMapper = new ObjectMapper();
        MyResponse2 myResponse2 = objectMapper.readValue(response.toString(), MyResponse2.class);

        weather weather = new weather();
        weather.setAddress(myResponse2.getData().getAddress());
        weather.setCityCode(myResponse2.getData().getCityCode());
        weather.setTemp(myResponse2.getData().getTemp());
        weather.setWeather(myResponse2.getData().getWeather());
        weather.setWindDirection(myResponse2.getData().getWindDirection());
        weather.setWindPower(myResponse2.getData().getWindPower());
        weather.setHumidity(myResponse2.getData().getHumidity());
        weather.setReportTime(myResponse2.getData().getReportTime());

        System.out.println(weather.toString());

        return weather;

    }

    static class MyResponse2 {
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
            private String address;
            private String cityCode;
            private String temp;
            private String weather;

            private String windDirection;
            private String windPower;
            private String humidity;
            private String reportTime;

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }
            public String getCityCode() {
                return cityCode;
            }

            public void setCityCode(String cityCode) {
                this.cityCode = cityCode;
            }

            public String getTemp() {
                return temp;
            }

            public void setTemp(String temp) {
                this.temp = temp;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public String getWindDirection() {
                return windDirection;
            }

            public void setWindDirection(String windDirection) {
                this.windDirection = windDirection;
            }

            public String getWindPower() {
                return windPower;
            }

            public void setWindPower(String windPower) {
                this.windPower = windPower;
            }

            public String getHumidity() {
                return humidity;
            }

            public void setHumidity(String humidity) {
                this.humidity = humidity;
            }

            public String getReportTime() {
                return reportTime;
            }

            public void setReportTime(String reportTime) {
                this.reportTime = reportTime;
            }


        }

    }
}
