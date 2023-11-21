package com.TravelMaker.service.recommendTravel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TravelMaker.model.Recommend_TravelDTO;
import com.TravelMaker.model.TravelMaker_MemberDTO;
import com.TravelMaker.repository.recommendTravel.Recommend_TravelDAO;



@Service
public class Recommend_TravelService {

	@Autowired private Recommend_TravelDAO recommend_travelDAO;

	public List<Recommend_TravelDTO> selectRandom(String value) {
		List<Recommend_TravelDTO> dto = recommend_travelDAO.selectRandom(value);
		return dto;
	}

	public List<Recommend_TravelDTO> selectAll() {
		List<Recommend_TravelDTO> list = recommend_travelDAO.selectAll();
		return list;
	}

	public Recommend_TravelDTO getRecommend(int idx) {
		return recommend_travelDAO.getRecommend(idx);
	}

	
}
