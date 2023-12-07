package jpa.springdata.SpringData.repository;

import jpa.springdata.SpringData.entity.Member;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
//레포지터링 이름 + Impl을 적으면 알아서 맵핑해준다.
public class MemberRepositoryImpl implements MemberRepositoryCustom{

    private  final EntityManager em;


    @Override
    public List<Member> findMemberCustom() {
        return em.createQuery("select m from Member m")
                .getResultList();
    }
}
