package org.example.main;

import org.example.domain.Member;
import org.example.domain.MemberType;
import org.example.domain.Team;

import javax.persistence.*;
import java.util.List;

public class JPAMain_JPQLFetchJoin {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();


        try {
            Team team = new Team();
            team.setName("teamA");

            em.persist(team);

            Team teamB = new Team();
            teamB.setName("teamB");

            em.persist(teamB);


            Member member = new Member();
            member.setName("memberA");
            member.setAge(10);
            member.setTeam(team);
            member.setType(MemberType.USER);
            em.persist(member);
            
            Member member1 = new Member();
            member1.setName("memberB");
            member1.setAge(10);
            member1.setTeam(team);
            member1.setType(MemberType.USER);
            em.persist(member1);

            Member member2 = new Member();
            member2.setName("memberC");
            member2.setAge(10);
            member2.setTeam(teamB);
            member2.setType(MemberType.USER);
            em.persist(member2);

            em.flush();
            em.clear();

            String query = "select m From Member m";

            List<Member> resultList = em.createQuery(query, Member.class).getResultList();
            for (Member m : resultList) {
                System.out.println("m =" + m.getName() + " m.getTeam().getName() = " + m.getTeam().getName());
            }
            //memberA는 초기화가 안되어있기 때문에 SQL구문을 통해 데이터를 가져오고 1차 캐시에 등록한다.
            //memberB는 이미 1차 캐시에서 값이 있기때문에 곧바로 값을 불러온다.
            //memberC는 초기화가 안되어있어 SQL구문을 통해 데이터를 가져오고 1차캐시에 등록한다.
            // 만약 모든 회원이 팀이 다르다면? 1번의 쿼리로 회원테이블을 회원 수 만큼 불러온다.

            //이를 해결하기위한 방식이 fetch join
            //지연로딩없이 즉시 로딩으로 모든 연관관계를 한번의 초기화로 가져올 수 있다.
            em.flush();
            em.clear();
            System.out.println("=============fetch join(M:1, 1:1 )======================");
            String query2 = "select m From Member m join fetch m.team ";

            List<Member> resultList2 = em.createQuery(query2, Member.class).getResultList();
            for (Member m : resultList2) {
                System.out.println("m =" + m.getName() + " m.getTeam().getName() = " + m.getTeam().getName());
            }

            System.out.println("=============fetch join(1:M)==================");
            em.flush();
            em.clear();

            //컬렉션 페치 조인(일대다 관계)
            //Team의 아이디와 일치하는 members를 찾기 때문에 하나의 레코드에 두번 수행되는 것을 볼 수  있음
            String query3 = "select t From Team t join fetch t.members ";

            List<Team> resultList3 = em.createQuery(query3, Team.class).getResultList();

            for (Team m : resultList3) {
                System.out.println("m =" + m.getName() + " members = " + m.getMembers().size());
                for (Member mem : m.getMembers()) {
                    //하나의 값을 가져올때마다 두개의 값이 출력되는걸 볼 수 있다.
                    System.out.println("==>member = " + mem.getId());
                }
            }
            em.flush();
            em.clear();
            System.out.println("=======================중복제거 후 =======================");
            // 중복 해결법
            //distinct로 중복 제거시도 애플리케이션에서 올라올 때 중복을 제거 해준다.
            String query4 = "select distinct t From Team t join fetch t.members ";
            List<Team> resultList4 = em.createQuery(query4, Team.class).getResultList();
            for (Team m : resultList4) {
                System.out.println("m =" + m.getName() + " members = " + m.getMembers().size());
                for (Member mem : m.getMembers()) {
                    //하나의 값을 가져올때마다 두개의 값이 출력되는걸 볼 수 있다.
                    System.out.println("==>member = " + mem.getId());
                }
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
