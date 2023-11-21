package com.itbank.controller;

import java.util.List;

import org.apache.commons.fileupload.UploadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.component.FileComponent;
import com.itbank.model.Ex06DTO;
import com.itbank.repository.Ex06DAO;
@Controller
public class Ex06Controller {
	
	@Autowired private FileComponent fileComponent;
	@Autowired private Ex06DAO ex06DAO;
	
	@GetMapping("/ex06")
	public ModelAndView ex06() {
		ModelAndView mav = new ModelAndView();
		List<Ex06DTO> list = ex06DAO.seletAll();
		mav.addObject("list",list);
		
		return mav;
		}
	
	//문제 : 중복된 이름을 회피할 수 있는 기능이 필요하다 => UUID
	@PostMapping("/ex06")
	public String ex06(Ex06DTO dto) {
		
		String fileName = fileComponent.upload(dto.getUpload());
		
		dto.setFileName(fileName);
		int row = ex06DAO.insert(dto);
		System.out.println(row+"행 추가");
		return "redirect:/ex06";
	}
}
