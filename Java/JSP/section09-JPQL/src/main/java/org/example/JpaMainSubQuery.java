package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMainSubQuery {
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


            //서브쿼리
            //from 절의 서브쿼리는 Hibernate5에서는 지원하지 않으므로 쿼리를 두번 날리거나, 따로 코드로 풀어도 되며, 조인을 풀어서 사용하는 방법도 있다.
            String query = "select (select avg(m1.age) from Member m1) from Member  m";
            List<Member> resultList1 = em.createQuery(query)
                    .getResultList();
            System.out.println("resultList.size() = " + resultList1.size());





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
