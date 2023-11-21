package com.TravelMaker.controller.promotion;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TravelMaker.service.promotion.PromotionService;

@RestController
@RequestMapping("/promotion")
public class PromotionRestController {
	
	@Autowired private PromotionService promotionService;

	///www/promotion/insertCoupon
	@PostMapping("/insertCoupon")
	public void insertCoupon(@RequestBody String value,HttpSession session) {
//		System.out.println(value);
	//로그인 유저 id 컬럼 안에 coupon 넣기
	value = value.replaceAll("\"", "");
	int row = promotionService.insertCoupon(value);
	System.out.println(row != 0 ? "추가되었습니다" : "실패하였습니다");
		
	}
	
}
