package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();





        tx.begin();

        try {
            Member member = new Member();
            member.setUsername("member1");
            em.persist(member);

            //팀만 건드린거 같은데 왜 멤버 테이블이 업데이트가 되지? 이런 문제점이 발생
            //JPA를 잘 해도 권장하지 않는다. 수십테이블이 연관되어있는 상황에서 일대다를 사용하게되면 운영이 힘들어진다.
            //일대다가 필요한경우에는 반대인 다대일을 추가해준다.
            //객체지향적으로는 Member에서는 Team으로 갈 일이 없는데 강제로 하나를 만드는것이라 TradeOff이지만
            //조금더 안정적이고 설계방향에 맞게 유지보수가 편한 관계형성이 가능하다.
            Team team = new Team();
            team.setUsername("teamA");
            team.getMembers().add(member);
            em.persist(team);



            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
}
