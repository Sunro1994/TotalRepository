package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itbank.model.TravelDTO;
import com.itbank.service.TravelService;

@RestController
@RequestMapping("/ajax")
public class AjaxController {

	@Autowired private TravelService travelService;

	
	@GetMapping("/location")
	public List<TravelDTO> parking(String value) {
		List<TravelDTO> list = travelService.selectOne(value);
		System.out.println(list);
		return list;
	}
	
}
