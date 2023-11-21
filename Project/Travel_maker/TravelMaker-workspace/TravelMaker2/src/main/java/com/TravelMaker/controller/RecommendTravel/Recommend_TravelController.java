package com.TravelMaker.controller.RecommendTravel;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.TravelMaker.model.TravelMaker_MemberDTO;
import com.TravelMaker.service.member.MemberService;
import com.TravelMaker.service.recommendTravel.Recommend_TravelService;

@Controller
@RequestMapping("/recommend_travel")
public class Recommend_TravelController {
	
	
	
	/* 해당 페이지로 이동 */
	@GetMapping("/recommend_travel_main")
	public void recommend_travel_main() {
	}
	

}