package jpa.springdata.SpringData.controller;

import jpa.springdata.SpringData.dto.MemberDto;
import jpa.springdata.SpringData.entity.Member;
import jpa.springdata.SpringData.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("/member/{id}")
    public String findMember(@PathVariable("id") Long id) {
        Member member = memberRepository.findById(id).get();
        return member.getUsername();
    }
    @GetMapping("/members2/{id}")
    public String findMember2(@PathVariable("id") Member member) {
        return member.getUsername();
    }

    @GetMapping("/members")
    //이렇게 하면 Default설정이 우선권을 갖고 적용해준다.
    public Page<MemberDto> list(@PageableDefault(size = 5) Pageable pageable) {

        PageRequest request = PageRequest.of(1, 2);


        //알아서 pageRequest값을 만들어준다.
        return memberRepository.findAll(pageable).map(MemberDto::new);
        //반환타입이 페이지여서 모든 옵션이 다 출력된다.
    }

    @PostConstruct
    public void init() {
        for (int i = 0; i < 100; i++) {
            memberRepository.save(new Member("user" + i, i));
        }

    }
}
