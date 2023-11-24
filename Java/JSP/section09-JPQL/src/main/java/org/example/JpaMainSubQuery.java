package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMainJoin {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try{

                Team team = new Team();
                team.setName("team");
                em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            member.setTeam(team);

            em.persist(member);

            em.flush();
            em.clear();

            //inner, outer는 생략 가능
            String query = "select m from Member  m  join m.team t where m.username = t.name";
            List<Member> resultList = em.createQuery(query, Member.class)
                    .getResultList();
            System.out.println("resultList.size() = " + resultList.size());


            System.out.println("====start=====");
            String query2 = "select m from Member  m  left join m.team t on t.name = temaA";
            List<Member> resultList2 = em.createQuery(query, Member.class)
                    .getResultList();

            System.out.println("resultList2 = " + resultList2.size());




            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
