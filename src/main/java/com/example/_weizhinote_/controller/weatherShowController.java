package com.example._weizhinote_.controller;

import com.example._weizhinote_.utils.weather;
import com.example._weizhinote_.utils.weatherShow;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class weatherShowController {

    @RequestMapping("/getWeather/{city}")
    public weather getWeather(@PathVariable String city) throws Exception {
        return weatherShow.getWeather(city);
    }
}
