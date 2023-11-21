package com.TravelMaker.controller.promotion;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/travel_promotion")
public class PromotionController {

	/* 프로모션페이지로 이동 */
	@GetMapping("/travel_promotion_main")
	public String promotion() {
		return "Promotion/travel_promotion_main";
	}

	
}
