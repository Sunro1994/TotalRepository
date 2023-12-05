package jpa.springdata.SpringData.repository;

import jpa.springdata.SpringData.entity.Member;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@ExtendWith(SpringExtension.class)
@RunWith(SpringRunner.class)
@Transactional
@Rollback(value = false)
@SpringBootTest
public class MemberRepositoryTest2 {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void testMember(){
        Member member = new Member("memberA");

        Member saveMember = memberRepository.save(member);

    }






}