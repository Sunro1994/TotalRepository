package com.MyProject.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.MyProject.model.BoardDTO;

@Repository
public interface BoardDAO {

	@Select("select * from A_board order by board_idx")
	ArrayList<BoardDTO> selectList();

	@Insert("insert into A_board(title,writer_idx,writer,storedFileName,originalFileName,content)"
			+ " values(#{title},#{writer_idx},#{writer},#{storedFileName},#{originalFileName},#{content})")
	int insert(BoardDTO dto);
	
	@Update("update A_board set title=#{title}, content=#{content}, originalFileName=#{originalFileName}, storedFileName=#{storedFileName} "
			+ "where board_idx = #{board_idx}")
	int modify(BoardDTO dto);

	@Select("select * from A_board where board_idx=${board_idx}")
	BoardDTO selectOne(int board_idx);

	@Update("update A_board set storedFileName=null, originalFileName=null where storedFileName =#{storedFileName} ")
	int deleteImg(String storedFileName);

	@Delete("delete A_board where board_idx=${idx}")
	int delete(int idx);

	@Select("select * from A_board where instr(title,#{title})>0")
	ArrayList<BoardDTO> findList(BoardDTO dto); 
		
	
	
	

}
