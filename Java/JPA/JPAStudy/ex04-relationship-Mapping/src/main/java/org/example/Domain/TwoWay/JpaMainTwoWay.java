package org.example.Domain.TwoWay;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMainTwoWay {
    public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();





        tx.begin();

        try {
            TeamForTwoWay team = new TeamForTwoWay();
            team.setUsername("TeamB");
            em.persist(team);

            MemberForTwoWay member = new MemberForTwoWay();
            member.setUsername("member2");
            member.changeTeam(team); //팀과 멤버의 연관관계 맵핑 , JPA가 알아서 연관관계를 알아먹고 pk의 값을 가져온다 **
            em.persist(member);

            team.getMembers().add(member); //해당 코드를 주석으로 달면 아래와 같은 문제가 발생한다. **
//              이렇게 넣어주지 않아도 값이 출력된다.
//              문제점 : em.flush, clear를 주석처리하면 위에서 집어넣은 상태 그대로 1차 캐시에서 가져온다.(메모리에만 들어있는 상태)
//            그렇게 되면 List에는 member가 들어가 있지 않는 상태로 되어 있다.
//            em.flush();
//            em.clear();

            TeamForTwoWay findTeam = em.find(TeamForTwoWay.class, team.getId());
            List<MemberForTwoWay> members = findTeam.getMembers();

            System.out.println("===================");
            for (MemberForTwoWay m : members) {
                System.out.println("m= " + m.getUsername());
            }
            System.out.println("===================");
            System.out.println(members.size()); //flush, clear해주지 않으면 커밋되지 않기 떄문에 이전에 삽입한 값들이 나오지 않는다.
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();

    }
}
