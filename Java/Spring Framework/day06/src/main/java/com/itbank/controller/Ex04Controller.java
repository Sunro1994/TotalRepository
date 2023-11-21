package com.itbank.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.component.HashComponent;
import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@Controller
public class Ex04Controller {

		@Autowired HashComponent hashComponent;
		@Autowired MemberDAO	memberDAO;
	
		@GetMapping("/ex04")
		public String ex04(HttpSession session) {
			
			if(session.getAttribute("login")==null) {
				return "redirect:/ex02";
			}
			
			return "ex04";
		}
		
		@PostMapping("/ex04")
		public String ex04( String currentPw,  String newPW, HttpSession session) {
			MemberDTO dto = (MemberDTO) session.getAttribute("login");
			Map<String, String> map = new HashMap<String, String>();
			
			
			
				String salt= hashComponent.getSalt();
				String hash = hashComponent.getHash(newPW, salt);
				String preHash = hashComponent.getHash(currentPw, dto.getSalt());
				map.put("userid", dto.getUserid());
				map.put("preHash", preHash);
				map.put("salt",salt);
				map.put("userpw", hash);
				
				
				int row = memberDAO.updateUseMap(map);
				System.out.println(row+"행 수정");
				session.invalidate();
			
			
			
			return "redirect:/ex02";
		}
		
		
}
