package com.practice.repository;

import com.practice.entity.Member;
import com.querydsl.core.QueryFactory;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
@ExtendWith(SpringExtension.class)
public class MemberRepositoryTest {



    private EntityManager em;

    private MemberRepository memberRepository;


    @Test
    @Transactional
    public void 회원가입(){
        Member member = new Member();
        member.setUserId("memberA");
        member.setUserPw("1234");
        memberRepository.save(member);

    }

}