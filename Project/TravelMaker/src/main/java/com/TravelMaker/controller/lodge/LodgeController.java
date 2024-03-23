package com.TravelMaker.controller.lodge;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.TravelMaker.model.LodgeDTO;
import com.TravelMaker.model.Lodge_ReviewDTO;
import com.TravelMaker.model.Lodge_Room_TypeDTO;
import com.TravelMaker.model.Reserved_Lodge_Current_StateDTO;
import com.TravelMaker.model.SaveListDTO;
import com.TravelMaker.model.TravelMaker_MemberDTO;
import com.TravelMaker.service.lodge.LodgeService;
import com.TravelMaker.service.member.MemberService;

	

@Controller
@RequestMapping("/lodge")
public class LodgeController {
	
	@Autowired private LodgeService lodgeService;
	@Autowired private MemberService memberService;
	
	/* 메인 페이지로 이동 */
	@GetMapping("/lodge_main")
	public String lodge() {
		return "/Lodge/lodge";
	}
	
	
	/* 해당 숙소 세부 페이지(객실)로 이동  */
	@GetMapping("/LodgeRoom/{idx}")
	public ModelAndView lodgeRoom(@PathVariable("idx") int idx) {
		System.out.println("idx:" + idx);
		ModelAndView mav = new ModelAndView("/Lodge/lodgeRoom");
		LodgeDTO lodgeDTO = lodgeService.getLodge(idx);

		List<Lodge_Room_TypeDTO> roomList = lodgeService.getRoomList(idx);
		List<Lodge_ReviewDTO> reviewList = lodgeService.getReviewList(idx);
		
		mav.addObject("RoomList",roomList);
		mav.addObject("lodgeDTO",lodgeDTO);
		mav.addObject("reviewList",reviewList);
		

		return mav;
	}
	
	/* 결제창으로 이동  */
	@GetMapping("/Payment/{idx}/{start}/{end}")
	public ModelAndView payment(@PathVariable("idx") int idx, @PathVariable("start")String start, @PathVariable("end") String end) {
		ModelAndView mav = new ModelAndView("/Lodge/payment");

		Lodge_Room_TypeDTO roomDTO = lodgeService.getOneRoom(idx);
		mav.addObject("roomDTO",roomDTO);
		mav.addObject("start", start);
		mav.addObject("end", end);
		return mav;
	}
	
	/* 예약완료 창으로 이동  */
	@GetMapping("/reservationCheck/{idx}/{start}/{end}/{useCoupon}")
	public ModelAndView reservationCheck(
			@PathVariable("idx") int idx, @PathVariable("start")String start, @PathVariable("end") String end, @PathVariable("useCoupon") int useCoupon, HttpSession session
			) throws ParseException {
		ModelAndView mav = new ModelAndView("/Lodge/reservationCheck");
		
		Reserved_Lodge_Current_StateDTO ReservedDTO = new Reserved_Lodge_Current_StateDTO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		TravelMaker_MemberDTO memberDTO = (TravelMaker_MemberDTO)session.getAttribute("user");
		
		Date startDate = sdf.parse(start);
		Date endDate = sdf.parse(end);
		ReservedDTO.setReserved_Lodge_Current_State_StartDate(startDate);
		ReservedDTO.setReserved_Lodge_Current_State_EndDate(endDate);
		ReservedDTO.setReserved_Lodge_Current_State_RoomIdx(idx);
		ReservedDTO.setReserved_Lodge_Current_State_UserId(memberDTO.getTravelMaker_Member_UserId());
		lodgeService.insertReserved(ReservedDTO);
		
		memberDTO.setUseCoupon(useCoupon);
		int row = memberService.updateCouponStatus(memberDTO);
		
		return mav;
	}
	
	/* 리뷰 입력 창으로 이동  */
	@GetMapping("/review/{lodge_idx}/{lodge_Room_Type_Idx}")
	public ModelAndView review(@PathVariable("lodge_idx") int lodge_idx,
						@PathVariable("lodge_Room_Type_Idx")int lodge_Room_Type_Idx
						){
		ModelAndView mav = new ModelAndView("/Lodge/review");
		
		mav.addObject("lodge_idx",lodge_idx);
		
		mav.addObject("lodge_Room_idx",lodge_Room_Type_Idx);
		
		
		return mav;
	}
	
	
	/* 리뷰 입력 Form DB 삽입  */
	@PostMapping("/review/{lodge_idx}/{lodge_Room_Type_Idx}")
	public ModelAndView reviewWrite(Lodge_ReviewDTO dto, HttpSession session, String lodge_idx) {
		ModelAndView mav = new ModelAndView();
		TravelMaker_MemberDTO user = (TravelMaker_MemberDTO)session.getAttribute("user");
		dto.setLodge_Review_Writer(user.getTravelMaker_Member_UserId());		
		int idx = user.getTravelMaker_Member_Idx();
		int row = lodgeService.insertReview(dto);
		mav.setViewName("redirect:/lodge/LodgeRoom/"+lodge_idx);
		return mav;
	}
	
	// 찜목록 삭제
		@GetMapping("/deleteFavorite/{lodge_idx}")
		public String deleteFavorite(@PathVariable("lodge_idx") int lodge_idx, HttpServletRequest request) {
			int row = lodgeService.deleteFavorite(lodge_idx);
			return "redirect:/lodge/LodgeRoom/" + lodge_idx;
		}
	
}
