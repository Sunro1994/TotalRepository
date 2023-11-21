package com.MyProject.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.MyProject.component.FileComponent;
import com.MyProject.component.HashComponent;
import com.MyProject.model.MemberDTO;
import com.MyProject.repository.MemberDAO;

@Controller
public class MemberController {
	
	@Autowired FileComponent fileComponent;
	@Autowired MemberDAO memberDAO;
	@Autowired HashComponent hashComponent;

	@GetMapping("/member/join")
	public String join() {
		return "member/join";
	}
	
	@PostMapping("/member/join")
	public String join(MemberDTO dto) {
		String fileName = fileComponent.makeFileName(dto.getProfileImg());
		String salt = hashComponent.getSalt();
		String hash = hashComponent.getHaSh(dto.getUserpw(), salt);
		dto.setOriginalFileName(dto.getProfileImg().getOriginalFilename());
		dto.setStoredFileName(fileName);
		
		System.out.println(salt);
		dto.setUserpw(hash);
		dto.setSalt(salt);
		
		int row = memberDAO.insert(dto);
		System.out.println(row + "행 추가");
		
		return "redirect:/";
	}

	@GetMapping("/member/login")
	public String login() {
		return "/member/login";
	}
	
	@PostMapping("/member/login")
	public String login(HttpSession session, MemberDTO dto) {
		
		//1. 로그인 아이디와 비밀번호 값을 받는다. ->dto
		//2. 아이디와 일치하는 데이터가 있다면 데이터와 데이터의 salt값을 가져온다.
			MemberDTO user = memberDAO.getUserById(dto);
			if(user!=null) {
				String salt = user.getSalt();
				String OldPw = user.getUserpw();
				String NewPw = hashComponent.getHaSh(dto.getUserpw(), salt);
				//3. 입력한 비밀번호와 salt를 조합한 해쉬값이 기존에 있는 해쉬값과 일치할 경우 login을 세션으로 유지시킨다.
				if(OldPw.equals(NewPw)) {
					session.setAttribute("login", user);
					//4. 일치하지 않으면 로그인창으로 다시 보냄
					return "redirect:/";
				}else {
					return "redirect:/member/login";
				}
				
			}
			//5. 일치하는 dto가 없는경우(null) 로그인창으로 다시 보냄
			
				return "redirect:/member/login";
			
		
	}

	@GetMapping("/member/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/member/findAccount")
	public String findAccount() {
		return "member/findAccount";
	}
	
	@PostMapping("/member/findID")
	public ModelAndView findID(MemberDTO dto) {
		ModelAndView mav = new ModelAndView("/member/findAccount");
		String userid = memberDAO.findUserId(dto.getUserid());
		mav.addObject("userid",userid);
		return mav;
	}
	
	@PostMapping("/member/findPWByQuestion")
	public ModelAndView findIDAndQuestion(MemberDTO dto) {
		ModelAndView mav = new ModelAndView("/member/findAccount");
		MemberDTO user =  memberDAO.findQuestion(dto.getUserid());
		
		mav.addObject("userInfo",user.getUserid());
		mav.addObject("question",user.getFindPassword());
		
		return mav;
	}
	
	@PostMapping("/member/getNewPassword")
	public ModelAndView getNewPassword(MemberDTO dto) {
		ModelAndView mav = new ModelAndView();
		
		MemberDTO user =  memberDAO.findQuestion(dto.getUserid());
		if(user.getFindAnswer().equals(dto.getFindAnswer())) {
			mav.setViewName("/member/findAccount");
			String str = UUID.randomUUID().toString().split("-")[0];
			String salt = hashComponent.getSalt();
			String hash = hashComponent.getHaSh(str, salt);
			user.setUserpw(hash);
			user.setSalt(salt);
			
			int row = memberDAO.updateUser(user);
			System.out.println(row+"행 변경");
			
			mav.addObject("newPW",str);
		}
		
		return mav;
	}
	
	
	

}
