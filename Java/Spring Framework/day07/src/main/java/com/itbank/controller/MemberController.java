package com.itbank.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.MemberDTO;
import com.itbank.service.MemberService;


@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired private MemberService memberService;
	
	@GetMapping("/login")
	public void login() {}
	
	@PostMapping("/login")
	public String login(HttpSession session, MemberDTO dto) {
		//입력들어온 값을 서비스에 넘겨서 세션에 넣고 최상위로 리다이렉트한다.
		//요청에 응답에 대한 내용만 집중해서 보내준다.
		MemberDTO login = memberService.login(dto);
		if(login != null) {			
			session.setAttribute("login", login);
			return "redirect:/";
		}
			return "redirect:/member/login";
	}
	
	@GetMapping("/join")
	public void join() {
		
	}
	
	@PostMapping("/join")
		public String join(MemberDTO dto) {
			
			int row = memberService.join(dto);
			System.out.println(row);
			return "redirect:/";
		}
	

	@GetMapping("/logout")
		public String logout(HttpSession session) {
			session.invalidate();
			return "redirect:/";
		}
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<MemberDTO> list =  memberService.selectAll();
		mav.addObject("list",list);
		return mav;
	}
	
	
	
}


