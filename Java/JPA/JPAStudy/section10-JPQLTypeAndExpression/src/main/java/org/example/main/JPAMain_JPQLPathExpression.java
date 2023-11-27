package org.example.main;

import org.example.domain.Member;
import org.example.domain.MemberType;
import org.example.domain.Team;

import javax.persistence.*;

public class JPAMain_JPQLPathExpression {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();


        try {
            Team team = new Team();
            team.setName("teamA");

            em.persist(team);


            Member member = new Member();
            member.setName("teamA");
            member.setAge(10);
            member.setTeam(team);
            member.setType(MemberType.USER);
            em.persist(member);

          em.flush();
          em.clear();
          //단일 값 연관 경로
          // 묵시적 내부 조인이 발생하는 쿼리(Member와 team을 조인해서 가져온다.)
            //명시적으로 조인 관계를 보여줘야 다른 개발자와 협업하기 편함
          String query = "select m.team From Member m";

            //컬렉션 값 연관 경로
            //컬렉션이므로 더 이상의 객체그래프탐색이 불가능, 객체 함수 정도는 사용 가능
            String query2 = "select t.members From Team t";
//            억지로 검색이 하고 싶다면 명시적 조인으로 사용 가능
//            "select m.name From Team t join t.members m"






            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
            emf.close();
        }



    }
}
