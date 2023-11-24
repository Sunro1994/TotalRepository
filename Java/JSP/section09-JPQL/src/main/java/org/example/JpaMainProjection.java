package org.example;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try{

            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            em.persist(member);

            // :username을 통해 일치하는 컬럼을 가져올 수 있다.
            // 이름 기반만 쓰고 ?1 처럼 숫자 기반으로는 사용하지 않는다.
            TypedQuery<Member> query = em.createQuery("select m from Member m where m.username = :username", Member.class);//타입 정보에 기본적으로 엔티티를 넣는다.
            query.setParameter("username", "member1");
//            TypedQuery<Member> queryUsinNumber = em.createQuery("select m from Member m where m.username = ?1", Member.class);//타입 정보에 기본적으로 엔티티를 넣는다.
//            query.setParameter(1, "member1");
            Member singleResult1 = query.getSingleResult();
            System.out.println("singleResult1 = " + singleResult1);
            List<Member> resultList = query.getResultList(); //결과가 하나 이상일때

            TypedQuery<Member> query2  = em.createQuery("select m from Member m where m.age>100", Member.class);//타입 정보에 기본적으로 엔티티를 넣는다.
            //결과가 하나인게 확정일때 , 결과가 없거나 둘 이상이면 예외가 생긴다.
            //Spring DataJPA 에서는 Optional이나 null로 알아서 처리해준다.
            Member singleResult = query.getSingleResult();


            TypedQuery<String> query3 = em.createQuery("select m.username from Member m", String.class);//타입 정보가 운시형이면 그에 맞춰준다.
            Query query1 = em.createQuery("select m.username, m.age from Member m");//타입 정보를 받을 수 없을 떄  Query를 사용한다.
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
