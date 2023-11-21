package org.example.Domain.OneWay;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class MemberForOneWaySolveProblem {
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME", nullable = false)
    private String username;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

    //오류가 나는 이유 : 테이블과의 연관관계를 설정해줘야 한다.
    @ManyToOne //Many : 멤버  One : 팀
    @JoinColumn(name = "TEAM_ID")
    private TeamForOneWay team ;

    }
