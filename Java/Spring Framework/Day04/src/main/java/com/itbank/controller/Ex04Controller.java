package com.itbank.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

	


@Controller
public class Ex04Controller {
	@GetMapping("/ex04")
	public void ex04() {}

	@PostMapping("/ex04")
	public String ex04(MultipartRequest request) throws IllegalStateException, IOException {
		String saveDirectory = "C:\\upload";
		File dir = new File(saveDirectory);
		
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		MultipartFile f =  request.getFile("upload");		//사용자가 제출한 파일
		File dest = new File(saveDirectory, f.getOriginalFilename());	//내가 서버에서 만든 파일 객체(비어있음)
		f.transferTo(dest); //사용자가 올린 파일을 지정한 위치로 전송한다.
		
		System.out.println("input의 이름 : "+  f.getName());
		System.out.println("원본 파일의 이름 : "+  f.getOriginalFilename());
		System.out.println("컨텐트 유형의 이름  : " + f.getContentType());
		System.out.println("파일 크기 : "+ f.getSize());
		System.out.println();
		return "redirect:/ex04";
	}


}


