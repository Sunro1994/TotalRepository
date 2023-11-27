package org.example.main;

import org.example.domain.Member;
import org.example.domain.MemberType;
import org.example.domain.Team;

import javax.persistence.*;
import java.util.List;

public class JPAMain_CaseExpression {
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
            member.setName("memberA");
            member.setAge(10);
            member.setTeam(team);
            member.setType(MemberType.USER);
            em.persist(member);

            Member member1 = new Member();
            member1.setName(null);
            member1.setAge(40);
            member1.setType(MemberType.ADMIN);
            member1.setTeam(team);
            em.persist(member1);

            //기본케이스
            String query = "select " +
                    "case when m.age <=19 then '학생' " +
                    "when m.age >=20 and m.age<=50 then '성인' " +
                    "else '노인' end " +
                    "from Member m";

            List<String> caseQuery = em.createQuery(query, String.class).getResultList();
            for (String s : caseQuery) {
                System.out.println("s = " + s);
            }

            //단순케이스
            String query2 = "select " +
                    "case t.name " +
                    "when 'teamA' then '팀A' " +
                    "else '팀없음' end " +
                    "from Team t";

            List<String> caseQuery2 = em.createQuery(query2, String.class).getResultList();
            for (String s : caseQuery2) {
                System.out.println("s = " + s);
            }
            System.out.println("==========================COALESCE========================");
            //COALESCE
            //관리자일때에는 이름을 숨기고 그 이외에는 이름을 출력한다.
            String query3 = "select coalesce(m.name, '관리자') from Member m";

            List<String> resultList = em.createQuery(query3, String.class).getResultList();
            for (String s : resultList) {
                System.out.println("s = " + s);
            }


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
            emf.close();
        }



    }
}
