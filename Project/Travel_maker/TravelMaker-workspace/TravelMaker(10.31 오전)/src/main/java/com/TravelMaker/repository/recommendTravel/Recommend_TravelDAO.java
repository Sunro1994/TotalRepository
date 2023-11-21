package com.TravelMaker.repository.recommendTravel;

import java.util.List;

import com.TravelMaker.model.Recommend_TravelDTO;


public interface Recommend_TravelDAO {

	List<Recommend_TravelDTO> selectRandom(String value);

	List<Recommend_TravelDTO> selectAll();
	
	Recommend_TravelDTO selectOneByIdx(int idx);

}
