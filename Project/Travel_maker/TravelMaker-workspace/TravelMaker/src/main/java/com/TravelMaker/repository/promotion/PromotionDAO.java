package com.TravelMaker.repository.promotion;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

@Repository
public interface PromotionDAO {

	int insertuserCoupon(HashMap<String, Integer> map);

	
}
