package com.TravelMaker.service.recommendTravel;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TravelMaker.model.Recommend_TravelDTO;
import com.TravelMaker.repository.recommendTravel.Recommend_TravelDAO;


@Service
public class Recommend_Travel_ViewService {

	@Autowired private Recommend_TravelDAO recommend_travelDAO;

	


	public Recommend_TravelDTO selectOneByIdx(int idx) {
		return recommend_travelDAO.selectOneByIdx(idx);
	}
}
