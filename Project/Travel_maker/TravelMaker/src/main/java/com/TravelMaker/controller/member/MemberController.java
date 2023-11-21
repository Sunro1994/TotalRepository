package com.TravelMaker.controller.member;

import com.TravelMaker.model.TravelMaker_MemberDTO;
import com.TravelMaker.service.GoogleService;
import com.TravelMaker.service.KaKaoService;
import com.TravelMaker.service.member.MemberService;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Member")
public class MemberController {

    @Autowired 
    private MemberService memberService;
    @Autowired 
    private KaKaoService kaKaoService;
    @Autowired
    private GoogleService googleService;

    @GetMapping("/join")
    public void join(){}

    @PostMapping("/join")
    public String join (TravelMaker_MemberDTO dto){
        int row = memberService.join(dto);
        System.out.println(row != 0 ? "가입성공" : "가입실패");
        return "redirect:/";
    }
    
    @GetMapping("/login")
    public String login() {
    	return "home";
    }
    
    @PostMapping("/login")
    public ModelAndView login(TravelMaker_MemberDTO dto, HttpServletRequest request) {
    	ModelAndView mav = new ModelAndView();
	
    	return mav;
    }
    
    
    
    @GetMapping("/KaKaoJoin")
    public ModelAndView KakaoJoin(@RequestParam(value="code",required=false) String code) throws IOException {
    	ModelAndView mav = new ModelAndView("/Member/join");
    	String token = "";
    	token = kaKaoService.getToken(code);
    	

		HashMap<String, String> userInfo = kaKaoService.getUserInfo(token);
		mav.addObject("code",code);
		mav.addObject("userInfo",userInfo);
		
		System.out.println(userInfo);
		
		TravelMaker_MemberDTO dto = new TravelMaker_MemberDTO();
		dto.setTravelMaker_Member_UserId( userInfo.get("id"));
		dto.setTravelMaker_Member_Gender( userInfo.get("gender"));
		dto.setTravelMaker_Member_EncodingProfileImg( userInfo.get("profile_image"));
		dto.setTravelMaker_Member_UserNickName( userInfo.get("nickname"));
		dto.setTravelMaker_Member_Birth( userInfo.get("birthday"));
		dto.setTravelMaker_Member_UserNickName( userInfo.get("nickname"));
		mav.addObject("dto",dto);
		
		return mav;
		
    }
    
    @GetMapping("/KaKaoLogin")
    public String KakaoLogin(@RequestParam(value="code",required=false) String code,
    		HttpServletRequest request, HttpSession session) throws IOException {
    	String uri = request.getRequestURI();
    	String token = "";
    	token = kaKaoService.getToken(code);
    	System.out.println(code);
    	HashMap<String, String> userInfo = kaKaoService.getUserInfo(token);
    	TravelMaker_MemberDTO dto = new TravelMaker_MemberDTO();
    	
    	dto.setTravelMaker_Member_UserId(userInfo.get("id"));
    	dto.setTravelMaker_Member_UserPw(userInfo.get("id"));
    	TravelMaker_MemberDTO user = memberService.checkUser(dto);
    	if(user != null) {
    		session.setAttribute("user", user);
    		session.setAttribute("token", token);
    	}
    	else {
    		return "redirect:/Member/join";
    	}
    	return "redirect:/";
    }
    
    @GetMapping("/GoogleLogin")
    public void GoogleLogin(@RequestParam(value="code",required=false) String code) {
    	
    	String token = googleService.getToken(code);

    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	
    	String token = (String) session.getAttribute("token");
    	System.out.println(token);
    	TravelMaker_MemberDTO dto = (TravelMaker_MemberDTO) session.getAttribute("user");
    	kaKaoService.logout(token, dto.getTravelMaker_Member_UserId());
    	System.out.println(dto.getTravelMaker_Member_UserId());
    	session.invalidate();
    	
    	return "redirect:/";
    }
    
    @GetMapping("/logoutKAKAO")
    public void logoutKaKao(@RequestParam(value="state",required=false) String state) {
    	System.out.println(state);
    }
    
    
    @GetMapping("/myPage")
    public String myPage(HttpSession session) {
    	
    	return "Member/myPage";
    }
   
    


}
