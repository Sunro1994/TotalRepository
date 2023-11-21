package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.ArtistDTO;
import com.itbank.repository.ArtistDAO;

@Controller
public class Ex01Contoller {
	
	@Autowired private ArtistDAO artistdao;
	
	@GetMapping("/ex01")	//주소(요청 주소, 브라우저 주소창 찍히는 글자)
							//@pathvariable 은 계층형일때만 사용하고 그게 아니면 쿼리스트링사용하는게 일반적
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("/ex01/list"); //viewName(서버 내부의 jsp이름 및 경로)
		
		List<ArtistDTO> list = artistdao.selectAll();
		
		mav.addObject("list",list);
		
		return mav;
	}
	
	@GetMapping("/ex01/view")				//쿼리스트링 파라미터는 @requestParam을 사용한다.
	public ModelAndView view(int id) {		//대부분 @requestParam은 생략 가능하다.(해쉬맵 제외) 파라미터와 변수의 이름은 꼭 같아야 한다.
		ModelAndView mav = new ModelAndView("ex01/view");
		
		ArtistDTO dto = artistdao.selectOne(id);
		
		mav.addObject("dto",dto);
		return mav;
	}
}
