package study.jpa.queryDSL.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import study.jpa.queryDSL.domain.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Long>,MemberRepositoryCustom {

    //select m from Member m where m.username = ? 방식으로 알아서 생성됨
    List<Member> findByUsername(String username);

}
