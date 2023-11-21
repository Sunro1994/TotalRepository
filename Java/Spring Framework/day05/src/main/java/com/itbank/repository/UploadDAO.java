package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.itbank.model.UploadDTO;

@Repository
public interface UploadDAO {
	
	@Insert("insert into upload1(title,originalFileName,storedFileName) values(#{title},#{originalFileName},#{storedFileName})")
	int insert(UploadDTO dto);

	@Select("select * from upload1 order by idx")
	List<UploadDTO> selectList();
	
	@Delete("delete upload1 where idx=${idx}")
	int delete(int idx);
	
	@Select("select * from upload1 where idx=${idx}")
	UploadDTO selectOne(int idx);

}
