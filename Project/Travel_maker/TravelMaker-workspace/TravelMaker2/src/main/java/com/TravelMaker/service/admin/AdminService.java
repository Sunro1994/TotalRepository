package com.TravelMaker.service.admin;

import com.TravelMaker.model.Recommend_TravelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TravelMaker.component.FileComponent;
import com.TravelMaker.model.LodgeDTO;
import com.TravelMaker.model.Lodge_Room_TypeDTO;
import com.TravelMaker.repository.admin.AdminDAO;

@Service
public class AdminService {
	
	@Autowired FileComponent fileComponent;
	@Autowired AdminDAO adminDAO;
	
	public int insertLodge(LodgeDTO dto) {
		String fileName = fileComponent.upload(dto.getImgFile());
		dto.setLodge_realimgname(fileName);
		int row = adminDAO.insertLodge(dto);
		
		return row;
	}

	public int insertRecommend(Recommend_TravelDTO dto) {

		// nullPointException 방지 null 체크 하는 코드 추가

		if (dto.getEncoding_img() != null && dto.getEncoding_img().getOriginalFilename() != null && dto.getEncoding_img().getOriginalFilename().length() != 0) {

			String encodingImg = fileComponent.upload(dto.getEncoding_img());

			dto.setRecommend_travel_img(encodingImg);
		}
		else {
			dto.setRecommend_travel_img(null);
		}

		int row = adminDAO.insertRecommend(dto);

		return row;
	}

	public int deleteOneByIdx(int idx) {
		return adminDAO.deleteOneByIdx(idx);
	}

	public int updateRecommend(Recommend_TravelDTO dto) {
		if (dto.getEncoding_img() != null && dto.getEncoding_img().getOriginalFilename() != null && dto.getEncoding_img().getOriginalFilename().length() != 0) {

			String encodingImg = fileComponent.upload(dto.getEncoding_img());

			dto.setRecommend_travel_img(encodingImg);
		}
		else {
			dto.setRecommend_travel_img(null);
		}
		int row = adminDAO.updateRecommend(dto);
		return row;
	}
	
	public int roomDelete(int idx) {
		return adminDAO.roomUpdate(idx);
	}

	public int lodgeDelete(int idx) {
		return adminDAO.lodgeUpdate(idx);
	}

	public int lodgemodifyOne(LodgeDTO dto) {
		System.out.println("이미지파일 : " + dto.getImgFile());
		if(dto.getImgFile().getSize()!=0) {
			String encodingName = fileComponent.upload(dto.getImgFile());
			dto.setLodge_realimgname(encodingName);
			
			System.out.println(encodingName);
		}

		return adminDAO.modifyLodge(dto);
	}

	public int roomcorrection(Lodge_Room_TypeDTO dto) {
		System.out.println(dto.getImgFile());
		if(dto.getImgFile().getSize()!=0) {
			System.out.println("파일 변환");
		String encodingName = fileComponent.upload(dto.getImgFile());
		dto.setLodge_Room_Type_Img(encodingName);
		}
		return adminDAO.roomcorrection(dto);
	}

	// 상세 숙소 추가
	public int insertLodgeRoom(Lodge_Room_TypeDTO dto) {
		if(dto.getImgFile().getSize()!=0) {
			String fileName = fileComponent.upload(dto.getImgFile());
			dto.setLodge_Room_Type_Img(fileName);
		}
		int row = adminDAO.insertLodgeRoom(dto);
		return row;
	}

	public int deleteRoom(int idx) {
		// TODO Auto-generated method stub
		return adminDAO.deleteRoom(idx);
	}


	
	
}