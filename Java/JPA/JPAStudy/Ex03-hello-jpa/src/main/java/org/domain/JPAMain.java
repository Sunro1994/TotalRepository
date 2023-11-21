package org.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
// 객체지향스럽지 못한 코드
            Order order = em.find(Order.class, 1L);
//            Long memberId = order.getMemberId();
//
//            Member member = em.find(Member.class, memberId);

            //참조를 통해 쭉쭉 찾아들어갈 수 있어야 하지만 위 코드는 끊겨버린다.
            Member member = order.getMember();


            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
