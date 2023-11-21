package com.MyProject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.MyProject.component.FileComponent;
import com.MyProject.model.BoardDTO;
import com.MyProject.model.MemberDTO;
import com.MyProject.model.ReplyDTO;
import com.MyProject.repository.BoardDAO;
import com.MyProject.repository.ReplyDAO;

@Controller
public class BoardController {

	@Autowired BoardDAO boardDAO;
	@Autowired FileComponent fileComponent;
	@Autowired ReplyDAO replyDAO; 
	
	@GetMapping("/board")
	public ModelAndView board(HttpSession session) {
		ModelAndView mav =new ModelAndView();
		MemberDTO login = (MemberDTO) session.getAttribute("login");
		if(login == null) {
			mav.setViewName("redirect:/member/login");
		}
		else {
			if(mav.getModel().get("list")== null) {
				List<BoardDTO> list = boardDAO.selectList();
				mav.addObject("list",list);
				mav.setViewName("board/list");
			}
		}
		return mav;
	}
	@PostMapping("/board")
	public ModelAndView board(BoardDTO dto) {
		ModelAndView mav =new ModelAndView();
		String search = dto.getTitle();
		if(search.equals("")) {
			mav.setViewName("redirect:/board");
		}
		else {
			ArrayList<BoardDTO> list= boardDAO.findList(dto);
			mav.addObject("list",list);
			mav.setViewName("/board/list");
		}
		return mav;
	}
	@GetMapping("/board/add")
	public String add() {
		return "/board/add";
	}
	
	@PostMapping("/board/add")
	public String add(BoardDTO dto) {
		String storedFileName = fileComponent.makeFileName(dto.getContentImg());
		String originalFileName = dto.getContentImg().getOriginalFilename();
		
		dto.setStoredFileName(storedFileName);
		dto.setOriginalFileName(originalFileName);
		
		int row = boardDAO.insert(dto);
		System.out.println(row+ "행 추가");
		
		
		return "redirect:/board";
	}
	
	@GetMapping("/board/view/{board_idx}")
	public ModelAndView view(@PathVariable("board_idx")int board_idx) {
		ModelAndView mav = new ModelAndView("board/view");
		
		BoardDTO dto = boardDAO.selectOne(board_idx);
		mav.addObject("dto",dto);
		ArrayList<ReplyDTO> replyList = replyDAO.getList();
		mav.addObject("replyList",replyList);
		
		return mav;
	}
	
	@PostMapping("/board/view/{board_idx}")
	public ModelAndView view(@PathVariable("board_idx")int board_idx, ReplyDTO dto) {
		ModelAndView mav = new ModelAndView();
		if(dto.getReply_level()==0) dto.setReply_level(0);
		if(dto.getReply_h_idx()==0) dto.setReply_h_idx(0);
		int row = replyDAO.insert(dto);
		System.out.println(row+"행 삽입");
		mav.setViewName("redirect:/board/view/"+board_idx);
		return mav;
	}
	
	@GetMapping("/board/modify/{board_idx}")
	public ModelAndView modify(@PathVariable("board_idx")int board_idx) {
		ModelAndView mav = new ModelAndView("/board/modify");
		
		BoardDTO dto = boardDAO.selectOne(board_idx);
		mav.addObject("dto",dto);
		
		return mav;
	}
	
	@PostMapping("/board/modify/{board_idx}")
	public ModelAndView modify(BoardDTO dto) {
		ModelAndView mav = new ModelAndView();
		if(dto.getContentImg()!=null) {
			String originalFileName = dto.getContentImg().getOriginalFilename();
			String storedFileName = fileComponent.makeFileName(dto.getContentImg());
			
			dto.setOriginalFileName(originalFileName);
			dto.setStoredFileName(storedFileName);
		}
		
		int row = boardDAO.modify(dto);
		System.out.println(row+ "행 삽입");
			mav.setViewName("redirect:/board/view/"+dto.getBoard_idx());
			
			return mav;
		}
		
	
	@GetMapping("/board/deleteImg/{storedFileName}/{board_idx}")
	public ModelAndView deleteImg(@PathVariable("storedFileName") String storedFileName,
			@PathVariable("board_idx") int board_idx) {
		ModelAndView mav = new ModelAndView();
		int row = fileComponent.delete(storedFileName);
		System.out.println(storedFileName);
		System.out.println(row + "개의 사진 삭제");
		
		if(row !=0) {
			int row1= boardDAO.deleteImg(storedFileName);
			System.out.println(row1 + "행 삭제");
		}
		BoardDTO dto = boardDAO.selectOne(board_idx);
		
		mav.setViewName("redirect:/board/view/"+dto.getBoard_idx());
		
		
		return mav;
	}
	
	@GetMapping("/board/delete/{idx}")
	public String delete(@PathVariable("idx")int idx) {
		boardDAO.delete(idx);
		
		return "redirect:/board";
	}
	
	@GetMapping("/board/deleteReply/{reply_idx}/{board_idx}")
	public String deleteReply(@PathVariable("reply_idx")int reply_idx, @PathVariable("board_idx") int board_idx) {
			
		int row = replyDAO.delete(reply_idx);
		System.out.println(row+"행 삭제");
		return "redirect:/board/view/"+board_idx;
	}
}
