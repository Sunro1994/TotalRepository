package org.example;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Member extends BaseEntity{
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @ManyToOne
    // JoinColumn에서 name만 적으면 서로 주인관계가 되기 떄문에 망한다.
    // insertable,updatable을 false로 두면 Team team은 읽기전용매핑이 된다.
    //어찌됐든 다대일 양방향을 사용하자.
    @JoinColumn(name = "TEAM_ID",insertable = false,updatable = false)
    private Team team;

    @OneToOne
    @JoinColumn(name="LOCKER_ID")       //연관관계의 주인을 Member로 지정하는게 좋다. Member가 다른 관계도 연관지어지기 때문에 Member에서 Locker를 갖고 가는게 편하다. 대신 양방향으로 지정해줘야함
    private Locker locker;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

//    private String createdBy;
//    private LocalDateTime createdDate;
//    private String lastModifiedBy;
//    private LocalDateTime lastModifiedDate;


    }
