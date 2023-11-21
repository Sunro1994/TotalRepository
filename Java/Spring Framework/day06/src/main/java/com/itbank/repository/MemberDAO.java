package com.itbank.repository;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.itbank.model.MemberDTO;

@Repository
public interface MemberDAO {
	@Insert("insert into member2(userid,userpw,salt,username,email) values(#{userid},#{userpw},#{salt},#{username},#{email})")
	int insert(MemberDTO dto);

	@Select("select * from member2 where userid=#{userid}")
	MemberDTO selectOneByuser(MemberDTO dto);

	@Select("select * from member2 where userid=#{userid} and email=#{email}")
	MemberDTO selectOne(MemberDTO dto);

	@Update("update member2 set userpw=#{userpw}, salt=#{salt} where userid=#{userid}")
	int update(MemberDTO user);

	@Update("update member2 set userpw=#{userpw}, salt=#{salt} where userpw=#{preHash} and userid=#{userid}")
	int updateUseMap(Map<String, String> map);
	
	

	
}
