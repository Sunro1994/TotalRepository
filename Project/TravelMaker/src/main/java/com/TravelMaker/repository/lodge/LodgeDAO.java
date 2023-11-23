package com.TravelMaker.repository.lodge;

import java.util.HashMap;
import java.util.List;

import com.TravelMaker.model.LodgeDTO;
import com.TravelMaker.model.Lodge_ReviewDTO;
import com.TravelMaker.model.Lodge_Room_TypeDTO;
import com.TravelMaker.model.Reserved_Lodge_Current_StateDTO;
import com.TravelMaker.model.SaveListDTO;

public interface LodgeDAO {

	List<LodgeDTO> selectedList(HashMap<String, Object> map);

	List<LodgeDTO> randomList();

	List<Lodge_Room_TypeDTO> getRoomList(int idx);

	Lodge_Room_TypeDTO getOneRoom(int idx);

	int insertReserved(Reserved_Lodge_Current_StateDTO reservedDTO);

	LodgeDTO getLodge(int idx);

	List<Lodge_Room_TypeDTO> selectedRoomList(Lodge_Room_TypeDTO roomFilter);

	List<LodgeDTO> selectKeywordList(String keyword);

	Lodge_Room_TypeDTO roomSelctOne(int idx);

	Lodge_ReviewDTO reviewSelectOne(int idx);

	List<Lodge_ReviewDTO> ReviewList(int lodge_idx);

	int insertReview(Lodge_ReviewDTO dto);

	List<LodgeDTO>  selectSaveList(SaveListDTO save);

	int saveInsert(SaveListDTO save);

	int getCount(Lodge_Room_TypeDTO roomFilter);

	List<SaveListDTO> selectDuplicationList(SaveListDTO save1);

	int deleteFavorite(int lodge_idx);
	
}