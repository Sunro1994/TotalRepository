package jpa.springdata.SpringData.repository;

import jpa.springdata.SpringData.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

// 복잡한 쿼리문을 쓸 때 이 레포지터리를 그냥Autowired로 가져와서 쓰면된다.
@Repository
@RequiredArgsConstructor
public class MemberQueryRepository {


    private final EntityManager em;

    List<Member> findAllMembers() {
        return em.createQuery("select m from Member  m ", Member.class).getResultList();
    }

}
