package com.TravelMaker.service.promotion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TravelMaker.repository.promotion.PromotionDAO;

@Service
public class PromotionService {
	
	@Autowired private PromotionDAO promotionDAO;

	public int insertCoupon(String value) {
		int couponnum = Integer.parseInt(value);
		int row = promotionDAO.insertuserCoupon(couponnum);
		System.out.println(row != 0 ? "성공" : "실패");
		return row;
	}

	
}
