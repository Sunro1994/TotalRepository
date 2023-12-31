package study.jpa.queryDSL.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.jpa.queryDSL.dto.MemberSearchCondition;
import study.jpa.queryDSL.dto.MemberTeamDto;
import study.jpa.queryDSL.repository.MemberJpaRepository;
import study.jpa.queryDSL.repository.MemberRepository;
import study.jpa.queryDSL.repository.MemberRepositoryCustom;
import study.jpa.queryDSL.repository.MemberRepositoryImpl;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberJpaRepository memberJpaRepository;
    private final MemberRepository  memberRepository;


    @GetMapping("/v1/members")
    public List<MemberTeamDto> searchMemberV1(MemberSearchCondition condition) {

        return memberJpaRepository.search(condition);
    }


    @GetMapping("/v2/members")
    public Page<MemberTeamDto> searchMemberV2(MemberSearchCondition condition, Pageable pageable) {
        return memberRepository.searchPageSimple(condition, pageable);
    }

    @GetMapping("/v3/members")
    public Page<MemberTeamDto> searchMemberV3(MemberSearchCondition condition,
                                              Pageable pageable) {
        return memberRepository.searchPageComplex(condition, pageable);
    }
}
