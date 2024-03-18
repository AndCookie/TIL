package net.kdigital.spring7.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import net.kdigital.spring7.domain.Iris;
import net.kdigital.spring7.service.PredictService;

@Controller
@Slf4j
public class PredictController {
	
	@Autowired
	PredictService service;
	

	@GetMapping("/predict")
	public String predict() {
		return "/predict";
	}
	
	@PostMapping("/predict")
	@ResponseBody
	public Map<String, Object> predict(Iris iris) {
		log.info("{}", iris.toString());
		Map<String, Object> result = service.predict(iris);
		return result;
	}
}
