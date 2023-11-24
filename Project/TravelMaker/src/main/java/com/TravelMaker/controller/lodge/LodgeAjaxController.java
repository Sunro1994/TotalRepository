package com.TravelMaker.controller.lodge;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TravelMaker.model.LodgeDTO;
import com.TravelMaker.model.Lodge_Room_TypeDTO;
import com.TravelMaker.model.SaveListDTO;
import com.TravelMaker.model.TravelMaker_MemberDTO;
import com.TravelMaker.service.lodge.LodgeService;

@RestController
@RequestMapping("/lodge")
public class LodgeAjaxController {
	
	@Autowired LodgeService lodgeService;
	
	/*   필터 검색 결과 가져오는 메서드  */
	@PostMapping("/getSelectedList")
	public List<LodgeDTO> getList(@RequestBody LodgeDTO LodgeFilter ){
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<String> Arealist = LodgeFilter.getAreaArr();
		List<String> Typelist = LodgeFilter.getTypeArr();
		String startDate = LodgeFilter.getStartDate();
		String endDate = LodgeFilter.getEndDate();
		
		map.put("startDate"	, startDate);
		map.put("endDate"	, endDate);
		map.put("Arealist",Arealist);
		map.put("Typelist",Typelist);
		
		
		List<LodgeDTO> list =  lodgeService.selectedList(map);
		
		
		
		
		return list;
		
	}
	
	/*   랜덤 결과 가져오는 메서드  */
	@GetMapping("/getRandomList")
	public List<LodgeDTO> getRandomList(){
		List<LodgeDTO> list = lodgeService.randomList();
		return list;
	}
	
	
	/*   숙소 검색 결과로 가져오는 메서드  */
	@PostMapping("/getSelectKeywordList")
	public List<LodgeDTO> getSelectKeywordList(String keyword) {
		List<LodgeDTO> list = lodgeService.selectKeyword(keyword);
		return list;
	}
	
	/*   숙소 세부 정보(객실) 필터로 가져오는 메서드  */
	@PostMapping("/getselectedRoom")
	public List<Lodge_Room_TypeDTO> getselectedRoom(@RequestBody Lodge_Room_TypeDTO roomFilter ){
		
		List<Lodge_Room_TypeDTO> list = lodgeService.selectedRoomList(roomFilter);

		//예약이 된 방은 차감
		list.forEach(e-> {
			roomFilter.setLodge_Room_Type_Idx(e.getLodge_Room_Type_Idx());
			e.setLodge_Room_Type_Count(e.getLodge_Room_Type_Count() - lodgeService.getCount(roomFilter));
		});
		
		
		
		
		return list;
		
	}
	
	// 찜목록 추가
		@GetMapping("/insertSave")
	    public int getSaveList(int lodge_idx,String userid, HttpSession session) {
			int row = 0;
	        TravelMaker_MemberDTO user = (TravelMaker_MemberDTO) session.getAttribute("user");
	        
	        // lodge_savelist 테이블에 lodge_idx와 userid 삽입
	        SaveListDTO save1 = new SaveListDTO();
	        save1.setSaveList_Lodge_Idx(lodge_idx);
	        save1.setSaveList_UserId(user.getTravelMaker_Member_UserId());
	        
	        // 똑같은게 있는지 확인하는 sql문
	        List<SaveListDTO> list = lodgeService.selectDuplicationList(save1);
	        
	        // 비어있으면 추가
	        if(list.isEmpty()) {
	            row = lodgeService.saveInsert(save1);
	            return row;
	        }
	        
	        return row;
	    }
		
		// 찜목록 반환
		@GetMapping("/selectSaveList")
		public  List<LodgeDTO> getSelectSaveList(HttpSession session) {
	        TravelMaker_MemberDTO user = (TravelMaker_MemberDTO) session.getAttribute("user");
	        
	        // 해당 조건에 맞는 list 반환
	        SaveListDTO save = new SaveListDTO();
	        save.setSaveList_UserId(user.getTravelMaker_Member_UserId());
	        
	        List<LodgeDTO> dto = lodgeService.selectSaveList(save);
	        return dto;
	    }
}
