package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.concurrent.locks.Lock;

public class JpaMain {
    public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();





        tx.begin();

        try {
            Locker locker = new Locker();
            locker.setName("locker1");
            em.persist(locker);

            Member member = new Member();
            member.setUsername("member1");
            member.setLocker(locker);
            em.persist(member);


            Team team = new Team();
            team.setUsername("teamA");
            team.getMembers().add(member);
            em.persist(team);


            Member findMember = em.find(Member.class, member.getId());
            Locker findLocker = findMember.getLocker();
            System.out.println(findLocker.getName());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
}
