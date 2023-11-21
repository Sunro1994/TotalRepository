package com.itbank.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.Basket;
import com.itbank.model.MenuDTO;
import com.itbank.repository.BasketDAO;
import com.itbank.repository.orderDAO;

@Controller
public class OrderContoroller {
	
		@Autowired orderDAO dao;
		@Autowired BasketDAO basketDAO;
	
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		
		ArrayList<MenuDTO> list = dao.selectList();
		ArrayList<MenuDTO> basketList = basketDAO.selectList(); 
		mav.addObject("list",list);
		mav.addObject("basketList",basketList);
		
		
		return mav;
	}
	@GetMapping("/drunkList")
	public ModelAndView drunkList() {
		ModelAndView mav = new ModelAndView("list");
		
		ArrayList<MenuDTO> list = dao.selectDrink();
		mav.addObject("list",list);
		
		return mav;
	}
	@GetMapping("/additionalOrder")
	public ModelAndView additionalList() {
		ModelAndView mav = new ModelAndView("list");
		
		ArrayList<MenuDTO> list = dao.selectAdditional();
		mav.addObject("list",list);
		
		return mav;
	}
	
	@GetMapping("/add")
	public String add() {
		
		return "add";
	}
	@PostMapping("/add")
	public String add(MenuDTO dto) {
		
		int row = dao.insert(dto);
		System.out.println(row + "행 추가");
		
		
		return "redirect:/list";
	}
	
	@GetMapping("/view/{idx}")
	public ModelAndView view(@PathVariable("idx")int idx) {
		ModelAndView mav = new ModelAndView("view") ;
		
		MenuDTO dto = dao.selectOne(idx);
		mav.addObject("dto",dto);
		
		
		return mav;
	}
	
	
	@GetMapping("/modify/{idx}")
	public ModelAndView modify(@PathVariable("idx")int idx) {
		ModelAndView mav = new ModelAndView();
		
		MenuDTO dto= dao.selectOne(idx);
		mav.addObject("dto",dto);
		mav.setViewName("modify");
		
			
		return mav;
	}
	
	@PostMapping("/modify/{idx}")
	public ModelAndView modify(@PathVariable("idx")int idx, MenuDTO dto) {
		ModelAndView mav = new ModelAndView("redirect:/view/{idx}");
		
		int row = dao.modify(dto);
		System.out.println(row);
		
		
		
		return mav;
	}
	
	@GetMapping("delete/{idx}")
	public String delete(@PathVariable("idx") int idx) {
		dao.delete(idx);
		
		
		return "redirect:/list";
		
	}
	
	@GetMapping("/search")
	public String search() {
		
		return "search";
	}
	
	@PostMapping("/search")
	public ModelAndView search(String findFood) {
		ModelAndView mav = new ModelAndView();
		
		ArrayList<MenuDTO> list = dao.search(findFood);
		mav.addObject("list",list);
		System.out.println(list);
		
		return mav;
	}
	
	@GetMapping("/recommand")
	public ModelAndView recommand() {
		ModelAndView mav = new ModelAndView();
		
		MenuDTO dto = dao.selectRandom();
		mav.addObject("dto",dto);
		
		
		return mav;
	}
	
	@GetMapping("/pay")
	public String pay() {

		return "pay";
	}
	
	
	


}
