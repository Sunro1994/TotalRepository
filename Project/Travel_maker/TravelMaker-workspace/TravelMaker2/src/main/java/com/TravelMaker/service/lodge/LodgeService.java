package com.TravelMaker.service.lodge;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TravelMaker.model.LodgeDTO;
import com.TravelMaker.model.Lodge_ReviewDTO;
import com.TravelMaker.model.Lodge_Room_TypeDTO;
import com.TravelMaker.model.Reserved_Lodge_Current_StateDTO;
import com.TravelMaker.model.SaveListDTO;
import com.TravelMaker.repository.lodge.LodgeDAO;

@Service
public class LodgeService {

	@Autowired
	private LodgeDAO lodgeDAO;

	public List<LodgeDTO> selectedList(HashMap<String, Object> map) {

		return lodgeDAO.selectedList(map);
	}

	public List<LodgeDTO> randomList() {

		return lodgeDAO.randomList();
	}

	public List<Lodge_Room_TypeDTO> getRoomList(int idx) {
		return lodgeDAO.getRoomList(idx);
	}

	public Lodge_Room_TypeDTO getOneRoom(int idx) {
		return lodgeDAO.getOneRoom(idx);
	}

	public void insertReserved(Reserved_Lodge_Current_StateDTO reservedDTO) {
		lodgeDAO.insertReserved(reservedDTO);
	}

	public LodgeDTO getLodge(int idx) {
		// TODO Auto-generated method stub
		return lodgeDAO.getLodge(idx);
	}

	public List<Lodge_Room_TypeDTO> selectedRoomList(Lodge_Room_TypeDTO roomFilter) {

		String originalStartDate = roomFilter.getStartDate();
		String originalEndDate = roomFilter.getEndDate();

		try {
//			SimpleDateFormat originalDateFormat = new SimpleDateFormat("MM/dd/yyyy");
			SimpleDateFormat targetDateFormat = new SimpleDateFormat("yyyy-MM-dd");

//			Date startDate = targetDateFormat.parse(originalStartDate);
//			Date endDate = targetDateFormat.parse(originalEndDate);

//			String formattedStartDate = targetDateFormat.format(startDate);
//			String formattedEndDate = targetDateFormat.format(endDate);
//
//			System.out.println("Formatted Start Date: " + formattedStartDate);
//			System.out.println("Formatted End Date: " + formattedEndDate);

			roomFilter.setStartDate(originalStartDate);
			roomFilter.setEndDate(originalEndDate);

			// 이제 formattedStartDate와 formattedEndDate를 SQL 쿼리에 사용할 수 있습니다.
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lodgeDAO.selectedRoomList(roomFilter);
	}

	public List<LodgeDTO> selectKeyword(String keyword) {

		return lodgeDAO.selectKeywordList(keyword);
	}

	public Lodge_Room_TypeDTO selctOne(int idx) {
		return lodgeDAO.roomSelctOne(idx);
	}

	public Lodge_ReviewDTO reselectOne(int idx) {
		return lodgeDAO.reviewSelectOne(idx);
	}

	

	public List<Lodge_ReviewDTO> getReviewList(int lodge_idx) {
		return lodgeDAO.ReviewList(lodge_idx);
	}

	public int insertReview(Lodge_ReviewDTO dto) {
		return lodgeDAO.insertReview(dto);
	}

	public List<LodgeDTO> selectSaveList(SaveListDTO save) {
		// TODO Auto-generated method stub
		return lodgeDAO.selectSaveList(save);
	}

	public int saveInsert(SaveListDTO save) {
		// TODO Auto-generated method stub
		return lodgeDAO.saveInsert(save);
	}

	

	public int getCount(Lodge_Room_TypeDTO roomFilter) {
		return lodgeDAO.getCount(roomFilter);
	}

	public List<SaveListDTO> selectDuplicationList(SaveListDTO save1) {
		return lodgeDAO.selectDuplicationList(save1);
	}

	public int deleteFavorite(int lodge_idx) {
		return lodgeDAO.deleteFavorite(lodge_idx);
	}

}