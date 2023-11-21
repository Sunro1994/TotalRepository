package com.TravelMaker.service.member;

import com.TravelMaker.component.FileComponent;
import com.TravelMaker.component.HashComponent;

import com.TravelMaker.model.TravelMaker_MemberDTO;
import com.TravelMaker.repository.member.MemberDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired private MemberDAO memberDAO;
    @Autowired private HashComponent hashComponent;
    @Autowired private FileComponent fileComponent;


    public int join(TravelMaker_MemberDTO dto) {
        String salt = hashComponent.getRandomSalt();
        String hash = hashComponent.getHash(dto.getTravelMaker_Member_UserPw(), salt);
        dto.setTravelMaker_Member_UserPw(hash);
        dto.setTravelMaker_Member_Salt(salt);

        if(dto.getTravelMaker_Member_EncodingProfileImg() != null) {
            String encodingProfileImg = fileComponent.upload(dto.getUpload());
            dto.setTravelMaker_Member_EncodingProfileImg(encodingProfileImg);
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
}
