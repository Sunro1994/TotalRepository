package jpa.springdata.SpringData.repository;

import jpa.springdata.SpringData.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

//Repository어노테이션을 넣지 않아도 자동으로 스캔해준다.
public interface TeamRepository extends JpaRepository<Team,Long> {
}
