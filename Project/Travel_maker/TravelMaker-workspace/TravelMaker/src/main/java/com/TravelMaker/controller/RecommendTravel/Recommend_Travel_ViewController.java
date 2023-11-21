package com.TravelMaker.controller.RecommendTravel;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.TravelMaker.model.Recommend_TravelDTO;
import com.TravelMaker.service.recommendTravel.Recommend_Travel_ViewService;

@Controller
public class Recommend_Travel_ViewController {
	
	@Autowired private Recommend_Travel_ViewService travelService;
	
	
	/* 여행 추천 페이지 세부 내용으로 이동 */
	@GetMapping("/Travel_Recommend_View/{idx}")
	public ModelAndView view (@PathVariable("idx") int idx){
		ModelAndView mav = new ModelAndView("/recommend_travel/recommend_travel_view");

		Recommend_TravelDTO dto = travelService.selectOneByIdx(idx);
		mav.addObject("dto", dto);
		return mav;

	}

}
