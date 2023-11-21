package com.TravelMaker.repository.member;

import com.TravelMaker.model.TravelMaker_MemberDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDAO {


    int insertMember(TravelMaker_MemberDTO dto);

    TravelMaker_MemberDTO selectOneById(String travelMaker_Member_UserId);

    TravelMaker_MemberDTO selectOneByNickname(String nickname);

	TravelMaker_MemberDTO checkUser(TravelMaker_MemberDTO dto);

	
}
