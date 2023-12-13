package study.jpa.queryDSL.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.jpa.queryDSL.dto.MemberSearchCondition;
import study.jpa.queryDSL.dto.MemberTeamDto;
import study.jpa.queryDSL.repository.MemberJpaRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberJpaRepository memberJpaRepository;

    @GetMapping("/v1/members")
    public List<MemberTeamDto> searchMemberV1(MemberSearchCondition condition){

        return memberJpaRepository.search(condition);
    }
}
