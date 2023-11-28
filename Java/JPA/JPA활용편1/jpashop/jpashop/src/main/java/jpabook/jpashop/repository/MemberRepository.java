package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository //springBean으로 등록
@RequiredArgsConstructor //생성자, persistenceContext어노테이션을 사용하지 않아도 알아서 em객체를 만들어준다. //final객체를 알아서 생성해준다.
public class MemberRepository {

    private  final  EntityManager em; //SpringBoot가 워낼 Autowired로 생성이 안되는 EntityManager를 만들게 지원해줘서 REquredArgsContructor로 생성이 가능하다.

    //    @PersistenceUnit ->  EntityManagerFacotry를 주입해준다.
//    private EntityManagerFactory emf;

    public void save(Member member) {
        em.persist(member);
    }

    //단건조회
    public Member find(Long id) {
        Member member = em.find(Member.class, id);
        return member;
    }

    //전체 조회
    public List<Member> findALl(){
        return em.createQuery("select m from Member m",Member.class)
                .getResultList();
    }

    //이름으로 조회
    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }



}
