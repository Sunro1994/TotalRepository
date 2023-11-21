package com.itbank.controller;


import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.service.KaKaoService;




@Controller
public class HomeController {
	
	@Autowired private KaKaoService kaKaoService;
	
	@GetMapping("/")
	public String home() {
		return"home";
	}
	
	@GetMapping("/login")
	public ModelAndView login(@RequestParam(value="code",required=false) String code) throws Exception{
		ModelAndView mav= new ModelAndView("result");
		
		String token = kaKaoService.getToken(code);
		HashMap<String, Object> userInfo = kaKaoService.getUserInfo(token);
		mav.addObject("code",code);
		mav.addObject("userInfo",userInfo);
		
		
		
		return mav;
	
		
	}
	
}
