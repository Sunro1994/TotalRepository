package com.TravelMaker.repository.admin;

import com.TravelMaker.model.LodgeDTO;
import com.TravelMaker.model.Lodge_Room_TypeDTO;
import com.TravelMaker.model.Recommend_TravelDTO;

public interface AdminDAO {

	int insertLodge(LodgeDTO dto);


    int insertRecommend(Recommend_TravelDTO dto);

    int deleteOneByIdx(int idx);

    int updateRecommend(Recommend_TravelDTO dto);
    
    int roomUpdate(int idx);


	int lodgeUpdate(int idx);


	int modifyLodge(LodgeDTO dto);


	int roomcorrection(Lodge_Room_TypeDTO dto);


	int insertLodgeRoom(Lodge_Room_TypeDTO dto);


	int deleteRoom(int idx);

}