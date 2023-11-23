package org.example;

import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();


        tx.begin();

        try {

            Member member =new Member();
            member.setUsername("hello");

            em.persist(member);

            Member member2 = new Member();
            member2.setUsername("hello2");

            em.persist(member2);
            em.flush();
            em.clear();

////            Member findMember = em.find(Member.class, member.getId());
//            Member findMember = em.getReference(Member.class, member.getId());
//            //getId는 위 코드에서 호출할때 이미 갖고 있기 떄문에 조회를 하지 않는다.
//            System.out.println("findMember = " + findMember.getClass());
//            System.out.println("getId = " + findMember.getId());
//            //하지만 username은 DB에서 가져와야 하기 땜누에 쿼리를 남긴다.
//            System.out.println("getUsername = " + findMember.getUsername());

            Member m1 = em.find(Member.class, member.getId());
            Team team = new Team();
            team.setUsername("team1");
            em.persist(team);
            m1.setTeam(team);
            System.out.println("m1의 타입 : " + m1.getClass());

            Member reference = em.getReference(Member.class, member.getId());
            System.out.println("reference = " + reference.getClass());
            //proxy객체일줄 알았겠지만 아니다. 왜냐하면 jpa에서는 이전에 얻어왔던 m1과 reference는 항상 == 으로 비교했을때 true가 나와야 한다.
//            두 개 모두 하나의 영속성 컨텍스트에서 나왔기 때문 같은 레벨에서 나오기 때문
//            m1을 proxy로 먼저 호출하면 나중에 호출한 reference도 프록시 객체로 반환해버린다. 왜냐하면 영속성 컨텍스트안에서
//            두 개를 일치시켜야 하기 떄문
            System.out.println("a == a : " + (m1 == reference));


            //proxy 예외가 생기는 경우 영속성 컨텍스트가 수행 된 경우에서 수행해야 된다는 내용이다.
            //
            System.out.println("reference = " + m1.getUsername());


            Member m2 = em.getReference(Member.class, member2.getId());
            System.out.println("m2 = " + emf.getPersistenceUnitUtil().isLoaded(m2)); //해당 프록시가 로딩되어있는지확인하는 메서드
            m2.getUsername(); //프록시 강제 초기화하기
            System.out.println("m2 = " + emf.getPersistenceUnitUtil().isLoaded(m2)); //해당 프록시가 로딩되어있는지확인하는 메서드

            //강제 초기화 하는 메서드 위처럼 m2.getUsername을 사용하지 않아도 된다.
            // JPA에서는 강제 초기화가 없기 때문에 위처럼 m2.getUsername을 사요해야 한다.
            Hibernate.initialize(m2);






            //false가 출력되는것을 확인할 수 있다. 타입이 다르기 때문에
            System.out.println(m1 == m2);

            em.flush();
            em.clear();


            List<Member> members = em.createQuery("select m from Member  m", Member.class).getResultList();

            //fetch를 사용하면 하나의 쿼리로 한 방에 가져오게 된다.
            List<Member> members2 = em.createQuery("select m from Member  m join fetch m.team", Member.class).getResultList();




            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }

    private static void logic(Member m1, Member m2) {
        System.out.println("m1 == Member: " + (m1 instanceof Member));
        System.out.println("m2 == Member : " + (m2 instanceof Member));
    }

}
