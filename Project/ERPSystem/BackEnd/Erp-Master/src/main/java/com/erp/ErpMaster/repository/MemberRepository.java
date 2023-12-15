package com.erp.ErpMaster.repository;

import com.erp.ErpMaster.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByLoginId(String username);
}
