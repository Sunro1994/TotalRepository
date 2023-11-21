package com.TravelMaker.repository.lodge;

import java.util.HashMap;
import java.util.List;

import com.TravelMaker.model.LodgeDTO;
import com.TravelMaker.model.Lodge_Room_TypeDTO;

public interface LodgeDAO {

	List<LodgeDTO> selectedList(HashMap<String, Object> map);

	List<LodgeDTO> randomList();

	List<Lodge_Room_TypeDTO> getRoomList(int idx);

	Lodge_Room_TypeDTO getOneRoom(int idx);
	
	
}
