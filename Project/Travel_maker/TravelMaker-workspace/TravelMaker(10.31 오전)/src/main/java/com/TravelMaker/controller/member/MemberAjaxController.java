package com.TravelMaker.controller.member;

import com.TravelMaker.model.TravelMaker_MemberDTO;
import com.TravelMaker.service.KaKaoService;
import com.TravelMaker.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.TravelMaker.component.MailComponent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/ajax")
public class MemberAjaxController {

    @Autowired
    private MailComponent mailComponent;
    @Autowired
    private MemberService memberService;
    @Autowired
    private KaKaoService  kaKaoService;
   


    private Random ran = new Random();

    // 1) 이메일로 임의의 인증번호를 보낸다.
    @GetMapping("/sendAuthNumber")
    public String sendAuthNumber(String email, HttpSession session) {
        String authNumber = (ran.nextInt(899999) + 100000) + "";

        HashMap<String, String> param = new HashMap<>();
        param.put("receiver", email);
        param.put("subject", "[Travel Maker] 가입 인증 번호");
        param.put("content", authNumber);

        int row = mailComponent.sendMimeMessage(param);

        String msg;
        if (row != 1) {
            msg = "인증번호 발송에 실패 했습니다.";
        } else {
            msg = "인증번호가 발송 되었습니다.";
            session.setAttribute("authNumber", authNumber);
            session.setMaxInactiveInterval(600);
        }
        return msg;
    }

    // 2) 사용자가 확인용으로 입력한 인증번호와 세션에 저장된 인증번호를 비교하여 일치여부를 반환한다.
    @GetMapping("/checkAuthNumber/{userNumber}")
    public String checkAuthNumber(@PathVariable("userNumber")
                                  String userNumber, HttpSession session) {
        String sessionNumber = (String) session.getAttribute("authNumber");
        String result = userNumber.equals(sessionNumber) ? "1" : "0";
        return result;
    }

    @GetMapping("/checkDuplicationId")
    public String checkDuplicationId(String travelMaker_Member_UserId) {
        TravelMaker_MemberDTO dto = memberService.selectOneById(travelMaker_Member_UserId);
        String msg = dto == null ? "1" : "0";

        System.out.println(msg);
        return msg;
    }

    @GetMapping("/checkDuplicationNickname")
    public String checkDuplicationNickname(String nickname) {

        TravelMaker_MemberDTO dto = memberService.selectOneByNickname(nickname);
        String msg = dto == null ? "1" : "0";

        System.out.println(msg);
        return msg;
    }
    
    
    //로그인 비동기 확인
    @PostMapping("/checkLogin")
    public String checkLogin(@RequestBody TravelMaker_MemberDTO dto,HttpSession session) {
 
    	
    	TravelMaker_MemberDTO user = memberService.checkUser(dto);
		if(user!=null) {
			session.setAttribute("user", user);
			if(user.getTravelMaker_Member_Coupon()!=0) {
				session.setAttribute("hasCoupon", 1);
			}else {
				session.setAttribute("hasCoupon", 0);
				
			}
			return "성공";
		}
		else {
			return "실패";
		}
    	
    	
    }
    
   
    
   
    
    
    
}
