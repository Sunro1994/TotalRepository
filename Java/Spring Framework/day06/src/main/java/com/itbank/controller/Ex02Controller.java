package com.itbank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.component.HashComponent;
import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@Controller
public class Ex02Controller {
	
	@Autowired HashComponent hashComponent;
	@Autowired MemberDAO memberDAO;
	
	@GetMapping("/ex02")
	public void ex02() {
		
	}
	
	@PostMapping("/ex02")
	public String ex02(MemberDTO dto, HttpSession session) {
		// 아이디가 동일한 DB의 데이터를 가져온다.
		MemberDTO comp1 = memberDAO.selectOneByuser(dto);
		if(comp1 == null) {
			session.invalidate();
			return"redirect:/ex02";
		}
		// 입력한 비밀번호와 comp1의 DB에서 가져온 객체의 salt를 넣고 해쉬코드를 생성
		String new_hashcode= hashComponent.getHash(dto.getUserpw(),comp1.getSalt());
//		생성된 해쉬코드와
//		DB에서 가져온 비밀번호(해쉬코드)가 일치해야 한다.
		
		if(new_hashcode.equals(comp1.getUserpw())) { 
			session.setAttribute("login", comp1);
			}
		else {
			session.invalidate();
			return"redirect:/ex02";
		}
		return "redirect:/";
	}
}
