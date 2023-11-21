package com.TravelMaker.repository.lodge;

import java.util.HashMap;
import java.util.List;

import com.TravelMaker.model.LodgeDTO;

public interface LodgeDAO {

	List<LodgeDTO> selectedList(HashMap<String, Object> map);

	List<LodgeDTO> randomList();
	
	
}
