package org.example;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Team  {


    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    @Column(name = "name")
    private String username;

    @OneToMany
    @JoinColumn(name = "TEAM_ID") //일대다의 주인인 Team에서 JoinColumn을 꼭 넣어줘야한다. 그렇지 않으면 조인 테이블이라는 전략으로 동작하게된다.
//    @JoinTable joinTable은 중간테이블을 만들어 두 테이블의 pk와 fk를 가져온다.
//    사실상 다대일을 중점적으로 쓰게 때문에 권장하지 않는 방법
    private List <Member> members = new ArrayList<>();

}
