package com.itbank.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.MenuDTO;
import com.itbank.repository.BasketDAO;

@Controller
public class BasketController {
	
	@Autowired BasketDAO dao;
	
	@GetMapping("/intoBasket/{idx}")
	public ModelAndView intoBasket(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("redirect:/list");
		
		int row = dao.insert(idx);
		System.out.println(row+"행 추가");
		
		return mav;
	}
	
	@GetMapping("/basketList")
	public ModelAndView basketList() {
		ModelAndView mav = new ModelAndView("basketList");
		ArrayList<MenuDTO> list = dao.selectList();
		if(list != null) {
			
			int sum = dao.totalPrice();
			mav.addObject("sum",sum);
		}
		mav.addObject("list",list);
		
		return mav;
	}
	
	@GetMapping("/CompletePay")
	public String CompletePay() {
		dao.deleteAll();
		
		return "redirect:/list";
	}
	
	
}
