package com.monster.luvCocktail.domain.weather.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.monster.luvCocktail.domain.weather.service.WeatherService;

import java.util.Map;


	@RestController
	public class WeatherController {
	    @Autowired
	    private WeatherService weatherService;

	    @GetMapping("/weather")
	    public Map<String, Object> getWeather(@RequestParam double lat, @RequestParam double lon) {
	        return weatherService.getWeather(lat, lon);
	    }
	}