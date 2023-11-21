package com.MyProject.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.MyProject.model.ReplyDTO;

@Repository
public interface ReplyDAO {

	@Select("select * from A_reply order by reply_idx desc")
	ArrayList<ReplyDTO> getList();

	@Insert("insert into A_reply(board_idx, writer,content,reply_level) values(#{board_idx},#{writer},#{content},#{reply_level})")
	int insert(ReplyDTO dto);
	
	
	@Delete("delete A_reply where reply_idx=${reply_idx}")
	int delete(int reply_idx);

}
