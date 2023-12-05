package jpa.springdata.SpringData.repository;

import jpa.springdata.SpringData.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//인터페이스끼리 상속받을때에는 extends를 사용한다.
public interface MemberRepository extends JpaRepository<Member,Long> {

    List<Member> findByUsername(String username);


}
