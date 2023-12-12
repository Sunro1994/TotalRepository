package study.jpa.queryDSL.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberTest {

    @Autowired
    EntityManager em;

    @Test
    @Transactional
    public void testEntity(){
        Team team = new Team("teamA");
        Team team2 = new Team("teamB");
        em.persist(team);
        em.persist(team2);

        Member member1 = new Member("member1", 10, team);
        Member member2 = new Member("member2", 10, team);
        Member member3 = new Member("member3", 10, team2);
        Member member4 = new Member("member4", 10, team2);
        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);

        em.flush();
        em.clear();

        List<Member> resultList = em.createQuery("select m from Member  m", Member.class).getResultList();

        for (Member member : resultList) {
            System.out.println("member = " + member);
            System.out.println("member.getTeam() = " + member.getTeam());
        }
    }

    @Test
    @Transactional
    public void testLazyLoading(){
        Team team = new Team();
        team.setName("teamA");
        em.persist(team);

        Member member = new Member("memberA");
        em.persist(member);

        member.changeTeam(team);

        em.flush();
        em.clear();

        Member findMember = em.find(Member.class, member.getId());

        System.out.println("findMember = " + findMember.getClass());
        System.out.println("findMember.getTeam = " + findMember.getTeam().getClass());
        System.out.println("findMember.getTeam Proxy 초기화 = " + findMember.getTeam().getName());
    }




}