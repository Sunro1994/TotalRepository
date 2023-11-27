package org.example.main;

import org.example.domain.Member;
import org.example.domain.MemberType;
import org.example.domain.Team;
import org.example.item.Item;

import javax.persistence.*;
import java.util.List;

public class JPAMain_JPQLTypeExpression {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();


        try {
            Team team = new Team();
            team.setName("teamA");

            em.persist(team);


            Member member = new Member();
            member.setName("teamA");
            member.setAge(10);
            member.setTeam(team);
            member.setType(MemberType.USER);
            em.persist(member);


            //select절에는 문자,숫자,Boolean,Enum ,Entity타입이 올 수 있다.
            //1) 문자
            String query1 = "select 'HELLO' From Member m";
            //2) 숫자
            String query2 = "select 1 From Member m";
            //3) boolean
            String query3 = "select true From Member m";
            //4) Entity
            String query4 = "select m.name From Member m";
            //5) Entity
            String query5 = "select i From Item i where type(i) = Book ";
            //6) Enum
            String query6 = "select m From Member m where m.type= org.example.MemberType.USER";
            //7)Enum2
            String query7 = "select m from Member m where m.type = :userType";

            //TypeQuery : 반환 타입이 명확할 떄 사용, Query는 명확하지 않을 떄 사용
            //1)문자식 결과
            TypedQuery<String> queryString = (TypedQuery<String>) em.createQuery(query1, String.class);
            System.out.println(queryString.getSingleResult());
            System.out.println("===============엔티티결과===================");
            //5) 엔티티 결과
            TypedQuery<Item> queryItem = em.createQuery(query5, Item.class);
            System.out.println("queryItem.getResultList() = " + queryItem.getResultList());

            System.out.println("===============Enum결과===================");
            //6) Enum결과
            TypedQuery<Member> queryMember = em.createQuery(query6, Member.class);
            System.out.println("queryMember = " + queryMember.getSingleResult());

            System.out.println("===============Enum결과2===================");
            //7) Enum 결과2
            List queryMember2 = em.createQuery(query7)
                    .setParameter("userType", MemberType.USER)
                    .getResultList();
            for (Object o : queryMember2) {
                System.out.println("Member = " + o);

            }



            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
            emf.close();
        }



    }
}
