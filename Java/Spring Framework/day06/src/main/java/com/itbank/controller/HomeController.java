package com.itbank.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.component.HashComponent;


@Controller
public class HomeController {
	
	@Autowired private HashComponent hashComponent;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@PostMapping("/")
	public ModelAndView home(String source, String salt) {
		ModelAndView mav = new ModelAndView("home");
		
		//매개변수에 source와 salt를 받아야한다. 생성시에는 랜덤하게 받지만 , 조회때에는 이미 생성된 salt를 입력받아야하기 때문에
//		String salt = hashComponent.getSalt();
		System.out.println("salt ["+salt+"]" );
		if("".equals(salt)) salt = hashComponent.getSalt();
		String hash = hashComponent.getHash(source,salt);
		mav.addObject("hash",hash);
		mav.addObject("salt",salt);
		return mav;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
