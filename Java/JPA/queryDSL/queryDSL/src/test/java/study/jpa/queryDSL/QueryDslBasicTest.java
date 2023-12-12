package study.jpa.queryDSL;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import study.jpa.queryDSL.domain.Member;
import study.jpa.queryDSL.domain.QMember;
import study.jpa.queryDSL.domain.Team;
import study.jpa.queryDSL.dto.MemberDto;
import study.jpa.queryDSL.dto.QMemberDto;
import study.jpa.queryDSL.dto.UserDto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

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
        Member member2 = new Member("member2", 20, teamA);
        Member member3 = new Member("member3", 30, teamB);
        Member member4 = new Member("member4", 40, teamB);
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

    @PersistenceUnit
    EntityManagerFactory emf;
    @Test

    public void fetchJoinNo(){
        //fetch조인할때에는 미리 DB에 반영을 해준다.
        em.flush();
        em.clear();

        Member fetchOne = queryFactory
                .selectFrom(member)
                .where(member.username.eq("member1"))
                .fetchOne();

        boolean loaded = emf.getPersistenceUnitUtil().isLoaded(fetchOne.getTeam());
        assertThat(loaded).as("페치 조인 미적용").isFalse();


    }


    @Test

    public void fetchJoininUse(){
        //fetch조인할때에는 미리 DB에 반영을 해준다.
        em.flush();
        em.clear();

        Member fetchOne = queryFactory
                .selectFrom(member)
                .join(member.team, team).fetchJoin() //연관된 객체를 한 쿼리에 끌고 온다.
                .where(member.username.eq("member1"))
                .fetchOne();

        boolean loaded = emf.getPersistenceUnitUtil().isLoaded(fetchOne.getTeam());
        assertThat(loaded).as("페치 조인 미적용").isFalse();
    }


    /**
     * 나이가 가장 많은 회원을 조회
     *
     */
    @Test
    public void subQUery(){

        QMember memberSub = new QMember("memberSub");

        List<Member> result = queryFactory
                .selectFrom(member)
                .where(member.age.eq(JPAExpressions.select(memberSub.age.max()).from(memberSub)))
                .fetch();

        assertThat(result).extracting("age")
                .containsExactly(40);
    }

    /**
     * 나이가 평균 나이 이상인 회원
     */
    @Test
    public void subQueryGoe() throws Exception {
        QMember memberSub = new QMember("memberSub");
        List<Member> result = queryFactory
                .selectFrom(member)
                .where(member.age.goe(
                        JPAExpressions
                                .select(memberSub.age.avg())
                                .from(memberSub)
                ))
                .fetch();
        assertThat(result).extracting("age")
                .containsExactly(30,40);
    }

    /**
     * 서브쿼리 여러 건 처리, in 사용
     */
    @Test
    public void subQueryIn() throws Exception {
        QMember memberSub = new QMember("memberSub");
        List<Member> result = queryFactory
                .selectFrom(member)
                .where(member.age.in(
                        JPAExpressions
                                .select(memberSub.age)
                                .from(memberSub)
                                .where(memberSub.age.gt(10))
                ))
                .fetch();
        assertThat(result).extracting("age")
                .containsExactly(20, 30, 40);

        List<Tuple> fetch = queryFactory
                .select(member.username,
                        JPAExpressions
                                .select(memberSub.age.avg())
                                .from(memberSub)
                ).from(member)
                .fetch();
        for (Tuple tuple : fetch) {
            System.out.println("username = " + tuple.get(member.username));
            System.out.println("age = " +
                    tuple.get(JPAExpressions.select(memberSub.age.avg())
                            .from(memberSub)));
        }
    }


    @Test
    public void basicCase() {
        List<String> fetch = queryFactory
                .select(member.age
                        .when(10).then("열살")
                        .when(20).then("스무살")
                        .otherwise("기타"))
                .from(member)
                .fetch();
        for (String s : fetch) {
            System.out.println("s = " + s);
        }
    }


        @Test
        public void complexCase(){
        //DB가 아닌 application에서 로직을 통해 바꾸거나, 프레젠테이션에서 로직을 짜야 한다.
            List<String> fetch = queryFactory
                    .select(new CaseBuilder()
                            .when(member.age.between(0, 20)).then("0~20살")
                            .when(member.age.between(21, 30)).then("21~40살")
                            .otherwise("기타")
                    ).from(member)
                    .fetch();

            for (String s : fetch) {
                System.out.println("s = " + s);
            }


        }


        @Test
    public void constant() {
            List<Tuple> result = queryFactory
                    .select(member.username, Expressions.constant("A"))
                    .from(member)
                    .fetch();

            for (Tuple tuple : result) {
                System.out.println("tuple = " + tuple);
            }
        }

        @Test
    public void concat(){
        //username_age만들기
            List<String> result = queryFactory
                    .select(member.username.concat("_").concat(member.age.stringValue()))
                    .from(member)
                    .where(member.username.eq("member1"))
                    .fetch();

            for (String s : result) {
                System.out.println("s = " + s);
            }
        }

    @Test
    public void simpleProjection(){
        List<String> result = queryFactory
                .select(member.username)
                .from(member)
                .fetch();

        for (String s : result) {
            System.out.println("s = " + s);
        }
    }

    @Test
    public void tupleProjection(){
        List<Tuple> result = queryFactory
                .select(member.username, member.age)
                .from(member)
                .fetch();

        for (Tuple tuple : result) {
            String username = tuple.get(member.username);
            Integer age = tuple.get(member.age);
            System.out.println("username = " + username);
            System.out.println("age = " + age);
        }


    }

    @Test
    public void findDtoByJPQL(){
        //new Operation방법으로 생성자를 통해 필요한 내용만 DTO에 넣어서 출력
        List<MemberDto> result = em.createQuery("select new study.jpa.queryDSL.dto.MemberDto(m.username, m.age) from Member m", MemberDto.class)
                .getResultList();
        for (MemberDto memberDto : result) {
            System.out.println("memberDto = " + memberDto);
        }
    }


    @Test
    public void findDtoBySetter(){
        List<MemberDto> result = queryFactory
                .select(Projections.bean(MemberDto.class,
                        member.username,
                        member.age))
                .from(member)
                .fetch();

        for (MemberDto memberDto : result) {
            System.out.println("memberDto = " + memberDto);
        }
    }

    //위 메서드와 아래 메서드의 차이
    //위 메서드는 setter를 통해 생성하고 아래 메서드는 필드에 직접 값을 꽂는다.
    @Test
    public void findDtoByField(){
        List<MemberDto> result = queryFactory
                .select(Projections.fields(MemberDto.class,
                        member.username,
                        member.age))
                .from(member)
                .fetch();

        for (MemberDto memberDto : result) {
            System.out.println("memberDto = " + memberDto);
        }
    }

    @Test
    public void findDtoByConstructor(){
        List<MemberDto> result = queryFactory
                .select(Projections.constructor(MemberDto.class, //생성자 생성 방식은 생성자가 요구하는 파라미터의 값과 딱 맞아야한다.
                        member.username,
                        member.age))
                .from(member)
                .fetch();

        for (MemberDto memberDto : result) {
            System.out.println("memberDto = " + memberDto);
        }
    }

    @Test
    //fields, Constructor
    public void findUserDtoByConstructor(){
        List<UserDto> result = queryFactory
                .select(Projections.fields(UserDto.class,
                        member.username.as("name"), //as로 별칭을 정해주면 맵핑이 가능하다.
                        member.age))
                .from(member)
                .fetch();

        for (UserDto userDto : result) {
            System.out.println("userDto = " + userDto);
        }
    }
    @Test
    //fields, Constructor
    public void findUserDto(){
        QMember memberSub = new QMember("memberSub");
        List<UserDto> result = queryFactory
                .select(Projections.fields(UserDto.class,
                        member.username.as("name"), //as로 별칭을 정해주면 맵핑이 가능하다.
                        ExpressionUtils.as(
                                JPAExpressions.
                                    select(memberSub.age.max())
                                    .from(memberSub),"age") //ExpressionUtils를 사용해서 서브쿼리의 결과에 이름을 만들어줄 수 있다.(쿼리문,별명)
                ))
                .from(member)
                .fetch();

        for (UserDto userDto : result) {
            System.out.println("userDto = " + userDto);
        }
    }

    @Test
    //MemberDto에서 생성자에 @QueryProjection을 적용한 후 실행하기
    //이전 프로젝션 방법은 실행 후에야 오류를 발견할 수 있다.
//    하지만 이 방법은 컴파일과정에서 오류를 찾을 수 있기 때문에 바로 잘못된 곳을 찾을 수 있다.
//    단점 : QmemberDto를 어노테이션을 통해 꼭 적용해줘야 한다.
//    MemberDto가 QueryDSL에 대해 의존성을 갖게 된다.
    public void findDtoByQueryProjection(){
        List<MemberDto> reslut = queryFactory
                .select(new QMemberDto(member.username, member.age))
                .from(member)
                .fetch();

        for (MemberDto memberDto : reslut) {
            System.out.println("memberDto = " + memberDto);
        }

    }

    @Test
    public void dynamicQuery_BooleanBuilder(){
        String usernameParam = "member1";
        Integer ageParam = 10;

        List<Member> result = searchMember1(usernameParam, ageParam);
        assertThat(result.size()).isEqualTo(1);
    }


    private List<Member> searchMember1(String usernameCond, Integer ageCond) {

        BooleanBuilder builder = new BooleanBuilder();
        if (usernameCond != null) {
            builder.and(member.username.eq(usernameCond));
        }

        if (ageCond != null) {
            builder.and(member.age.eq(ageCond));
        }


        return queryFactory
                .selectFrom(member)
                .where(builder) //builder로 동적 조건을 생성하고 넣어주기만 하면 null이 아닌 값들만 조건식으로 들어가게 된다.
                .fetch();
    }

    @Test
    public void dynamicQuery_WhereParam(){
        String usernameParam = "member1";
        Integer ageParam = 10;

        List<Member> result = searchMember2(usernameParam, ageParam);
        assertThat(result.size()).isEqualTo(1);

    }

    private List<Member> searchMember2(String usernameCond, Integer ageCond) {
        return queryFactory
                .selectFrom(member)
//                .where(usernameEq(usernameCond), ageEq(ageCond)) //각 메서드에서 null이 들어가면 알아서 무시된다. 메서드로 정리하면 훨씬 깔끔함
                .where(allEq(usernameCond,ageCond)) //두 메서드를 통합한 메서드로 사용가능하지만 null처리는 따로 해줘야한다. 재사용이 가능하다는 장점이 있다. //빼놓을수 있는 메서드는 뺴서 사용한다.
                .fetch();
    }

    private BooleanExpression usernameEq(String usernameCond) {
        if (usernameCond == null) {
            return null;
        }
        return member.username.eq(usernameCond);
    }

    private BooleanExpression ageEq(Integer ageCond) {
        return ageCond != null ? member.age.eq(ageCond) : null;
    }

    private BooleanExpression allEq(String usernameCond, Integer ageCond) {
        return usernameEq(usernameCond).and(ageEq(ageCond));
    }

    @Test
    @Commit //Transactional은 롤백을 시킨다.
    public void bulkUpdate(){

        //member1 = 10 -> 비회원
        //member2 = 20 -> 비회원
        // 3,4는 그대로
        //벌크연산의 문제점 : DB에서는 비회원으로 변경되지만 영속성 컨텍스트는 이전 값이 보존되어 있다.
        // 1차 캐시를 무시하는 점을 해결해야 한다.
        long count = queryFactory
                .update(member)
                .set(member.username, "비회원")
                .where(member.age.lt(28))
                .execute();

        //컨텍스트를 초기화해라! 그러면 해결된다.
        em.flush();
        em.clear();

        List<Member> result = queryFactory
                .selectFrom(member)
                .fetch();

        for (Member member1 : result) {
            System.out.println("member1 = " + member1);
        }
        /*
        결과
        DB보다 영속성컨텍스트가 우선권을 가진다. repeatable Read
        member1 = Member(id=3, username=member1, age=10)
        member1 = Member(id=4, username=member2, age=20)
        member1 = Member(id=5, username=member3, age=30)
        member1 = Member(id=6, username=member4, age=40)
         */
    }

    @Test
    public void bulkAdd(){
        long count = queryFactory
                .update(member)
                .set(member.age, member.age.add(1))
                .execute();
    }

    @Test
    public void bulkDelete(){
        long count = queryFactory
                .delete(member)
                .where(member.age.gt(18))
                .execute();
    }

    @Test
    public void sqlFunction(){
        List<String> result = queryFactory
                .select(Expressions.stringTemplate("function('replace',{0},{1},{2})", member.username, "member", "M")
                ).from(member)
                .fetch();
        for (String s : result) {
            System.out.println("s = " + s);
        }

    }

    @Test
    public void sqlFunction2(){
        List<String> result = queryFactory
                .select(member.username)
                .from(member)
//                .where(member.username.eq(Expressions.stringTemplate("function('lower',{0})", member.username)))
                .where(member.username.eq(member.username.lower()))
                .fetch();

        for (String s : result) {
            System.out.println("s = " + s);
        }
    }



}




