package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepositoryOld;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class) // spring과 인티게이션
@SpringBootTest //spring과 인티게이션
@Transactional //이게 있어야 롤백이 가능
public class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepositoryOld memberRepository;
    @Autowired
    EntityManager em;

    @Test
    @Rollback(false) //익숙해지기 전까지는 , DB에 들어가는게 맞는지 확인하기 전까지는 확인해보기위한 속성값
    public void  회원가입() throws Exception{
    //given
    Member member = new Member();
    member.setName("kim");

    //when
    Long saveId = memberService.join(member);

    //then
        em.flush();
    assertEquals(member, memberRepository.findOne(saveId));

    }

    @Test(expected = IllegalStateException.class) //expected = IllegalStateException.class 를 적으면 알아서 캐치해준다.
    public void 중복회원가입() throws Exception{
    //given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");



    //when

        memberService.join(member1);

        memberService.join(member2); //예외가 발생해야 한다.




    //then
        fail("예외가 발생해야 한다."); //여기까지 오면 잘못된 것

        }
}

