package study.jpa.queryDSL.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import study.jpa.queryDSL.domain.Member;
import study.jpa.queryDSL.dto.MemberSearchCondition;
import study.jpa.queryDSL.dto.MemberTeamDto;

import java.util.List;

public interface MemberRepositoryCustom {
    List<MemberTeamDto> search(MemberSearchCondition condition);

    Page<MemberTeamDto> searchPageSimple(MemberSearchCondition condition, Pageable pageable);
    Page<MemberTeamDto> searchPageComplex(MemberSearchCondition condition, Pageable pageable);


}
