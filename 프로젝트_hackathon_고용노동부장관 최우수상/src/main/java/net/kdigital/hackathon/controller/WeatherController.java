package net.kdigital.hackathon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import net.kdigital.hackathon.service.WeatherService;

@Controller
@RequestMapping("/weather")
@Slf4j
public class WeatherController {
	@Autowired
	WeatherService weatherService;
	
	
	@GetMapping("/weather")
	public String weather() {
		return "/weather/weather";
	}
}
