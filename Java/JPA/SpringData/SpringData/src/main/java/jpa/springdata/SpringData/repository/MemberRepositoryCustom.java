package jpa.springdata.SpringData.repository;

import jpa.springdata.SpringData.entity.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MemberRepositoryCustom {
    List<Member> findMemberCustom();
}
