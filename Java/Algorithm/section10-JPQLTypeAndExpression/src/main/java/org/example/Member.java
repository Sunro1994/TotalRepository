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

    @ManyToOne(fetch = FetchType.EAGER)
    // JoinColumn에서 name만 적으면 서로 주인관계가 되기 떄문에 망한다.
    // insertable,updatable을 false로 두면 Team team은 읽기전용매핑이 된다.
    //어찌됐든 다대일 양방향을 사용하자.
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    //기간 Peroid
    @Embedded
    private Period workPeroid;


    //주소
    @Embedded
    private Address workAddress;

    //주소
    @Embedded
    @AttributeOverrides({ //Embedded하는 객체가 중복될경우 이와 같은 어노테이션을 사용해준다.
            @AttributeOverride(name = "city",
                    column = @Column(name = "WORK_CITY")),
            @AttributeOverride(name = "street",
                    column = @Column(name = "WORK_STREET")),
            @AttributeOverride(name = "zipcode",
                    column = @Column(name = "WORK_ZIPCODE"))
    })
    private Address homeAddress;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

//    private String createdBy;
//    private LocalDateTime createdDate;
//    private String lastModifiedBy;
//    private LocalDateTime lastModifiedDate;


    }
