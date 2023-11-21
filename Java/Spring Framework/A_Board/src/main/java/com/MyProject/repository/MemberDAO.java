package com.MyProject.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.MyProject.model.MemberDTO;

@Repository
public interface MemberDAO {

	@Insert("insert into A_member(userid,userpw,username,birth,email,findPassword,findAnswer,storedFileName,originalFileName,salt) "
			+ " values(#{userid},#{userpw},#{username},#{birth},#{email},#{findPassword},#{findAnswer},#{storedFileName},#{originalFileName},#{salt})")
	int insert(MemberDTO dto);

	@Select("select * from A_member where userid=#{userid}")
	MemberDTO getUserById(MemberDTO dto);

	@Select("select userid from A_member where userid=#{userid}")
	String findUserId(String userid);

	@Select("select * from A_member where userid=#{userid}")
	MemberDTO findQuestion(String userid);

	@Update("update A_member set salt=#{salt}, userpw=#{userpw} where userid=#{userid}")
	int updateUser(MemberDTO user);

}
