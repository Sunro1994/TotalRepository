package com.itbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Ex01Controller {

		//GetMapping은 @requestmapping(value="", method=request.getMethod.GET)과 같다.
		//어노테이션도 다 잘 달아뒀지만 서버는 이미 시작되어 맵핑이 불가능하기 때문에 항상 서버를 재시작 해줘야 컨트롤러가 작동한다.
		@GetMapping("/ex01")
		public void test() {
			System.out.println("함수 실행!!");
			//컨트롤러 함수의 반환형이 void이면 요청 주소가 viewName으로 활용된다.
			//컨트롤러에서 수행할 코드가 없고, 곧바로 jsp를 띄우면 될 경우에 주로 활용한다 .
			//void -> 예를 들어 로그인 창을 곧바로 띄우면 될때
		}
		@PostMapping("/ex01")
		public String test2(
				//파라미터로 HashMap을 받을때는 반드시 앞에 @RequestParam을 적어줘야 한다.
				/*@RequestParam("name")*/ String name, 
				/*@RequestParam("age")*/ int age, 
				Model model) {
			
			String adult = age >=20 ? "성인" : "미성년자";
			model.addAttribute("adult",adult);
			return "ex01-action";
		}
}
