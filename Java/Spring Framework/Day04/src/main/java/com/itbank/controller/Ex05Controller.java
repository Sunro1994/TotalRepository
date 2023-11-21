package com.itbank.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.Ex05DTO;

@Controller
public class Ex05Controller {

	@GetMapping("/ex05")
	public void ex05() {
		
	}
	
	@PostMapping("/ex05")
	public String ex05(Ex05DTO dto) throws IllegalStateException, IOException {

		File dir = new File("C:\\upload");		// 서버쪽 디렉토리 지정
		if(dir.exists()==false) {				// 만약 업로드 디렉토리가 없으면
			dir.mkdirs();						// 생성
		}
		//업로드 디렉토리 내부에, 원본 파일이름으로 새로운 파일 객체를 생성한다.
		//이때 실제 파일이 생성되는 것은 아니다. ( 파일을 생성하기 위한 기본 위치만 지정0
		File dest = new File(dir,dto.getUpload().getOriginalFilename());
		dto.getUpload().transferTo(dest);		//사용자가 제출한 파일을 지정한 dest로 전송(파일이 생성)! 가장 핵심
		
		System.out.println("title : "+ dto.getTitle());
		System.out.println("upload : "+ dto.getUpload().getOriginalFilename());
		System.out.println();
		
		return "redirect:/ex05";
	}
	
}
