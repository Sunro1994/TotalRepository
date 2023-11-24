package org.example;

import javax.persistence.*;
import java.util.List;

public class JpaMainProjection {
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

            em.flush();
            em.clear();



            //Join을 해서 가져와줘야 한다 왜냐하면 그냥 멤버만 출력하면 예측이 되지 않는다.
            //직접적으로 명시해주는것이 좋다.
            List<Team> result =  em.createQuery("select t from Member m join m.team t", Team.class)//타입 정보에 기본적으로 엔티티를 넣는다.
                    .getResultList();

            //임베디드 프로젝션
            //address는 어디든 소속되어 있기 때문에 어디 소속인지 명시해줘야 함
            em.createQuery("select o.address from Order  o", Address.class)//타입 정보에 기본적으로 엔티티를 넣는다.
                    .getResultList();

            //스칼라 프로젝션
            List resultList = em.createQuery("select m.username ,m.age from Member m")//타입 정보에 기본적으로 엔티티를 넣는다.
                    .getResultList();

            //타입이 명시되어 있지 않으니 Object로 사용하는것
            //LIst<Obejct[]> 로 resultList를 명시하면 아래의 과정이 필요없다.
            Object o = resultList.get(0);
            Object[] returning = (Object[]) o;
            System.out.println("username = " + returning[0]);

            //new 명령어로 조회하기
            List<MemberDTO> resultList2 = em.createQuery("select new org.example.MemberDTO(m.username ,m.age) from Member m", MemberDTO.class)
                    .getResultList();//타입 정보에 기본적으로 엔티티를 넣는다.




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
