package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.YoutubeDTO;
import com.itbank.repository.YoutubeDAO;

//a 태그는 get방식!
//model2와 차이점 : 스프링에서는 상속구조(Controller상속한 model2)가 아니기 때문에 얼마든지 함수를 생성할 수 있다.
@Controller
public class YoutubeController {
	
	//컨트롤러의 함수 반환형을 결정하기
	// 1) DB에서 불러온 데이터 혹은 다른 데이터를 jsp에 넘겨줘야 하는가?
	// yes -> ModelAndVIew
	
	// 2) 요청 주소와 JSP 이름이 일치하는가?
	// yes -> void , no -> String
	
	//mybatis-spring:scan으로 오토스캔하므로 
	//@Autowired가 자동으로 연결을 시켜준다.
	
	
	@Autowired private YoutubeDAO dao;
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		
		List<YoutubeDTO> list = dao.selectList();
		mav.addObject("list",list);
		return mav;
	}
	
	@GetMapping("/add")
	public void add() {
	}
	
	//command객체 : DTO만 있으면 자료형과 파일도 모두 지원된다.
	@PostMapping("/add")
	public String add(YoutubeDTO dto) {
		/*** dto.movieTag의 문자열을 수정하는 코드(Service로 이동가능)***/
		String movieTag = dto.getMovieTag();
		String[] arr = movieTag.split(" ");
		for(int i=0 ; i<arr.length;i++) {
			if(arr[i].startsWith("width"))  arr[i]= "width=\"720\"";
			if(arr[i].startsWith("height")) arr[i]= "height=\"405\"";
		}
		String answer="";
		for(String i : arr) answer +=i+" ";
		dto.setMovieTag(answer);
		
		/***********************************************/
		int row = dao.insert(dto);
		System.out.println(row + "행 추가");
		
		//주소를 요청시켜서 다시 list내부 코드를 활성화해야 하기 때문에 리다이렉트를 실행
		return "redirect:/list";
	}
	
	// view뒤 쿼리스트링을 {파라미터이름} 방식으로 가져온다.
	@GetMapping("/view/{idx}")			//가져온 변수를 @PathVariable("동일한 이름") 타입 변수명 으로 지정해준다.
	public ModelAndView view(@PathVariable("idx")int idx) {
		ModelAndView mav = new ModelAndView("view");
		
		int row = dao.updateCount(idx);
		System.out.println(row+"행 업데이트");
		YoutubeDTO dto = dao.selectOne(idx);
		mav.addObject("dto",dto);
		
		
		
		return mav;
		
	}
	
	@GetMapping("/delete/{idx}")			// <a href="">, location.href 모두 GET메서드이다.
	public String delete(@PathVariable("idx")int idx) {
		int row = dao.delete(idx);
		System.out.println(row+"행 제거");
		
		
		return "redirect:/list";
	}
	
	
	
	
}
