package org.example;

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

            Order order = new Order();

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            //양방향 연관관계는 jpql을 작성할 떄 조회를 편하게 하기 위해 작성하는 편

            em.persist(orderItem);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
