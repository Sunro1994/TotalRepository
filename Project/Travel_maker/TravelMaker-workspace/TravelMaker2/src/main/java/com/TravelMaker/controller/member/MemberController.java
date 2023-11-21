package com.TravelMaker.controller.member;

import com.TravelMaker.model.TravelMaker_MemberDTO;
import com.TravelMaker.service.GoogleService;
import com.TravelMaker.service.KaKaoService;
import com.TravelMaker.service.NaverService;
import com.TravelMaker.service.member.MemberService;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
   
    @Autowired
    private NaverService naverService;
    
    /* 토근 저장 변수 */
    private String kakaoToken = null;
    private String googleToken = null;
    private String NaverToken = null;

    /* 일반 회원가입창 이동 */
    @GetMapping("/join")
    public void join(){}
    
    
    /* 이용 약관창 이동 */
    @GetMapping("/term")
    public String terms() {return"/Member/terms";}
    
    
    /* 회원정보 DB 삽입 */
    @PostMapping("/join")
    public String join (TravelMaker_MemberDTO dto){
        int row = memberService.join(dto);
        return "redirect:/";
    }
    
    
    
    
    
    /** 로그아웃 
     * 
     *  카카오, 네이버 로그아웃 시 토큰값 초기화 
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	

    	
    	TravelMaker_MemberDTO dto = (TravelMaker_MemberDTO) session.getAttribute("user");
    	if(kakaoToken!=null) {
    		kaKaoService.logout(kakaoToken);
    		kakaoToken = null;
    	}
    	if(NaverToken != null) {
    		naverService.logout(NaverToken);
    		NaverToken = null;
    	}
    	session.invalidate();
    	
    	return "redirect:/";
    }
    
    
    /** 
     * 
     *  마이 페이지 구간
     */
    
    /* 마이페이지 이동 */
    @GetMapping("/myPage")
    public String myPage(HttpSession session) {
    	
    	return "Member/myPage";
    }
   
    /* 회원 찾기 이동 */
    @GetMapping("/findMember")
	public void findMember(){}

    /* 비밀번호 찾는 페이지 이동 */
	@GetMapping("/findPw")
	public void findPw(){}
	
	
	/* 회원 비밀번호 변경 메서드*/
	@PostMapping("/findPw")
	public String findPw(TravelMaker_MemberDTO dto){
		int row = memberService.updatePw(dto);
		return "redirect:/";
	}
	
	/*회원 탈퇴 메서드 isExist N 으로 변경 */
	@GetMapping("/withdrawMember")
	public String withdrawMember(HttpSession session) {
		
		TravelMaker_MemberDTO dto = (TravelMaker_MemberDTO) session.getAttribute("user");
		memberService.secessionAll(dto);
		session.invalidate();
		
		return "redirect:/";
	}
	
	/* 마이페이지 수정 DB삽입 */
	@PostMapping("/myPage")
	public ModelAndView MemberupDate(TravelMaker_MemberDTO dto, HttpSession session, HttpServletResponse response) {
		ModelAndView mav=  new ModelAndView("index");
		int row = memberService.MemberUpDate(dto, session);
		if(row != 0) {
			session.invalidate();
			System.out.println("회원 정보가 수정되었습니다\n다시 로그인 해주세요");
			mav.setViewName("index");
		}
		else {
			System.out.println("회원정보 수정에 실패하였습니다");
			mav.setViewName("/Member/myPage");
		}
		return mav;
	}
	
	/** 회원 회원가입 및 로그인  페이지 구간 
	 * 	각 API는 토큰을 갖고 있으며 토큰을 해당 컨트롤러의 static 변수에 값을 담는다.
	 * 	로그아웃시에는 해당 토큰을 갖고 있는지 조건을 통해 토큰 만료를 시키며, static변수의 값은 null로 재지정한다.
	 * 	또한, 로그인시 hasCoupon값을 가져와서 쿠폰을 갖고 있는지 유무 판단을 사용
	 * **/
    
    /* 카카오 회원가입 */ 
    @GetMapping("/KaKaoJoin")
    public ModelAndView KakaoJoin(@RequestParam(value="code",required=false) String code) throws IOException {
    	ModelAndView mav = new ModelAndView("/Member/join");
    	String token = "";
    	token = kaKaoService.getTokenForJoin(code);
    	
		HashMap<String, String> userInfo = kaKaoService.getUserInfo(token);
		mav.addObject("code",code);
		mav.addObject("userInfo",userInfo);
		
		TravelMaker_MemberDTO dto = new TravelMaker_MemberDTO();
		dto.setTravelMaker_Member_UserId( userInfo.get("id"));
		dto.setTravelMaker_Member_UserPw( userInfo.get("id"));
		dto.setTravelMaker_Member_Gender( userInfo.get("gender"));
		dto.setTravelMaker_Member_EncodingProfileImg( userInfo.get("profile_image"));
		dto.setTravelMaker_Member_UserNickName( userInfo.get("nickname"));
		dto.setTravelMaker_Member_Birth( userInfo.get("birthday"));
		dto.setTravelMaker_Member_UserNickName( userInfo.get("nickname"));
		dto.setIsKakao("yes");
		mav.addObject("dto",dto);
		
		return mav;
		
    }
    
    /* 카카오 로그인 */ 
    @SuppressWarnings("unused")
	@GetMapping("/KaKaoLogin")
    public ModelAndView KakaoLogin(@RequestParam(value="code",required=false) String code,
    		HttpServletRequest request, HttpSession session) throws IOException {
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("redirect:/");
    	String token = "";
    	token = kaKaoService.getToken(code);
    	kakaoToken = token;
    	HashMap<String, String> userInfo = kaKaoService.getUserInfo(token);
    	TravelMaker_MemberDTO dto = memberService.selectOneById(userInfo.get("id"));
    	
    	if(dto != null) {
    		session.setAttribute("user", dto);
    		session.setAttribute("isKakao", "y");
    		int useCoupon = dto.getUseCoupon();
    		session.setAttribute("useCoupon", useCoupon );
    		
    		if(dto.getTravelMaker_Member_Coupon()==1) {	
    			session.setAttribute("hasCoupon", 1);
    		}
    		else {
    			session.setAttribute("hasCoupon",0);
    		}
    	}else {
    		mav.setViewName("redirect:/Member/needJoin");
    	}
    	
    	return mav;
    }
    
   
    	
 
    /* 구글 회원가입 */
    @GetMapping("/GoogleJoin")
    public ModelAndView GoogleJoin(@RequestParam(value="code",required=false) String code, HttpSession session) {
    	ModelAndView mav = new ModelAndView();
    	if(googleToken != null ) {
    		mav.setViewName("redirect:/Member/needLogin"); /* 에러 페이지 하나 만들어서  기존에 있던 유저가 가입시도했다고 알림 뜨게 하기*/
    	}
    	else {
    		mav.setViewName("Member/join");
    	HashMap<String, String> userInfo = googleService.getToken2(code);
    	mav.addObject("userInfo",userInfo);
    	
    	TravelMaker_MemberDTO dto = new TravelMaker_MemberDTO();
		dto.setTravelMaker_Member_UserId(userInfo.get("id"));
		dto.setTravelMaker_Member_UserPw(userInfo.get("id"));
		dto.setTravelMaker_Member_EncodingProfileImg( userInfo.get("picture"));
		dto.setTravelMaker_Member_UserNickName( userInfo.get("name"));
		dto.setTravelMaker_Member_Email(userInfo.get("email"));
		dto.setIsGoogle("yes");
		mav.addObject("dto",dto);
    	}
		
		
    	return mav;
    }
    
    /* 구글 로그인  */
    @GetMapping("/GoogleLogin")
    public ModelAndView GoogleLogin(@RequestParam(value="code",required=false) String code, HttpSession session) {
    	ModelAndView mav = new ModelAndView("index"); /* 회원이 없는 경우 에러 페이지로 이동하게 하기 */
    	HashMap<String, String> userInfo = googleService.getToken(code);
    	mav.addObject("userInfo",userInfo);
    	TravelMaker_MemberDTO dto = new TravelMaker_MemberDTO();
    	dto.setTravelMaker_Member_UserId(userInfo.get("id"));
    	dto.setTravelMaker_Member_UserPw(userInfo.get("id"));
    	
    	TravelMaker_MemberDTO user = memberService.checkUser(dto);
    	if(user != null) {
    		session.setAttribute("user", user);
    		session.setAttribute("isGoogle", "y");
    		int useCoupon = user.getUseCoupon();
    		session.setAttribute("useCoupon", useCoupon );
    		if(user.getTravelMaker_Member_Coupon()!=0) {
    			
    			session.setAttribute("hasCoupon", 1);
    		}else {
    			
    			session.setAttribute("hasCoupon",0);
    		}
    		mav.setViewName("index");
    		googleToken= userInfo.get("token");
    	}else {
    		mav.setViewName("redirect:/Member/needJoin");
    	}
    	return mav;
    }
    
	
	
	/* 네이버 회원가입 */
	@GetMapping("/NaverJoin")
	public ModelAndView naverLogin(@RequestParam(value="code", required=false) String code) throws IOException {
		ModelAndView mav=  new ModelAndView();
		String token = naverService.getToken(code);
		
		HashMap<String, String> map = naverService.getUserInfo(token);
		
		TravelMaker_MemberDTO dto = new TravelMaker_MemberDTO();
		
		
		dto.setTravelMaker_Member_UserNickName(map.get("nickname"));
		dto.setTravelMaker_Member_UserId(map.get("id"));
		dto.setTravelMaker_Member_UserPw(map.get("id"));
		dto.setTravelMaker_Member_Email(map.get("email"));
		dto.setTravelMaker_Member_Pnum(map.get("mobile"));
		dto.setIsNaver("yes");
		mav.addObject("dto",dto);
		
		
		mav.setViewName("Member/join");
		
		
		
		return mav;
	}
	
	/* 네이버 로그인 */
	@GetMapping("/NaverLogin")
    public ModelAndView NaverLogin(@RequestParam(value="code",required=false) String code, HttpSession session) throws IOException {
    	ModelAndView mav = new ModelAndView("index");
    	
    	String token = naverService.getToken2(code);
		NaverToken = token;
		
		HashMap<String, String> map = naverService.getUserInfo2(token);
		TravelMaker_MemberDTO dto = new TravelMaker_MemberDTO();
		dto.setTravelMaker_Member_UserId(map.get("id"));
    	dto.setTravelMaker_Member_UserPw(map.get("id"));
    	
    	TravelMaker_MemberDTO user = memberService.checkUser(dto);
    	if(user != null) {
    		session.setAttribute("user", user);
    		session.setAttribute("isNaver", "y");
    		int useCoupon = user.getUseCoupon();
    		session.setAttribute("useCoupon", useCoupon );
    		if(user.getTravelMaker_Member_Coupon()!=0) {
    			
    			session.setAttribute("hasCoupon", 1);
    		}else {
    			
    			session.setAttribute("hasCoupon",0);
    		}
    		NaverToken = token;
    		mav.setViewName("index");
    	}else {
    		mav.setViewName("redirect:/Member/needJoin");
    	}
    	return mav;
    }
	
	
	/** 에러 페이지 구간 **/
	
	
	/* 에러 페이지 이동 */
	@GetMapping("/needJoin")
	public String needJoin() {
		return "needJoin";
	}
	
	/* 에러 페이지 이동 */
	@GetMapping("/needLogin")
	public String needLogin() {
		return "needLogin";
	}
	
	/* 에러 페이지 이동 */
	@GetMapping("/Welcome-Login")
	public String WelcomeLogin() {
		return "/Welcome-Login";
	}
	
	@GetMapping("/cancleReservation/{idx}")
	public String cancleReservation(@PathVariable("idx") int idx) {
		
		int row = memberService.cancleReservation(idx);
		
		return "redirect:/lodge/lodge_main";
	}
	

}
