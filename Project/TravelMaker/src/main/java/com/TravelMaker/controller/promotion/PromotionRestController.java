package com.TravelMaker.controller.promotion;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TravelMaker.model.TravelMaker_MemberDTO;
import com.TravelMaker.service.member.MemberService;
import com.TravelMaker.service.promotion.PromotionService;

@RestController
@RequestMapping("/promotion")
public class PromotionRestController {
	
	@Autowired private PromotionService promotionService;
	@Autowired private MemberService memberService;
	
	/** 쿠폰 받아서 DB에서 저장
	 * 	쿠폰을 받은 경우 해당 세션에 hasCoupon을 1로 받는다.
	 *   */
	@PostMapping("/insertCoupon")
	public int insertCoupon(@RequestBody int value, HttpSession session) {
	//로그인 유저 id 컬럼 안에 coupon 넣기
	TravelMaker_MemberDTO dto = (TravelMaker_MemberDTO)session.getAttribute("user");
	int userid = dto.getTravelMaker_Member_Idx();
	int row = promotionService.insertCoupon(value, userid);
	if(row == 1) {	
		if((Integer)session.getAttribute("hasCoupon") == 1) { 
			return 0;	
		}
		session.setAttribute("hasCoupon", 1); 
		
	}
	
	TravelMaker_MemberDTO newUser = memberService.selectOneById(dto.getTravelMaker_Member_UserId());
	session.setAttribute("user", newUser);
	
	
	return row;
	}
	
}
 