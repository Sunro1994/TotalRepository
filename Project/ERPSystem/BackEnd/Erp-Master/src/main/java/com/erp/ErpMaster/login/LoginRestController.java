package com.erp.ErpMaster.login;

import com.erp.ErpMaster.member.Member;
import com.erp.ErpMaster.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginRestController {

    @Autowired
    MemberRepository memberRepository;

    @PostMapping("/api/login")
    public Long login(@RequestBody Map<String,String> params) {
        Member member = memberRepository.findByLoginId(params.get("userid"));
        if (member != null) {
            System.out.println("정상 수신");
            return member.getId();
        }
        System.out.println("정상수신되지 않음");
        return 0L;
    }
}
