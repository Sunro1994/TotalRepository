package study.jpa.queryDSL.domain;

import lombok.*;
import study.jpa.queryDSL.domain.base.BaseEntity;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)//기본생성자 protected
@ToString(of = {"id","username","age"})
public class Member extends BaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;


    private String username;
    private int age;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "team_id")
    Team team;

    public Member(String username, int age, Team team) {
        this.username = username;
        this.age = age;
        if (team != null) {
            changeTeam(team);
        }
    }

    public Member(String teamA) {
        this.username = teamA;
    }

    private void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }





}
