package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.TravelDTO;
import com.itbank.repository.TravelDAO;

@Service
public class TravelService {

	@Autowired private TravelDAO travelDAO;

	public List<TravelDTO> selectOne(String seoul) {
		List<TravelDTO> list = travelDAO.selectOne(seoul);
		return list;
	}
	
	
	
}
