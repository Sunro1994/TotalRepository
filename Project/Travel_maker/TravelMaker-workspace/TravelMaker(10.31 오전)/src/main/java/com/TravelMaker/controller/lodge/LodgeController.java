package com.TravelMaker.controller.lodge;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.TravelMaker.model.Lodge_Room_TypeDTO;
import com.TravelMaker.service.lodge.LodgeService;

	

@Controller
@RequestMapping("/lodge")
public class LodgeController {
	
	@Autowired private LodgeService lodgeService;
	
	@GetMapping("/lodge_main")
	public String lodge() {
		return "/Lodge/lodge";
	}
	
	@GetMapping("/LodgeRoom/{idx}")
	public ModelAndView lodgeRoom(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("/Lodge/lodgeRoom");
		
		List<Lodge_Room_TypeDTO> RoomList = lodgeService.getRoomList(idx);
		mav.addObject("RoomList",RoomList);
		
		
		return mav;
	}
	
	@GetMapping("/Payment/{idx}")
	public ModelAndView payment(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("/Lodge/payment");
		
		Lodge_Room_TypeDTO roomDTO = lodgeService.getOneRoom(idx);
		mav.addObject("roomDTO",roomDTO);
		
		return mav;
	}
}
