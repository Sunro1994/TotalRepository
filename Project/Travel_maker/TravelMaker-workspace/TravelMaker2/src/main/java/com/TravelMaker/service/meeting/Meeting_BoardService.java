package com.TravelMaker.service.meeting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TravelMaker.model.Meeting_BoardDTO;
import com.TravelMaker.repository.meeting.Meeting_BoardDAO;

@Service
public class Meeting_BoardService {
	
	@Autowired private Meeting_BoardDAO meeting_BoardDAO;
	
	public List<Meeting_BoardDTO> selectList() {
		List<Meeting_BoardDTO> list = meeting_BoardDAO.selectList();
		return list;
	}

	public int deleteBoard(int meeting_Board_Idx) {
		int row = meeting_BoardDAO.deleteBoard(meeting_Board_Idx);
		return row;
	}

	public int writeBoard(Meeting_BoardDTO dto) {
		int row = meeting_BoardDAO.writeBoard(dto);
		return row;
	}

	public int modifyBoard(Meeting_BoardDTO dto) {
		int row = meeting_BoardDAO.modifyBoard(dto);
		return row;
	}
}
