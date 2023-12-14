package com.test.Board1.service;

import com.test.Board1.entity.Member;
import com.test.Board1.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public void join(Member member) {
        memberRepository.save(member);

    }
}
