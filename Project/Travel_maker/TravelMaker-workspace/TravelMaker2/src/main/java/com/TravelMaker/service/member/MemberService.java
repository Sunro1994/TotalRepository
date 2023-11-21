package com.TravelMaker.service.member;

import com.TravelMaker.component.FileComponent;
import com.TravelMaker.component.HashComponent;
import com.TravelMaker.component.MailComponent;
import com.TravelMaker.model.CouponDTO;
import com.TravelMaker.model.LodgeAndRoomDTO;
import com.TravelMaker.model.LodgeDTO;
import com.TravelMaker.model.TravelMaker_MemberDTO;
import com.TravelMaker.repository.member.MemberDAO;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired private MemberDAO memberDAO;
    @Autowired private HashComponent hashComponent;
    @Autowired private FileComponent fileComponent;
    @Autowired private MailComponent mailComponent;
    
    


    public int join(TravelMaker_MemberDTO dto) {
    	
        String salt = hashComponent.getRandomSalt();
        String hash = hashComponent.getHash(dto.getTravelMaker_Member_UserPw(), salt);
        dto.setTravelMaker_Member_UserPw(hash);
        dto.setTravelMaker_Member_Salt(salt);
        
        if(dto.getUpload().getOriginalFilename().length() != 0) {
        System.out.println("form에서 가져온 사진 : " + dto.getUpload());
        
        //문제 발견 : upload를 확인하고 넣어야 하는데 encodingprofileImg로 판단중이였음
            String encodingProfileImg = fileComponent.upload(dto.getUpload());
            dto.setTravelMaker_Member_EncodingProfileImg(encodingProfileImg);
        }
        else {
        	dto.setTravelMaker_Member_EncodingProfileImg(null);
        }



        return memberDAO.insertMember(dto);
    }


    public TravelMaker_MemberDTO selectOneById(String userid) {
        return memberDAO.selectOneById(userid);
    }

    public TravelMaker_MemberDTO selectOneByNickname(String nickname) {
        return memberDAO.selectOneByNickname(nickname);
    }


	public TravelMaker_MemberDTO checkUser(TravelMaker_MemberDTO dto) {
		
		TravelMaker_MemberDTO curUser = memberDAO.selectOneById(dto.getTravelMaker_Member_UserId());
		if(curUser!=null) {
			String currentSalt = curUser.getTravelMaker_Member_Salt();
			
			String TryHash = hashComponent.getHash(dto.getTravelMaker_Member_UserPw(), currentSalt);
			if(curUser.getTravelMaker_Member_UserPw().equals(TryHash)) {
				return curUser;
			}
			
		}
		return null;
	}


	public TravelMaker_MemberDTO selectOneByEmail(String email) {
				return memberDAO.selectOneByEmail(email);
	}


	public int secessionAll(TravelMaker_MemberDTO dto) {
		// TODO Auto-generated method stub
		return memberDAO.secessionAll(dto);
	}


	public TravelMaker_MemberDTO isWithDrawl(TravelMaker_MemberDTO dto) {
		
		return memberDAO.isWithDrawl(dto);
	}


	public int updatePw(TravelMaker_MemberDTO dto) {
		 String salt = hashComponent.getRandomSalt();
	        String hash = hashComponent.getHash(dto.getTravelMaker_Member_UserPw(), salt);
	        dto.setTravelMaker_Member_UserPw(hash);
	        dto.setTravelMaker_Member_Salt(salt);
		return memberDAO.updatePw(dto);
	}


	public int MemberUpDate(TravelMaker_MemberDTO dto, HttpSession session) {
TravelMaker_MemberDTO user = (TravelMaker_MemberDTO) session.getAttribute("user");
		
		//삽입할 유저의 인덱스 가져오기
		dto.setTravelMaker_Member_Idx(user.getTravelMaker_Member_Idx());
		
		
		/***
		 * @author 선로
		 * 
		 * 구글회원이면 비밀번호는 이전걸 가져온다.
		 * 세션이 구글을 검증하는 문자가 y인경우 아이디를 가져온다(아이디와 비밀번호는 동일함)
		 * 
		 * upload가 비어있는 경우 이전의 사진파일을 그대로 유지하도록 user에서 가져오고 비밀번호만 해쉬화해서 삽입
		 */
		
		String isGoogle = (String) session.getAttribute("isGoogle");
		String isKakao = (String) session.getAttribute("isKakao");
		if((isGoogle != null && isGoogle.equals("y")) ||(isKakao != null && isKakao.equals("y"))  ) {
			dto.setTravelMaker_Member_UserPw(user.getTravelMaker_Member_UserId());
		}
		//파일 유무 체크
		if(dto.getUpload().getOriginalFilename().length()<=0) {
			dto.setTravelMaker_Member_EncodingProfileImg(user.getTravelMaker_Member_EncodingProfileImg());
		}else {
			String encodingProfileImg = fileComponent.upload(dto.getUpload());
			dto.setTravelMaker_Member_EncodingProfileImg(encodingProfileImg);			
		}
			
		 String salt = hashComponent.getRandomSalt();
	        String hash = hashComponent.getHash(dto.getTravelMaker_Member_UserPw(), salt);
	        dto.setTravelMaker_Member_UserPw(hash);
	        dto.setTravelMaker_Member_Salt(salt);
	        
	        
	        
		return memberDAO.MemberUpDate(dto);
	}


	public List<LodgeAndRoomDTO> getSelectedLodge(String getId) {
		
		return memberDAO.getSelectedLodge(getId);
	}


	public List<CouponDTO> getSelectCoupon(String getCoupon) {
		
		return memberDAO.getSelectCoupon(getCoupon);
	}


	public String sendEmail(String email, HttpSession session) {
		String authNumber = ((UUID.randomUUID()+"").replaceAll("-", "")).substring(0,8);
		
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("receiver", email);
		param.put("subject", "[Traver Maker] 가입 인증 번호");
		param.put("content",authNumber);
//		
		mailComponent.sendMimeMessage(param);
		
		return authNumber;
	}


	public int cancleReservation(int idx) {
		// TODO Auto-generated method stub
		return memberDAO.cancleReservation(idx);
	}


	public int updateCouponStatus(TravelMaker_MemberDTO memberDTO) {
		return memberDAO.updateCouponStatus(memberDTO);
	}


	
}
