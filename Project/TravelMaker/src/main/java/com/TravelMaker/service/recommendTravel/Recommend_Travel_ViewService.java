package com.TravelMaker.service.recommendTravel;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TravelMaker.model.Recommend_TravelDTO;
import com.TravelMaker.repository.recommendTravel.Recommend_TravelDAO;


@Service
public class Recommend_Travel_ViewService {

	@Autowired private Recommend_TravelDAO recommend_travelDAO;

	


	public Recommend_TravelDTO selectOneByIdx(int idx) {
        Recommend_TravelDTO dto = recommend_travelDAO.selectOneByIdx(idx);

        // 필요한 필드의 값에서 "" 를 "-" 로 바꾸기
        // 주소
        String address = dto.getRecommend_travel_address().replace("-", "").replaceAll("_", "-");
        dto.setRecommend_travel_address(address);

        // 전화번호
        String tel = dto.getRecommend_travel_tel().replace("-", "").replaceAll("_", "-");
        dto.setRecommend_travel_tel(tel);

        return dto;
    } 
}
