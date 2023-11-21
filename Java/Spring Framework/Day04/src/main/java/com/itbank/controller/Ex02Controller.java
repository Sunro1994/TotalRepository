package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.ArtistDTO;
import com.itbank.repository.ArtistDAO;

@Controller
@RequestMapping("/ex02")	//앞에 들어있는 공통주소를 일괄적으로 적용
public class Ex02Controller {
	
	@Autowired ArtistDAO artistDAO;
	
	@GetMapping
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("/ex02/list"); //viewName(서버 내부의 jsp이름 및 경로)
		
		List<ArtistDTO> list = artistDAO.selectAll();
		
		mav.addObject("list",list);
		
		return mav;
	}
	
//	@getMapping("/board/{boardCategory}/{boardId}/") pathVariable변수로 2개 받을 수 있다. 거의 2개까지 쓰고 문자열은 선호하지 않는다.
//										마지막에 /를 붙여준다. /이 구분자가 되어 안에 특수문자나 공백이 있어도 인식가능하다.
	@GetMapping("/view/{id}")
	public ModelAndView view(@PathVariable("id")int id) {
		ModelAndView mav = new ModelAndView("/ex02/view");
			ArtistDTO dto = artistDAO.selectOne(id);
			mav.addObject("dto",dto);
			
			
		return mav;
	}
}
