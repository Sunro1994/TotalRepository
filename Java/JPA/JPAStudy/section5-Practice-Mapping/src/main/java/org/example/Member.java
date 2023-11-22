package org.example;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Member {

    @Id         //Id : 식별자
    @GeneratedValue //생략하면 Auto전략
    @Column(name = "MEMBER_ID") //회사마다 룰이 다르겠지만 DB네이밍 규칙을 잘 준수하도록 한다.
    private Long id;

    @Column(length = 10) //이처럼 직접적으로 명시해줘야 다른 개발자가 바로 참고가 가능하다.
    private String name;
    private String city;
    private String street;
    private String zipcode;

    //Member에서 Order 양방향 설계가 필요한가?
    // Order에서 member조인을 통해서 주문을 확인하면 되지 굳이 Member로 다시 돌아와서 orders를 호출 할 필요는 없으므로
    // 양방향 설계는 바람직하지 않다. 필요성을 고려하고 끊어낼 곳은 끊어내는 것이 좋다.

    @OneToMany(mappedBy = "member") //member가 연관관계의 주인이기 때문에 맵핑해준다.
    private List<Order> orders = new ArrayList<>();

}
