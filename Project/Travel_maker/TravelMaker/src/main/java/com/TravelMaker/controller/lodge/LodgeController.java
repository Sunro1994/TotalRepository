package com.TravelMaker.controller.lodge;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lodge")
public class LodgeController {
	
	@GetMapping("/lodge_main")
	public String lodge() {
		return "/Lodge/lodge";
	}
	
	
}
