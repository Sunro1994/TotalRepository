package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMainForIdentityMapping {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            TestPKMapping_Identity identity = new TestPKMapping_Identity();
            identity.setUsername("PKTester01");

            System.out.println("============호출 전 ========");
            em.persist(identity);
            System.out.println("======SQL 커밋 이후 값 출력 identity.id =" + identity.getId());
            /*중요한 포인트

                persist로 insert를 날려봐야 pk값을 알 수 있기 때문에 persist를 수행할 경우 즉시 SQL이 수행되고
                영속성 컨텍스트에 값이 들어가있다.
                Identity만 이러한 상황이 발생된다.

             */

            System.out.println("===========호출 후=========");

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
            emf.close();
    }


}
