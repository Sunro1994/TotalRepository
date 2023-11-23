package com.TravelMaker.controller.member;

import com.TravelMaker.model.CouponDTO;
import com.TravelMaker.model.LodgeAndRoomDTO;
import com.TravelMaker.model.LodgeDTO;
import com.TravelMaker.model.Lodge_Room_TypeDTO;
import com.TravelMaker.model.TravelMaker_MemberDTO;
import com.TravelMaker.service.KaKaoService;
import com.TravelMaker.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.TravelMaker.component.HashComponent;
import com.TravelMaker.component.MailComponent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    private HashComponent hashcomponent;

    private Random ran = new Random();

    /* 이메일로 임의의 인증번호 전송 메서드  */ 
    @GetMapping("/sendAuthNumber")
    public String sendAuthNumber(String email, HttpSession session) {
    	String authNumber = (ran.nextInt(899999) + 100000) + "";
    	System.out.println(authNumber);

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
    /* 인증번호와 DB 비밀번호 일치 여부 확인  */ 
    @GetMapping("/checkAuthNumber/{userNumber}")
    public String checkAuthNumber(@PathVariable("userNumber")
                                  String userNumber, HttpSession session) {
        String sessionNumber = (String) session.getAttribute("authNumber");
        String result = userNumber.equals(sessionNumber) ? "1" : "0";
        return result;
    }

    /* 중복확인 메서드  */ 
    @GetMapping("/checkDuplicationId")
    public String checkDuplicationId(String travelMaker_Member_UserId) {
        TravelMaker_MemberDTO dto = memberService.selectOneById(travelMaker_Member_UserId);
        String msg = dto == null ? "1" : "0";

        System.out.println(msg);
        return msg;
    }

    /* 닉네임 중복확인 메서드 */ 
    @GetMapping("/checkDuplicationNickname")
    public String checkDuplicationNickname(String nickname) {

        TravelMaker_MemberDTO dto = memberService.selectOneByNickname(nickname);
        String msg = dto == null ? "1" : "0";

        System.out.println(msg);
        return msg;
    }
    
    /* 이메일 중복확인 체크 */ 
    @GetMapping("/checkExistEmail")
    public String checkExistEmail(String email){
        TravelMaker_MemberDTO dto = memberService.selectOneByEmail(email);
        String msg = dto == null ? "1" : "0";

        System.out.println(msg);
        return msg;
    }
    
    /* 로그인 메서드*/
    @PostMapping("/checkLogin")
    public String checkLogin(@RequestBody TravelMaker_MemberDTO dto,HttpSession session) {
 
    	
    	TravelMaker_MemberDTO user = memberService.checkUser(dto);
		if(user!=null) {
			session.setAttribute("user", user);
			int useCoupon = user.getUseCoupon();
    		session.setAttribute("useCoupon", useCoupon );
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
    
    
    /* 마이페이지 탈퇴 메서드  */
    @PostMapping("/myPage/secession")
    public Map<String, String> mbSecession(@RequestBody String numpw, HttpSession session) {
        TravelMaker_MemberDTO dto = (TravelMaker_MemberDTO) session.getAttribute("user");
        numpw = numpw.replaceAll("\"", "");
        try {
			numpw = URLDecoder.decode(numpw, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
        String salt = dto.getTravelMaker_Member_Salt();
        String hash = hashcomponent.getHash(numpw,salt);
        
        
        Map<String, String> response = new HashMap<>();
        
        if (dto.getTravelMaker_Member_UserPw().equals(hash)) {
            int row = memberService.secessionAll(dto);
            if (row != 0) {
                response.put("res", "탈퇴되었습니다\n그동안 이용해주셔서 감사합니다");
                session.invalidate();
            } else {
                response.put("res", "탈퇴실패");
            }
        } else {
            response.put("res", "비밀번호 불일치");
            
        }
        return response;
    }
    
    
    /* 비밀번호 가져오는 메서드 */
    @PostMapping("/getPassword")
    public String getPassword(@RequestBody String password, HttpSession session) {
    	TravelMaker_MemberDTO curUser = (TravelMaker_MemberDTO) session.getAttribute("user");
    	String salt = curUser.getTravelMaker_Member_Salt();
    	password =  password.replace("password=", "");
    	
    
    	try {
    		/* URLecoder.decode로  특수문자 decoding */
			password = URLDecoder.decode(password, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	
    	String response = hashcomponent.getHash(password, salt);
    	return  response;
    }
    
    
    /* 해당 유저 숙박 예약 리스트 가져오기 */
    @PostMapping("/getReservedList")
    public List<LodgeAndRoomDTO> getReservedList(@RequestBody String userid) {
        String getId = userid.replace("userid=", "");
        System.out.println(getId);
        //숙소 정보 + 객실 정보 + 리뷰 아이디 가져오기
        List<LodgeAndRoomDTO>  lodgeAndRoomDTO  = memberService.getSelectedLodge(getId);
        return lodgeAndRoomDTO;
    }
    
    
    /* 해당 유저 쿠폰 리스트 가져오기 */
    @PostMapping("/getCouponList")
    public List<CouponDTO> getCouponList(@RequestBody String userCoupon) {
    	String getCoupon = userCoupon.replace("userCoupon=", "");
    	List<CouponDTO> CouponListDTO = memberService.getSelectCoupon(getCoupon);
    	return CouponListDTO;
    }
    
   
    /* 이메일 유효 번호 인증 하기 */
    @GetMapping("/checkValidNumber")
    public String checkValidNumber(String email,HttpSession session) {
    	System.out.println(email);
    	String authNumber = memberService.sendEmail(email,session);
    	
    	
    	
    	return authNumber;
    }
    
   
    
    
    
}
