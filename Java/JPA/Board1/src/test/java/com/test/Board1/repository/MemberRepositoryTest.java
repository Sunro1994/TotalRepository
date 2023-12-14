package com.test.Board1.repository;

import com.querydsl.core.QueryFactory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.Board1.entity.Board;
import com.test.Board1.entity.Member;
import com.test.Board1.entity.QBoard;
import com.test.Board1.entity.QMember;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Supplier;

import static com.test.Board1.entity.QBoard.*;
import static com.test.Board1.entity.QMember.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberRepositoryTest {

    @Autowired
    EntityManager em;

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    BoardRepository boardRepository;

    JPAQueryFactory queryFactory;

    @BeforeEach
    @Transactional
    public void makeDummy(){

        queryFactory = new JPAQueryFactory(em);

        for (int i = 0; i < 10; i++) {
            Member member = new Member(("user" + i), "1234");
            Board board = new Board(member, ("제목" + i), "내용");
            memberRepository.save(member);
            boardRepository.save(board);

        }

    }

    @Transactional
    @Test
    public void 회원가입(){
        Member member = new Member();
        member.setUserId("유저A");
        member.setUserPw("1234");

        memberRepository.save(member);

    }

    @Test
    @Transactional
    public void 로그인() throws Exception{
    //given
        Member member = new Member();
        member.setUserId("userA");



        member.setUserPw("1234");

        memberRepository.save(member);

        Member findMember = memberRepository.findById(member.getId()).get();

        assertThat(findMember.getUserId()).isEqualTo("userA");
        assertThat(findMember.getUserPw()).isEqualTo("1234");

        }

        @Test
        public void 회원찾기() {
            Member findMember = em.find(Member.class, "1");
            assertThat(findMember.getId()).isEqualTo(1);

        }

        @Test
        public void 회원정보수정(){


            queryFactory
                    .update(member)
                    .where(member.id.eq(1L))
                    .set(member.userId,"수정한Member")
                    .execute();

            Member findMember = em.find(Member.class, 1L);
            System.out.println(findMember.getUserId());

        }

        @Test
        public void 유저목록(){
            List<Member> members = memberRepository.findAll();
            for (Member member : members) {
                System.out.println("member = " + member);
            }

        }

        @Test
    public void 게시판목록(){
            List<Board> all = boardRepository.findAll();
            for (Board board : all) {
                System.out.println("board = " + board);
            }
        }

    public void 게시판제목으로찾기(){
        String search = "제목2";
        List<Board> result = queryFactory
                .selectFrom(board)
                .where(board.title.contains("2"))
                .fetch();

        assertThat(result.get(0)).isEqualTo("제목2");

    }

    @Test
    public void 회원이작성한게시글찾기(){
        Member member = queryFactory
                .selectFrom(QMember.member)
                .where(QMember.member.id.eq(1L))
                .fetchOne();

        System.out.println("member.getId() = " + member.getId());
        Board result = queryFactory
                .selectFrom(board)
                .where(board.member.id.eq(member.getId()))
                .fetchOne();

        assertThat(result.getTitle()).isEqualTo("제목0");
    }







    }


