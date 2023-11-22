package org.example.Domain.TwoWay;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class MemberForTwoWay {
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME", nullable = false)
    private String username;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

    //오류가 나는 이유 : 테이블과의 연관관계를 설정해줘야 한다.
    // 연관관계의 주인이다.(Member.team)
    // 다쪽이 무조건 연관관계의 주인이다. many to one 중 many
    // 외래 키가 있는 곳이 주인

    //예시 : 자동차와 자동차 바퀴가 있으면 연관관계의 주인은 바퀴이다.

    @ManyToOne //Many : 멤버  One : 팀
    @JoinColumn(name = "TEAM_ID")
    private TeamForTwoWay team;

    public void changeTeam(TeamForTwoWay team) {
        this.team = team;
        team.getMembers().add(this); //Member에서 이렇게 해주거나 Teanm에서 Member를 추가하든지 둘중 하나만 하면 된다.
    }

}
