package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.itbank.model.Ex06DTO;

@Repository
public interface Ex06DAO {

	@Insert("insert into upload1(title, fileName) values(#{title},#{fileName})")
	int insert(Ex06DTO dto);

	@Select("select * from upload1 order by idx")
	List<Ex06DTO> seletAll();
	
}
