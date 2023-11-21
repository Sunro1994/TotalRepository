package com.TravelMaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InterceptorController {

	@GetMapping("/WelcomeLogin")
	public String Login(){
		return "Welcome-Login";
	}
}
