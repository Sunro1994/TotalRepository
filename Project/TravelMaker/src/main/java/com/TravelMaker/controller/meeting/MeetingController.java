package com.TravelMaker.controller.meeting;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.TravelMaker.model.Meeting_BoardDTO;
import com.TravelMaker.model.TravelMaker_MemberDTO;
import com.TravelMaker.service.meeting.Meeting_BoardService;

@Controller
@RequestMapping("/Meeting")
public class MeetingController {
		
	@Autowired private Meeting_BoardService meeting_BoardService;
	private Logger logger = LoggerFactory.getLogger(MeetingController.class);
	
	
	
	 @GetMapping("/meeting_chat")
	 public void meeting_chat() {
		 logger.info("[Controller] : chat");
	 }
	
	 @GetMapping("/meeting_main") 
	 public ModelAndView meeting_main() {
		 ModelAndView mav = new ModelAndView(); 
		 List<Meeting_BoardDTO> meetinglist = meeting_BoardService.selectList(); 
		 mav.addObject("meetinglist", meetinglist);
		 
		 return mav; 
	 }
	 
	 @PostMapping("/meeting_main")
	 public String meeting_write(Meeting_BoardDTO dto, HttpSession session) {
		 TravelMaker_MemberDTO user = (TravelMaker_MemberDTO) session.getAttribute("user");
		 dto.setMeeting_Board_Writer(user.getTravelMaker_Member_UserId());
		 
		 dto.setMeeting_Board_Nickname(user.getTravelMaker_Member_UserNickName());
		 
		 int row = meeting_BoardService.writeBoard(dto);
		 return "redirect:/Meeting/meeting_main";
	 }
	
	@GetMapping("/delete_board/{meeting_Board_Idx}")
	public String delete_board(@PathVariable("meeting_Board_Idx") int meeting_Board_Idx) {
		int row = meeting_BoardService.deleteBoard(meeting_Board_Idx);
		return "redirect:/Meeting/meeting_main";
	}
	
	@PostMapping("/meeting_modify/{meeting_Board_Idx}")
	public String modify_board(Meeting_BoardDTO dto) {
		int row = meeting_BoardService.modifyBoard(dto);
		
		return "redirect:/Meeting/meeting_main";
	}
	
}