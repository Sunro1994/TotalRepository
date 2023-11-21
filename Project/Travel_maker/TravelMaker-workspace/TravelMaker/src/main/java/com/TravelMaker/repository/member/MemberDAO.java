package com.TravelMaker.repository.member;

import com.TravelMaker.model.CouponDTO;
import com.TravelMaker.model.LodgeAndRoomDTO;
import com.TravelMaker.model.LodgeDTO;
import com.TravelMaker.model.TravelMaker_MemberDTO;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface MemberDAO {


    int insertMember(TravelMaker_MemberDTO dto);

    TravelMaker_MemberDTO selectOneById(String travelMaker_Member_UserId);

    TravelMaker_MemberDTO selectOneByNickname(String nickname);

	TravelMaker_MemberDTO checkUser(TravelMaker_MemberDTO dto);

	TravelMaker_MemberDTO selectOneByEmail(String email);

	int secessionAll(TravelMaker_MemberDTO dto);

	TravelMaker_MemberDTO isWithDrawl(TravelMaker_MemberDTO dto);

	int updatePw(TravelMaker_MemberDTO dto);


    int MemberUpDate(TravelMaker_MemberDTO dto);

    List<LodgeAndRoomDTO> getSelectedLodge(String getId);

	List<CouponDTO> getSelectCoupon(String getCoupon);

	int cancleReservation(int idx);

	int updateCouponStatus(TravelMaker_MemberDTO memberDTO);
}
