package org.example.Domain.TwoWay;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMainTwoWaySolveProblem2 {
    public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();





        tx.begin();

        try {

            MemberForTwoWay member = new MemberForTwoWay();
            member.setUsername("member3");
            em.persist(member);

            TeamForTwoWay team = new TeamForTwoWay();
            team.setUsername("TeamC");
            team.getMembers().add(member);
            em.persist(team);


            em.flush();
            em.clear();

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
}
