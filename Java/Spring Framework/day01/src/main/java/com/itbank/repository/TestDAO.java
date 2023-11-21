package com.itbank.repository;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

// 생성자를 이용한 객체 생성이 불가능하다.
// public static final 속성이 자동으로 지정된다.
// 모든 메서드에 ablic abstract 속성이 자동으로 지정된다.
// 

@Repository
public interface TestDAO {
	
	//mybatis함수에 매개변수를 0개 또는 1개만 전달한다. 만약2개 이상 쓸경우 hashmap,dto사용
	//함수 이름을 중복되게(오버로딩) 설정해서는 안된다. 함수 이름을 매개로 전달하기 때문에 중복되면 모호해져 예외 발생
	@Select("select banner from v$version")
	String getVersion();
}
