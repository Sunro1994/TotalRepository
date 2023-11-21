package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMainForTableMapping {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            TestPKMapping_Table table = new TestPKMapping_Table();
            table.setUsername("TableUser001");


            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
            emf.close();
    }


}
