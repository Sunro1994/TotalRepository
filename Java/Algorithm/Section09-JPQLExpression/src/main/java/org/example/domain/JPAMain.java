package org.example.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JPAMain {

    public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

    EntityManager em = emf.createEntityManager();

    EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Team team2 = new Team();
            team2.setName("teamB");
            em.persist(team2);

            Member member = new Member();
            member.setName("User1");
            member.setTeam(team);
            em.persist(member);

            Member member2 = new Member();
            member2.setName("User2");
            member2.setTeam(team2);
            em.persist(member2);


            em.flush();
            em.clear();

            //joinftecth
            String query = "select distinct m From Member m join fetch m.team";

            List<Member> result = em.createQuery(query, Member.class).getResultList();

            for (Member m : result) {
                System.out.println("member = " + m.getName() + "," + m.getTeam().getName());
            }

            //일반 join을 쓰면 t.list가 초기화가 되지 않는다. 그래서 이후에 다시 list를 조회하게 된다.
            //fetch를 사용하면 연관관계에 있는 엔티티까지 초기화 시켜 준다.(1차 캐시 등록)
            //fetch와 distinct를 함께 사용하면 중복해서 조회하는 것을 막아준다.
            //페치 조인은 객체 그래프에서 묶여있는 것들을 한 번에 가져온다.
            //fetch조인에서는 fetch대상에 별칭을 쓰지 않는다.
            // 유일하게 별칭을 쓸 때 : 조인fetch를 여러 개 써서 연관된것ㅇ르 가져와야 할때 사용한다.
            String query2 = "select distinct t From Team t join fetch t.list";

            List<Team> result2 = em.createQuery(query2, Team.class).getResultList();
            //JPA입장에서는 해당 결과가 어떻게 나올지 모르는 상황에서 할 수 있는게 없기 떄문에 검색 이에외는 할 수 있는게 없다.
            for (Team m : result2) {
                System.out.println("team = " + m.getName() + " members size = " + m.getList().size());
                for (Member mem : m.getList()) {
                    System.out.println("- Member = " + mem.getName());
                }
            }



            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
            emf.close();
        }

    }


}
