package jpa.springdata.SpringData.repository;

import jpa.springdata.SpringData.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
