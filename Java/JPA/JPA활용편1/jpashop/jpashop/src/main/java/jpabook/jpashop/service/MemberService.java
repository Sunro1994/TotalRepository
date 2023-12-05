package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepositoryOld;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional() //javax가 아니라
//@AllArgsConstructor
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepositoryOld memberRepository; //final로 해두면 컴파일 시점에 체크도 가능하다.


//    @Autowired //메서드를 통해 주입을 하므로 교체가 가능하다. 단점 : 런타임 시점에 누군가가 이걸 바꿀수 있다. 그러므로 생성자 인젝션을 추천
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    //생성자 인젝션이 가장 궁극적인 방법
    //어노테이션을 붙이지 않아도 가능
    //AllArgsConstructor를 사용하면 롬복이 알아서 생서해준다.
    //그것보다 더 좋은것이 RequiredArgsConstructor이다. 알아서 필요한 생성자만 만들어준다.

//    public MemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    /*
    회원가입
     */

    @Transactional
    public Long join(Member member) {
        validateDuplacteMember(member); //중복회원검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplacteMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName()); //동시에 같은 이름으로 가입할 수 있기 때문에 이름에 유니크 제약조건을 걸어주는 것이 좋다. 멀티 쓰레드같은 문제의 동시성떄문
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }

    }

    //회원 전체 조회
    public List<Member> findMembers(){
        return memberRepository.findALl();
    }

    //한건만 조회
    public Member findOne(Long memberId){
        return  memberRepository.findOne(memberId);
    }

    @Transactional
    public void update(Long id, String name) {
        Member member = memberRepository.findOne(id);
        member.setName(name);

    }


    //회원 전체 조회
}
