package org.example.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JPAMainBulk {

    public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

    EntityManager em = emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Team team2 = new Team();
            team2.setName("teamB");
            em.persist(team2);

            Member member = new Member();
            member.setName("User1");
            member.setTeam(team);
            em.persist(member);

            Member member2 = new Member();
            member2.setName("User2");
            member2.setTeam(team2);
            em.persist(member2);



            //자동으로 Flush호출(commit, query때 자동으로 flush가 나간다)
            int resultCount = em.createQuery("update Member m set m.age = 20").executeUpdate();

            System.out.println("resultCount = " + resultCount);
            //flush는 되어 있으나 1차 캐시(영속성 콘텍스트)에서 가져오는 상태
            System.out.println("age : " + member2.getAge());
            
            //영속성 컨텍스트 초기화
            em.clear();

            //새로 가져온 Member 객체
            Member findMember = em.find(Member.class, member.getId());
            System.out.println("findMember. = " + findMember.getAge());


            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
            emf.close();
        }

    }


}
