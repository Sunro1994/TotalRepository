package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.itbank.model.TravelDTO;

@Repository
public interface TravelDAO {

	List<TravelDTO> selectOne(String seoul);
	

}
