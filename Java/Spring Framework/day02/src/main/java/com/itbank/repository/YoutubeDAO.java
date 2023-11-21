package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itbank.model.YoutubeDTO;


public interface YoutubeDAO {
	
	@Select("select * from youtube order by idx")
	List<YoutubeDTO> selectList();
	
// String sql = "insert into youtube (title, channel, thumbnail, movieTag) values(?,?,?,?);
// mybatis에서는 column이름에는 ""를 쓰지않기 때문에 그럴떄 #{}을 사용할 수 있다.
//	컬럼이름과 속성값들의 값을 원하는대로 변환할 수 있다.
	@Insert("insert into youtube (title, channel, thumbnail, movieTag) values"
			+ "(#{title},#{channel},#{thumbnail},#{movieTag})")
	int insert(YoutubeDTO dto);

	//#을 쓰면 자유로운 타입을 쓸 수 있다, 자료형과 상관없이 따옴표를 안쓰는 것은 $을 사용해도 된다. 문자형인 경우 $를 사용하면 예외터짐
	@Select("select * from youtube where idx =${idx}")
	YoutubeDTO selectOne(int idx);
	
	@Delete("delete youtube where idx=#{idx}")
	int delete(int idx);

	@Update("update youtube set viewCount=viewCount+1 where idx=${idx}")
	int updateCount(int idx);

	
		
}
