package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMainForSeqauenceMapping {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            TestPKMapping_Sequence sequence1 = new TestPKMapping_Sequence();
            TestPKMapping_Sequence sequence2 = new TestPKMapping_Sequence();
            TestPKMapping_Sequence sequence3 = new TestPKMapping_Sequence();
            sequence1.setUsername("SequenceTest01");

            System.out.println("====================================");
            em.persist(sequence1);
            em.persist(sequence2);
            em.persist(sequence3);
            //persist할 때 sequence전략인경우 해당 멤버의 id의 값에 sequence.nextval 값을 넣어준다.
            System.out.println("id : " + sequence1.getId());
            System.out.println("id : " + sequence2.getId());
            System.out.println("id : " + sequence3.getId());
            System.out.println("====================================");

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
            emf.close();
    }


}
