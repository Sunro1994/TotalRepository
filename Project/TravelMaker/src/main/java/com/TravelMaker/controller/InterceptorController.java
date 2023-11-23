package com.TravelMaker.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InterceptorController {

	/* 미로그인시 로그인창으로 이동시키는 인터셉터 */
	@GetMapping("/WelcomeLogin")
	public String Login(){
		return "Welcome-Login";
	}
	
	
	/* 탈퇴된 회원인경우 알림으로 이동하는 인터셉터 */
	@GetMapping("/notExist")
	public String notExist(HttpSession session) {
		session.invalidate();
		return"/Member/notExist";
	}

}
