package org.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Member {
    //getter,setter를 만들때에는 신중하게 만든다.
    // public으로 생성하기 때문에 접근이 쉽기 때문
    //접근성을 최소한으로 해야 유지보수에 좋다.

    @Id         //Id : 식별자
    @GeneratedValue //생략하면 Auto전략
    @Column(name = "MEMBER_ID") //회사마다 룰이 다르겠지만 DB네이밍 규칙을 잘 준수하도록 한다.
    private Long id;

    @Column(length = 10) //이처럼 직접적으로 명시해줘야 다른 개발자가 바로 참고가 가능하다.
    private String name;
    private String city;
    private String street;
    private String zipcode;


}
