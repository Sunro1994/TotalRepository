package com.TravelMaker.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.TravelMaker.model.TravelMaker_MemberDTO;
import com.TravelMaker.service.member.MemberService;

@Controller
public class HomeController {

	@Autowired private MemberService memberService;
	
	@GetMapping("/")
	public String home() {
		
		return "index";
	}
	
//	//모든 로그인 요청을 받는 메서드
//	@RequestMapping(value = {"/recommend_travel/recommend_travel_main", "/lodge/lodge_main" ,"/travel_promotion/travel_promotion_main"})
//	public ModelAndView checkLogin(TravelMaker_MemberDTO dto, HttpServletRequest request, HttpSession session) {
//		ModelAndView mav = new ModelAndView();
//	
//		String redirectLink = request.getRequestURI().replace("/www", "");
//		mav.setViewName("redirect:"+redirectLink);
//		
//		
//		TravelMaker_MemberDTO user = memberService.checkUser(dto);
//		if(user!=null) {
//			session.setAttribute("user", user);
//			mav.addObject("FailLogin",null);
//		}
//		else {
//			mav.addObject("FailLogin","유효하지않은 아이디");
//		
//		}
//		
//		
//		return mav;
//	}
	
}
