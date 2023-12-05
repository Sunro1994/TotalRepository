package jpa.springdata.SpringData.repository;

import jpa.springdata.SpringData.entity.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@Transactional
@ExtendWith(SpringExtension.class)
@Rollback(value = false)
@SpringBootTest
class MemberJpaRepositoryJunit5Test {


    @Autowired
    MemberRepository memberRepository;

    @Test
    public void testMember() {
        Member member = new Member("memberB");
        Member savedMember = memberRepository.save(member);

        Member findMember = memberRepository.findById(member.getId()).get();


        //core클래스를 사용할 것
        assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertTrue(findMember.getId()==1);
        Assertions.assertNull(findMember);

        assertThat(findMember.getUsername()).isEqualTo(member.getUsername());

        assertThat(findMember).isEqualTo(member);//JPA엔티티 동일성 보장


    }
}