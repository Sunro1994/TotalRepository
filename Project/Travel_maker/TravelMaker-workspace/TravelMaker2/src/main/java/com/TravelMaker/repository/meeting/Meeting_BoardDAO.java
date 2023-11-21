package com.TravelMaker.repository.meeting;

import java.util.List;

import com.TravelMaker.model.Meeting_BoardDTO;

public interface Meeting_BoardDAO {

	List<Meeting_BoardDTO> selectList();

	int deleteBoard(int meeting_Board_Idx);

	int writeBoard(Meeting_BoardDTO dto);

	int modifyBoard(Meeting_BoardDTO dto);
	
}
