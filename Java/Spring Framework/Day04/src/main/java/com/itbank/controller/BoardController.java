package com.itbank.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.BoardDTO;
import com.itbank.repository.BoardDAO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired BoardDAO boardDAO; 
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("/board/list");
		
		ArrayList<BoardDTO> list =boardDAO.selectList();
		mav.addObject("list",list);
		
		
		return mav;
	}
	
	@GetMapping("/add")
	public String add() {
		
		return "/board/add";
	}
	
	@PostMapping("/add")
	public ModelAndView add(BoardDTO dto) {
		ModelAndView mav = new ModelAndView("redirect:/board/list");
		boardDAO.insert(dto);
		return mav;
	}
	
	@GetMapping("/view/{id}")
	public ModelAndView view(@PathVariable("id")int id) {
		ModelAndView mav = new ModelAndView("/board/view");
		
		BoardDTO dto = boardDAO.selectOne(id);
		mav.addObject("dto",dto);
		
		return mav;
	}
	
	@GetMapping("/modify/{id}")
	public ModelAndView modify(@PathVariable("id")int id) {
		ModelAndView mav = new ModelAndView("/board/modify");
		BoardDTO dto = boardDAO.selectOne(id);
		mav.addObject("dto",dto);
		
		return mav;
	}
	
	@PostMapping("/modify/{id}")
	public ModelAndView modify(BoardDTO dto) {
		ModelAndView mav = new ModelAndView("redirect:/board/view/{id}");
		
		
		boardDAO.modify(dto);
		
		
		return mav;
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("redirect:/board/list");
		boardDAO.delete(id);
		return mav;
	}
	
}
