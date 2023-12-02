package jpabook.jpashop.api;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.xml.transform.Result;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberApiController {
    private final MemberService memberService;

    @GetMapping("api/v1/members")
    public List<Member> membersV1(){
        //문제점 Entity를 부르게되면 자동적으로 Entity내부정보를 모두 출력하게 된다.
        //이때 Entity에서 보내길 원하지 않는 정보는 @JsonIgnore를 적용하면 된다.
        //하지만 이렇게 적용하면 entity에 표현계층을 위한 영향이 적용되므로 점점 순수한 엔티티가 아니게 된다.

        return memberService.findMembers();
    }

    @GetMapping("api/v2/members")
    public Result memberv2(){
        List<Member> members = memberService.findMembers();
        List<MemberDTO> collect = members.stream()
                .map(i -> new MemberDTO(i.getName()))
                .collect(Collectors.toList());

        return new Result(collect.size(), collect);
    }

    @Data
    @AllArgsConstructor
    static class Result<T>{
        private int count;
        private T data;
    }

    @Data
    @AllArgsConstructor
    static class MemberDTO{
        private String name;
    }

    @PostMapping("api/v1/members")

    public CreateMemberResponse saveMemberV1(@RequestBody @Valid Member member) {

        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }

    @Data
    static class CreateMemberResponse {
        public CreateMemberResponse(Long id) {
            this.id = id;
        }

        private Long id;
    }

    @PostMapping("api/v2/members")
    public CreateMemberResponse saveMember2(@RequestBody @Valid CreateMemberRequest request) {
        Member member = new Member();
        member.setName(request.getName());
        Long id = memberService.join(member);
        return new CreateMemberResponse(id);

    }

    @PutMapping("api/v2/members/{id}")
    public UpdateMemberResponse updateMemberV2(
            @PathVariable("id") Long id,
            @RequestBody @Valid UpdateMemberRequest request) {

        //가급적이면 변경감지를 쓸것
        //아래 두 코드처럼 속성이 다른 코드는 나눠서 만든다.
        memberService.update(id, request.getName());//업데이트 커맨드
        Member findMember = memberService.findOne(id); //쿼리발생

        return new UpdateMemberResponse(findMember.getId(), findMember.getName());
    }

    @Data
    static class CreateMemberRequest {
        private String name;
    }

    @Data
    static class UpdateMemberRequest {
        private Long id;
        private String name;
    }

    @Data
    @AllArgsConstructor
    static class UpdateMemberResponse {
        private Long id;
        private String name;
    }
}
