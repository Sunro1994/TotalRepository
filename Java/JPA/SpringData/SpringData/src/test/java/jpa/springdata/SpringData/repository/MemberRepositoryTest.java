package jpa.springdata.SpringData.repository;

import jpa.springdata.SpringData.dto.MemberDto;
import jpa.springdata.SpringData.entity.Member;
import jpa.springdata.SpringData.entity.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.awt.print.Pageable;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@Rollback(value = false)
@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private MemberRepository memberRepository;
    @PersistenceContext
    EntityManager em;

    @Test
    public void findByUsernameAndAgeGreaterThan() {
        Member m1 = new Member("AAA", 10);
        Member m2 = new Member("AAA", 20);
        memberRepository.save(m1);
        memberRepository.save(m2);
        List<Member> result =
                memberRepository.findByUsernameAndAgeGreaterThan("AAA", 15);
        assertThat(result.get(0).getUsername()).isEqualTo("AAA");
        assertThat(result.get(0).getAge()).isEqualTo(20);
        assertThat(result.size()).isEqualTo(1);
    }

    @Test
    public void testNamedQuery() {
        Member m1 = new Member("AAA", 10);
        Member m2 = new Member("AAA", 20);
        memberRepository.save(m1);
        memberRepository.save(m2);
        List<Member> result =
                memberRepository.findByUsername("AAA");

        Member member = result.get(0);
    }

    @Test
    public void testQuery() {
        Member m1 = new Member("AAA", 10);
        Member m2 = new Member("AAA", 20);
        memberRepository.save(m1);
        memberRepository.save(m2);

        List<Member> result = memberRepository.findUser("AAA", 10);
        assertThat(result.get(0)).isEqualTo("AAA");
    }


    @Test
    public void findUsernameList() {
        Member m1 = new Member("AAA", 10);
        Member m2 = new Member("AAA", 20);
        memberRepository.save(m1);
        memberRepository.save(m2);

        List<String> usernameList = memberRepository.findUsernameList();
        for (String s : usernameList) {
            System.out.println("s = " + s);
        }
    }

    @Test
    public void findMemberDTO() {
        Team team = new Team("teamA");
        teamRepository.save(team);

        Member m1 = new Member("AAA", 10);
        m1.setTeam(team);
        memberRepository.save(m1);


        List<MemberDto> memberDTO = memberRepository.findMemberDTO();
        for (MemberDto memberDto : memberDTO) {
            System.out.println("memberDto = " + memberDto);
        }

    }

    @Test
    public void findByNames() {
        Member m1 = new Member("AAA", 10);
        Member m2 = new Member("BBB", 20);
        memberRepository.save(m1);
        memberRepository.save(m2);

        List<Member> result = memberRepository.findByNames(Arrays.asList("AAA", "BBB"));
        for (Member member : result) {
            System.out.println("member = " + member);
        }
    }

    @Test
    public void returnType() {
        Member m1 = new Member("AAA", 10);
        Member m2 = new Member("AAA", 20);
        memberRepository.save(m1);
        memberRepository.save(m2);

        List<Member> aaa = memberRepository.findListByUsername("AAA");
        for (Member member : aaa) {
            System.out.println("member = " + member);
        }

        //singleResultType은 null이 나온다.
        //그러므로 Optional으로 사용하는게 낫다.
        // 그런게 동일한 값이 두개 이상이라면 Optional이 예외를 발생시킨다.

        Optional<Member> findMember = memberRepository.findOptionByUsername("AAA");
        System.out.println("findMember = " + findMember);


    }

    @Test
    public void paging() {
        memberRepository.save(new Member("member1", 10));
        memberRepository.save(new Member("member2", 10));
        memberRepository.save(new Member("member3", 10));
        memberRepository.save(new Member("member4", 10));
        memberRepository.save(new Member("member5", 10));

        int age = 10;

        PageRequest pageRequest = PageRequest.of(0, 3, Sort.by(Sort.Direction.DESC, "username"));


        //when
        Page<Member> page = memberRepository.findByAge(age, pageRequest);   //해당 엔티티는 절대 그대로 반환하지 말고 DTO를 만들어야 한다.

        //DTO로 변환
        Page<MemberDto> toMap = page.map(member -> new MemberDto(member.getId(), member.getUsername(), null));

        //slice는 totalcount를 받지 않고 limit+1을 가져온다. 다음게 있는지 확인하기 위함
//        Slice<Member> pageSlice = memberRepository.findByAge(age,pageRequest);

        //then
        List<Member> content = page.getContent();
        for (Member member : content) {
            System.out.println("member = " + member);
        }

        long totalElements = page.getTotalElements();
        System.out.println("totalElements = " + totalElements);

        assertThat(content.size()).isEqualTo(3);
        assertThat(page.getTotalElements()).isEqualTo(5);
        assertThat(page.getNumber()).isEqualTo(0);
        assertThat(page.getTotalPages()).isEqualTo(2);
        assertThat(page.isFirst()).isTrue();
        assertThat(page.hasNext()).isTrue();


        System.out.println("=======================================================");
//
//        assertThat(content.size()).isEqualTo(3);
//        assertThat(pageSlice.getNumber()).isEqualTo(0);
//        assertThat(pageSlice.isFirst()).isTrue();
//        assertThat(pageSlice.hasNext()).isTrue();
    }

    @Test
    public void bulkUpdate() {
        //given
        // 벌크성 연산 문제점 : 이 데이터들은 영속성 컨텍스트에 들어있고 DB에 flush되어있지 않는다.
        memberRepository.save(new Member("member1", 10));
        memberRepository.save(new Member("member2", 20));
        memberRepository.save(new Member("member3", 21));
        memberRepository.save(new Member("member4", 41));
        memberRepository.save(new Member("member5", 15));
        memberRepository.save(new Member("member6", 65));

        //when
        int resultCount = memberRepository.bulkAgePlus(20);
//        em.clear(); @Modifying에서 Automaticclaer를 해줘서 자동으로 수행됨
        //모든 정보를 DB에 보내고 컨텍스트 초기화


        //값이 16이 아닌 15로 되어 있다. DB에 있는 값이 아닌 컨텍스트에 있는 값을 가져온것
        List<Member> result = memberRepository.findByUsername("member6");


        Member member = result.get(0);
        System.out.println("member = " + member);
    }

    @Test
    public void findMemberLazy(){
        //given
        //member1 -> TeamA
        //member2 -> TeamB
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        teamRepository.save(teamA);
        teamRepository.save(teamB);


        Member member1 = new Member("member1", 10, teamA);
        Member member2 = new Member("member2", 10, teamB);
        memberRepository.save(member1);
        memberRepository.save(member2);

        em.flush();
        em.clear();
        //완전 영속성 캐시 정보 DB에 flush하고 컨텍스트 초기화
        //member만 찾는 쿼리가 나감
//        List<Member> members = memberRepository.findAll();

        //FetchJOin으로 수행하면 Team객체는 Proxy객체가 아닌 진짜 객체 나가게 된다.
        //객체그래프를 통해 연관된 객체를 모두 가져오는것
        List<Member> members = memberRepository.findMemberFetchJoin();
//      @EntityGraph를 사용해서 fetchJoin사용하기
//        List<Member> members = memberRepository.findEntityGraphByUsername("member1");
        for (Member member : members) {
            System.out.println("member = " + member.getUsername());
            //팀을 갖고 오는데 각 팀을 찾아오는 과정에서 프록시객체를 초기화해줘야하므로 쿼리가 매번 나간다.
            System.out.println("member.getTeam() = " + member.getTeam().getClass()); //프록시 객체로 반환되는것을 알 수 있다.
            System.out.println("member.getTeam().getName() = " + member.getTeam().getName()); //프록시 객체 초기화

            // 이와 같은 문제가 N+1 문제
            // 쿼리를 한 번 실행시켰으나 Team이 2팀이므로 2번 더 쿼리가 나간다.
        }

    }

    @Test
    public  void queryHint(){
        //given
        Member member1 = memberRepository.save(new Member("member1", 10));
        em.flush();
        em.clear();

        //when
        Member findMember = memberRepository.findReadOnlyByUsername("member1");
        findMember.setUsername("member2");
        em.flush();//변경감지로 업데이터쿼리가 나간다.(dirty checking)
        //변경감지의 치명적인 단점 : 비교해야할 원본이 있어야 한다.최소 두개의 데이터가 필요함
        // 그리고 값이 변경되는순간 원하지 않아도 변경이 강제로 된다.
        // 이를 최적화할 수 있는 방법은 hibernate가 제공하고 JPA표준은 제공하지 않는다.
    }

    @Test
    public void lock(){
        //given
        Member member1 = memberRepository.save(new Member("member1", 10));
        em.flush();
        em.clear();

        //when
        List<Member> member11 = memberRepository.findLockByUsername("member1");

    }

    @Test
    public void callCustom(){
        List<Member> memberCustom = memberRepository.findMemberCustom();

    }
}

