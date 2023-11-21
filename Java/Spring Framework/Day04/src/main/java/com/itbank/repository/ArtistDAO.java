package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.itbank.model.ArtistDTO;

@Repository 
// 어노테이션 repository는 발생하는 예외를 dataExcessException타입으로 묶어서 처리하게 해주며 repository만의 기능을 발현하게 한다.
public interface ArtistDAO {

	//목록, 단일조회 , 검색, 수정 , 삭제, 추가
	//1. 목록
	@Select("select * from artist order by id")
	List<ArtistDTO> selectAll();
	//2. 단일조회
	@Select("select * from artist where id=#{id}")
	ArtistDTO selectOne(int id);
	
}
