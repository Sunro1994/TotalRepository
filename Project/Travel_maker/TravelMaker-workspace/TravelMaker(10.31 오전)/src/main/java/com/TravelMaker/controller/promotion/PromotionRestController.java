package com.TravelMaker.controller.promotion;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TravelMaker.model.TravelMaker_MemberDTO;
import com.TravelMaker.service.promotion.PromotionService;

@RestController
@RequestMapping("/promotion")
public class PromotionRestController {
	
	@Autowired private PromotionService promotionService;

	///www/promotion/insertCoupon
	@PostMapping("/insertCoupon")
	public int insertCoupon(@RequestBody int value, HttpSession session) {
	//로그인 유저 id 컬럼 안에 coupon 넣기
	TravelMaker_MemberDTO dto = (TravelMaker_MemberDTO)session.getAttribute("user");
	int userid = dto.getTravelMaker_Member_Idx();
	int row = promotionService.insertCoupon(value, userid);
	if(row == 1) {	// 결과가 1이면 진입 ( 쿠폰을 처음 발급 받음)
		if((Integer)session.getAttribute("hasCoupon") == 1) { // 세션에 쿠폰공간이 1이면 진입(이미 있다는 의미)
			return 0;	// 0을 반환하여 쿠폰 다운로드 실패로 진행
		}
		session.setAttribute("hasCoupon", 1); // 만약 쿠폰 보관함에 쿠폰이 없어서 0일때는 hasCoupon(쿠폰보관함)에 1을 추가
		// 처음 말고는 hasCoupon(쿠폰보관함)이 1이 남아있기때문에 새로고침을 하지 않아도 판단할 수 있다
		
	}
	System.out.println(row != 0 ? "추가되었습니다" : "실패하였습니다");
	return row;
	}
	
}
 