package com.TravelMaker.controller.RecommendTravel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TravelMaker.model.Recommend_TravelDTO;
import com.TravelMaker.service.KaKaoService;
import com.TravelMaker.service.recommendTravel.Recommend_TravelService;


@RestController
@RequestMapping("/ajax")
public class Recommend_TravelAjaxController {
	
	@Autowired private Recommend_TravelService recommend_travelService;
	@Autowired private KaKaoService kakaoService;
	
	
	/* DB에서 정보 불러오기 */
	@GetMapping("/location")
	public List<Recommend_TravelDTO> SelectRandom(String value) {
		List<Recommend_TravelDTO> list = recommend_travelService.selectRandom(value);
		if(value.equals("전국")) {
			List<Recommend_TravelDTO> listAll = recommend_travelService.selectAll();
			return listAll;
		}
		return list;
	}
	
	
}
