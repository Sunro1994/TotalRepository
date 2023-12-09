package study.jpa.queryDSL.domain;

import org.hibernate.Hibernate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class ProxyTest {

    @Autowired
    EntityManager em;
    @PersistenceUnit
    EntityManagerFactory emf;
    @Test
    public void checkProxy(){
        Member member = new Member();
        member.setUsername("memberA");
        em.persist(member);

        em.flush();
        em.clear();

        Member findMember = em.getReference(Member.class, member.getId());

        //준영속상태로 만들기
        em.detach(findMember);

        //proxy의 초기화 상태를 확인할 수 있다.
        boolean loaded = emf.getPersistenceUnitUtil().isLoaded(findMember);
        System.out.println("loaded = " + loaded);


        System.out.println("============프록시 초기화===============");
        Member findMember2 = em.find(Member.class, findMember.getId());
        System.out.println("findMember2 = " + findMember2.getUsername());

    }

}