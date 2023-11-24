package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMainPaging {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try{

            for( int i=0 ; i<100; i++){
            Member member = new Member();
            member.setUsername("member"+i);
            member.setAge(i);
            em.persist(member);
            }

            em.flush();
            em.clear();

            //paging에서 orderby를 꼭 넣어야 순서대로 가져와지기 떄문에 필수다.
            //최소 최대값만 정해주면 지정 범위의 인덱스 값을 가져와준다.
            List<Member> resultList = em.createQuery("select m from Member  m order by m.age", Member.class)
                    .setFirstResult(1)
                    .setMaxResults(10)
                    .getResultList();

            System.out.println("result.size =" + resultList.size());
            for (Member member : resultList) {
                System.out.println(member);
            }




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
