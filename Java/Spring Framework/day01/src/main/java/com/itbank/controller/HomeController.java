package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itbank.repository.TestDAO;

/**
 * Handles requests for the application home page.
 * @controller 라는 어노테이션이 없으면 스프링 빈에 등록되지 않는다.
 */
@Controller		//요청을 전달받아서 응답을 만들어 낼 수 있는 컨트롤러 클래스 (역할 : 자동으로 맵핑해서 찾기)
				// component-scan에 의해서 스프링 빈으로 등록되는 클래스 (등록 : 빈으로 객체 생성)
public class HomeController {
	//model2와 달리 , 상속을 사용하지 않기 때문에 함수 작성 자유도가 높다.
	// 주소와 함수를 한 번에 등록하기 때문에, 하나의 컨트롤러에서 여러 함수를 작성할 수 있다.
	
	//컨트롤러가 작동하는데 필요한 다른 객체가 있으면 자동으로 연결할 수 있다 (스플이 빈 등록되어야 함)
	@Autowired
	private TestDAO testDAO;
	
	
	@RequestMapping("/") 		//주소 등록, 메서드 구분 없음
	public String home(Model model) {		//request를 꼭 받아야 할 필요가 없다
		
		String version = testDAO.getVersion();
		//request.setAttribute를 쓰기에는 너무 무겁기 때문에 경량화한 model에 있는 데이터를 넘긴다.
		model.addAttribute("version",version);
		
		return "home";			// 반환하는 문자열은 prefix + viewName + suffix 형식으로 포워딩 된다.
	}
	
	
}
