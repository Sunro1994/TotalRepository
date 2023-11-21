package com.itbank.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.itbank.service.TravelService;

@Controller

public class HomeController {
	
	@Autowired private TravelService travelService;
	
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	

}
