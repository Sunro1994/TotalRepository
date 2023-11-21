package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.ArtistDTO;
import com.itbank.repository.Ex03DAO;

@Controller
@RequestMapping("/ex03") 	//컨트롤러 하위의 모든 메서드에게 주소를 적용한다.
public class Ex03Controller {
	
	@Autowired private Ex03DAO ex03DAO;
	
	@GetMapping
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();	//view가 지정되지 않으면 requestMapping으로 받은 주소를 void타입처럼 그대로 돌려준다.
		List<ArtistDTO> list = ex03DAO.selectList();
		mav.addObject("list",list);
		
		
		return mav;
	}
	
}
