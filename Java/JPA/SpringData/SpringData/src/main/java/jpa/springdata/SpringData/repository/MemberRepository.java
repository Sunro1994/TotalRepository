package jpa.springdata.SpringData.repository;

import jpa.springdata.SpringData.dto.MemberDto;
import jpa.springdata.SpringData.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import javax.persistence.Entity;
import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

//인터페이스끼리 상속받을때에는 extends를 사용한다.
public interface MemberRepository extends JpaRepository<Member, Long> , MemberRepositoryCustom{


    List<Member> findByUsernameAndAgeGreaterThan(String username, int age);

    //    @Query(name="Member.findByUsername")
//    주석을 해도 알아서 찾아간다. 왜냐하면 일치하는 네임드쿼리를 찾는다. 일치하는 경우 알아서 맵핑되고, 없으면 자동으로 메서드이름으로 쿼리를 생성
//    허지만 잘 안쓰고 SpringDate의 기능중에 하나인 메서드위에 바로 쿼리를 적을 수 있는 기능을 사용한다.
//    NamedQuery의 큰장점 : 순수 JPA쿼리에서는 오타를 컴파일과정에서 잡아주지 못하지만, NamedQuery에서는 해당 쿼리를 컴파일 과정에서 문법오류를 잡아준다.
    List<Member> findByUsername(@Param("username") String username);


    //바로 메서드위에 쿼리작성하기
    //위의 기능들을 잘 사용하지 않는 이유 : 메서드 이름에 적용하는경우 이름이 계속 길어진다.
    @Query("select m from Member  m where m.username = :username and m.age = :age")
    List<Member> findUser(@Param("username") String username, @Param("age") int age);

    //일반 객체 가져오기
    @Query("select m.username from Member m")
    List<String> findUsernameList();

    //DTO가져오기
    //이렇게 하면 DTO로 생성이 가능하다. MemberDTO생성자에 일치하는 값을 넣어준다.
    @Query("select new jpa.springdata.SpringData.dto.MemberDto(m.id,m.username,t.name) from Member m join m.team t")
    List<MemberDto> findMemberDTO();

    //컬렉션 바인딩
    @Query("select m from Member m where m.username in :names")
    List<Member> findByNames(@Param("names") Collection<String> names);

    //반환타입

    List<Member> findListByUsername(String username);//컬렉션

    Member findMemberByUsername(String username); //단건

    Optional<Member> findOptionByUsername(String username); //Optional


    //개발자는 page쿼리를 직접 짜더라도 내가 필요한 쿼리들만 짜면된다 나머지 짜잘한 것들은 JPA가 알아서 해준다.
    //핵심 비즈니스로직에 집중할 수 있게 됨
    @Query(value = "select m from Member m left join m.team t", countQuery = "select count(m) from Member m")
    Page<Member> findByAge(int age, Pageable pageable);

    //findAge2는 작동하지 않는다. age2라는 값이 없기 때문에 findAge로 수정해서 써야함
//    Slice<Member> findByAge(int age, Pageable pageable);

    @Modifying(clearAutomatically = true)
    //Modifying이 있어야 JPA의 ExecuteUpdate를 수행한다. clearAutomatically를 해주면 em.clear를 자동으로 해준다.
    @Query("update Member m set m.age = m.age+1 where m.age>= :age")
    int bulkAgePlus(@Param("age") int age);

    @Query("select m from Member  m left join fetch m.team t")
        //한방 쿼리로 팀까지 한번에 가져온다.
    List<Member> findMemberFetchJoin();

    @Override
    @EntityGraph(attributePaths = {"team"})
    List<Member> findAll();


    @Query("select m from Member m")
//   @EntityGraph(attributePaths ={"team"} )
    @EntityGraph("Member.all")
    List<Member> findMemberEntityGraph();


    @EntityGraph(attributePaths = {"team"})
    List<Member> findEntityGraphByUsername(@Param("username") String username);

    @QueryHints(value =
    @QueryHint(name = "org.hibernate.readOnly", value = "true")) // 변경감지를 무시하고 값을 변경하지 않는다.
    Member findReadOnlyByUsername(String username);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<Member> findLockByUsername(String username);
}


