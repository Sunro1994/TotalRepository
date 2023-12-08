package study.jpa.queryDSL;

import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.jpa.queryDSL.domain.Member;
import study.jpa.queryDSL.domain.QMember;
import study.jpa.queryDSL.domain.QTeam;
import study.jpa.queryDSL.domain.Team;

import javax.persistence.EntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static study.jpa.queryDSL.domain.QMember.*;
import static study.jpa.queryDSL.domain.QTeam.team;

@SpringBootTest
@Transactional

public class QueryDslBasicTest{

    @Autowired
    EntityManager em;


    JPAQueryFactory queryFactory;

    @BeforeEach
    public void before(){
        queryFactory = new JPAQueryFactory(em); //필드로 뺄 수 있다. 동시성 문제도 해결 가능
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        em.persist(teamA);
        em.persist(teamB);

        Member member1 = new Member("member1", 10, teamA);
        Member member2 = new Member("member2", 10, teamA);
        Member member3 = new Member("member3", 10, teamB);
        Member member4 = new Member("member4", 10, teamB);
        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);
    }

    @Test
    public void startJPQL(){
        //우선 JPQL로 작성하고 QueryDSL로 변경하는걸 확인하기




        //member1을 찾아라
        Member findMember = em.createQuery("select m from Member m where m.username = :username", Member.class)
                .setParameter("username", "member1")
                .getSingleResult();

        assertThat(findMember.getUsername()).isEqualTo("member1");
    }

    @Test
    public void startQueryDsl(){
        //생성하는 두가지 방법
//        첫번째 : 직접 호출하기
//        QMember m = member;
//        QMember m = new QMember("m");
        QMember m1 = new QMember("m1");


        //QueryDSL은 자동으로 jdbc에 있는 preparestatement로 멤버타입을 알아서 잡아준다.
        //기본적으로 파라미터 바인딩을 해준다.
        //PrepareStatement이기 때문에 SQLInjection 회피 가능
        //compile하는 과정에서 미리 예외,오타들을 알려주기 때문에 사용자가 수행하는 단계가 아닌 개발자의 코드 구현과정에서 캐치가 가능하다.
        Member findMember = queryFactory
                .select(member) //두번째 생성방법, static임포트로 바로 사용가능(Qmember.member) 이 방법을 권장한다.
                .from(member)
                .where(member.username.eq("member1")) //파라미터 바인딩 처리
                .fetchOne();


        Member findMember2 = queryFactory
                .select(m1)
                .from(m1)
                .where(m1.username.eq("member1")) //파라미터 바인딩 처리
                .fetchOne();

        assertThat(findMember.getUsername()).isEqualTo("member1");
    }

    @Test
    public void search(){
        Member findMember = queryFactory
                .selectFrom(member)
                .where(member.username.eq("member1").and(member.age.eq(10)))
                .fetchOne();

        assertThat(findMember.getUsername()).isEqualTo("member1");
    }

    @Test
    public void searchAndParam(){
        Member findMember = queryFactory
                .selectFrom(member)
                .where(
                        member.username.eq("member1"), //and 대신 ,로 사용할 수 있다.
                        (member.age.eq(10)))
                .fetchOne();

        assertThat(findMember.getUsername()).isEqualTo("member1");
    }

    @Test
    public void resultFetch(){
//        List<Member> fetch = queryFactory
//                .selectFrom(member)
//                .fetch();
//
//        queryFactory
//                .selectFrom(member)
//                .fetchOne();
//
//        Member fetchFirst = queryFactory
//                .selectFrom(member)
//                .fetchFirst();

        QueryResults<Member> results = queryFactory
                .selectFrom(member)
                .fetchResults();

        results.getTotal();
        List<Member> content = results.getResults();

        queryFactory
                .selectFrom(member)
                .fetchCount();
    }

    /**
     * 회원 정렬순서
     * 1. 회원 나이 내림차순(desc)
     * 2. 회원 이름 올림차순(asc)
     * 3. 단 2에서 회원 이름이 없으면 마지막에 출력(null list)
     */
    @Test
    public void sort(){
        em.persist(new Member(null,100));
        em.persist(new Member("member5",100));
        em.persist(new Member("member6",100));

        List<Member> result = queryFactory
                .selectFrom(member)
                .where(member.age.eq(100))
                .orderBy(member.age.desc(), member.username.asc().nullsLast())
                .fetch();

        Member member5 = result.get(0);
        Member member6 = result.get(1);
        Member memberNull    = result.get(2);
        assertThat(member5.getUsername()).isEqualTo("member5");
        assertThat(member6.getUsername()).isEqualTo("member6");
        assertThat(memberNull.getUsername()).isNull();
    }

    @Test
    public void paging1(){
        List<Member> result = queryFactory
                .selectFrom(member)
                .orderBy(member.username.desc())
                .offset(1)
                .limit(2)
                .fetch();

        QueryResults<Member> results = queryFactory
                .selectFrom(member)
                .orderBy(member.username.desc())
                .offset(1)
                .limit(2)
                .fetchResults();
        assertThat(result.size()).isEqualTo(2);

        assertThat(results.getTotal()).isEqualTo(4);
        assertThat(results.getLimit()).isEqualTo(2);
        assertThat(results.getOffset()).isEqualTo(1);
        assertThat(results.getResults().size()).isEqualTo(2);
    }

    @Test
    public void aggreagation(){
        Tuple tuple = queryFactory
                .select(
                        member.count(),
                        member.age.sum(),
                        member.age.avg(),
                        member.age.max(),
                        member.age.min()
                )
                .from(member)
                .fetchOne();

        assertThat(tuple.get(member.count()));
        assertThat(tuple.get(member.age.sum())).isEqualTo(100);
        assertThat(tuple.get(member.age.avg())).isEqualTo(10);
        assertThat(tuple.get(member.age.max())).isEqualTo(10);
        assertThat(tuple.get(member.age.min())).isEqualTo(10);
    }

    /**
     * 팀의 이름과 각 팀의 평균 연령을 구해라.
     * @throws Exception
     */
    @Test
    public void group() throws Exception{

        List<Tuple> result = queryFactory
                .select(team.name, member.age.avg())
                .from(member)
                .join(member.team, team)
                .groupBy(team.name) //뒤에 having을 추가해서 조건을 넣어줄 수 있따.
                .fetch();

        Tuple teamA = result.get(0);
        Tuple teamB = result.get(1);

        assertThat(teamA.get(team.name)).isEqualTo("teamA");
        assertThat(teamA.get(member.age.avg())).isEqualTo(10);



        }

        @Test
    public void join(){
            List<Member> result = queryFactory
                    .selectFrom(member)
                    .join(member.team, team)
                    .where(team.name.eq("teamA"))
                    .fetch();

            assertThat(result)
                    .extracting("username")
                    .containsExactly("member1", "member2");
        }


    /**
     * 세타조인
     */
    @Test
    public void theta_join(){
        em.persist(new Member("teamA"));
        em.persist(new Member("teamB"));

            List<Member> results= queryFactory
                    .selectFrom(member)
                    .from(member, team)
                    .where(member.username.eq(team.name))
                    .fetch();

            assertThat(results)
                    .extracting("username")
                    .containsExactly("teamA", "teamB");

        }

    /**
     * 예) 회원과 팀을 조인하면서, 팀 이름이 teamA인 팀만 조인, 회원은 모두 조회
     * JPQL : select m,t  from Member m left join m.team t on t.name = "teamA"
     */
    @Test
    public void join_on_filtering(){
        List<Tuple> results = queryFactory
                .select(member, team)
                .from(member)
                .leftJoin(member.team, team).on(team.name.eq("teamA")).fetch(); //where에 조건문을 거는 것과 동일하다. 정말 외부조인이 필요한 경우에만 사용하면된다.

        for (Tuple result : results) {
            System.out.println("result = " + result);
        }

    }

    //연관관계가 없는 엔티티 외부 조인
//    회원의 이름과 팀 이름이 가은 대상 외부 조인
    @Test
    public void theta_join_on_no_relation(){
        em.persist(new Member("teamA"));
        em.persist(new Member("teamB"));
        em.persist(new Member("teamC"));

        List<Tuple> result = queryFactory
                .select(member,team)
                .from(member)
                .leftJoin(team).on(member.username.eq(team.name))
                .fetch();

        for (Tuple tuple : result) {
            System.out.println("tuple = " + tuple);
        }


    }


    }

