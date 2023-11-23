package com.TravelMaker.service.promotion;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TravelMaker.repository.promotion.PromotionDAO;

@Service
public class PromotionService {
	
	@Autowired private PromotionDAO promotionDAO;

	public int insertCoupon(int value, int useridx) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("1", value);
		map.put("2", useridx);
		int row = promotionDAO.insertuserCoupon(map);
		System.out.println(row != 0 ? "성공" : "실패");
		return row;
	}

	
}
