package com.itbank.controller;

import java.util.UUID;

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
public class Ex03Controller {

	@Autowired HashComponent hashComponent;
	@Autowired MemberDAO memberDAO;
	
	@GetMapping("/ex03")
	public void ex03(HttpSession session) {	}
	
	@PostMapping("/ex03")
	public ModelAndView ex03(MemberDTO dto) {
		ModelAndView mav = new ModelAndView();
		String pass ="";
		//1. id와 email 일치 계정정보 불러오기
			MemberDTO user = memberDAO.selectOne(dto);
		//2. 일치하면 랜덤 문자열(신규 패스워드)를 생성한 다음, 랜덤 솔트를 받아와서 새로운 해시값을 생성하고
			if(user!= null) {
				pass= UUID.randomUUID().toString().split("-")[0];
		//3. DB에 업데이트 한다.
			String salt = hashComponent.getSalt();
			String hash = hashComponent.getHash(pass,salt);
			user.setSalt(salt);
			user.setUserpw(hash);
			 int row = memberDAO.update(user);
			 System.out.println(row + "행 수정");
		//4. 신규 패스워드를 알려줄 수 있도록 한다.
			 mav.addObject("msg",String.format("신규 비밀번호는 [%s] 입니다", pass));
			}
			else {
				mav.setViewName("redirect:/ex02");
			}
		return mav;
	}
}
