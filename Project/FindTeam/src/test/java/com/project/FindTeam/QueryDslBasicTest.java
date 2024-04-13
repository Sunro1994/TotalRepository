package com.project.FindTeam;

import com.project.FindTeam.model.ProjectMember;
import com.project.FindTeam.model.QProjectMember;
import com.project.FindTeam.model.QUser;
import com.project.FindTeam.model.User;
import com.querydsl.core.QueryFactory;
import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Queue;

import static com.project.FindTeam.model.QProjectMember.*;
import static com.project.FindTeam.model.QUser.*;
import static org.assertj.core.api.Assertions.*;


@Transactional
@SpringBootTest
public class QueryDslBasicTest {

    @Autowired
    private EntityManager em;





    @BeforeEach
    @Transactional
    public void before(){


        ProjectMember teamA = new ProjectMember("teamA");
        ProjectMember teamB = new ProjectMember("teamB");
        em.persist(teamA);
        em.persist(teamB);

        User user = new User("member1", 10, teamA);
        User user2 = new User("member2", 20, teamA);
        User user3 = new User("member3", 30, teamB);
        User user4 = new User("member4", 40, teamB);

        em.persist(user);
        em.persist(user2);
        em.persist(user3);
        em.persist(user4);
        em.flush();
    }

        @Test
        public void startJPQL(){
            //member를 찾기
            User member1 = em.createQuery("select u from User u where u.name = :name", User.class)
                    .setParameter("name", "member1")
                    .getSingleResult();
            assertThat(member1.getName()).isEqualTo("member1");

        }

        @Test
    public void startQueryDsl(){
             JPAQueryFactory queryFactory = new JPAQueryFactory(em);

            User findMember = queryFactory
                    .select(user)
                    .from(user)
                    .where(user.name.eq("member1"))
                    .fetchOne();

            assertThat(findMember.getName()).isEqualTo("member1");

        }

        @Test
    public void search(){
            JPAQueryFactory queryFactory = new JPAQueryFactory(em);

            User findMember = queryFactory
                    .select(user)
                    .from(user)
                    .where(user.name.eq("member1").and(user.age.eq(10)))
                    .fetchOne();

            assertThat(findMember.getName()).isEqualTo("member1");
            assertThat(findMember.getAge()).isEqualTo(10);



        }

        @Test
        public void resultFetch() {
            JPAQueryFactory queryFactory = new JPAQueryFactory(em);

            List<User> userList = queryFactory
                    .selectFrom(user).fetch();


            User firstUser = queryFactory
                    .selectFrom(user)
                    .fetchFirst();

            long total = queryFactory
                    .selectFrom(user)
                    .fetchCount();

            System.out.println(total);


        }

        @Test
    public void sort(){
            JPAQueryFactory queryFactory = new JPAQueryFactory(em);

            List<User> userList = queryFactory
                    .selectFrom(user)
                    .where(user.age.gt(10))
                    .orderBy(user.age.desc(), user.name.asc().nullsLast())
                    .fetch();

            User user1 = userList.get(0);
            User user2 = userList.get(1);
            User user3 = userList.get(2);

            assertThat(user1.getName()).isEqualTo("member4");
            assertThat(user2.getName()).isEqualTo("member3");
            assertThat(user3.getName()).isEqualTo("member2");
        }

        @Test
    public void paging() {
            JPAQueryFactory qf = new JPAQueryFactory(em);

            List<User> userList = qf.selectFrom(user)
                    .orderBy(user.name.asc())
                    .offset(1)
                    .limit(2)
                    .fetch();

            QueryResults<User> userQueryResults = qf.selectFrom(user)
                    .orderBy(user.name.asc())
                    .offset(1)
                    .limit(2)
                    .fetchResults();

            assertThat(userList.size()).isEqualTo(2);

            assertThat(userQueryResults.getTotal()).isEqualTo(4);
            assertThat(userQueryResults.getLimit()).isEqualTo(2);
            assertThat(userQueryResults.getOffset()).isEqualTo(1);
            assertThat(userQueryResults.getResults().size()).isEqualTo(2);
            //카운트가 자동으로 나가기 때문에 단순하면 그냥 사용하면 되지만 복잡한 경우에는 따로 두번 호출하는것이 효율적이다.


        }

        @Test
    public void aggregation(){
            JPAQueryFactory qf = new JPAQueryFactory(em);

            List<Tuple> result = qf.select(
                            user.count(),
                            user.age.sum(),
                            user.age.avg(),
                            user.age.max(),
                            user.age.min()
                    ).from(user)
                    .fetch();

            Tuple tuple = result.get(0);
            assertThat(tuple.get(user.count())).isEqualTo(4);

        }

        @Test
    public void group() {
            JPAQueryFactory qf = new JPAQueryFactory(em);

            List<Tuple> fetch = qf
                    .select(projectMember.name, user.age.avg())
                    .from(user)
                    .join(user.projectMember, projectMember)
                    .groupBy(projectMember.name)
                    .fetch();

            Tuple teamA = fetch.get(0);
            Tuple teamB = fetch.get(1);

            assertThat(teamA.get(projectMember.name)).isEqualTo("teamA");
            assertThat(teamA.get(user.age.avg())).isEqualTo(15);
        }




}
