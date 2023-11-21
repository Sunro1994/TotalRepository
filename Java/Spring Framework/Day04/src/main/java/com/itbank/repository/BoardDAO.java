package com.itbank.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.itbank.model.BoardDTO;

@Repository
public interface BoardDAO {
	
	@Select("select * from board")
	ArrayList<BoardDTO> selectList();

	@Insert("insert into board(title,content,pwd) values(#{title},#{content},#{pwd})")
	int insert(BoardDTO dto);

	@Select("select * from board where id=#{id}")
	BoardDTO selectOne(int idx);

	@Update("update board set title=#{title},content=#{content} where id=${id} ")
	void modify(BoardDTO dto);

	@Delete("delete board where id=#{id}")
	void delete(int id);

	
	
}
