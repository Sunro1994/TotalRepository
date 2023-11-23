package org.example;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Member {
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @ManyToOne(fetch = FetchType.EAGER)
    // JoinColumn에서 name만 적으면 서로 주인관계가 되기 떄문에 망한다.
    // insertable,updatable을 false로 두면 Team team은 읽기전용매핑이 된다.
    //어찌됐든 다대일 양방향을 사용하자.
    @JoinColumn(name = "TEAM_ID")
    private Team team;


//    @Column(name = "TEAM_ID")
//    private Long teamId;

//    private String createdBy;
//    private LocalDateTime createdDate;
//    private String lastModifiedBy;
//    private LocalDateTime lastModifiedDate;


    }
