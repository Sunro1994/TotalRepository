package org.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name ="ORDERS") //예약어인 경우가 많아 ORDERS로 사용한다.
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    @Column(name = "MEMBER_ID")
    private Long memberId;

    @ManyToOne
    private Member member;


    //SpringBoot에서는 네이밍 관례를 변경할 수 있다. orderDate -> ORDER_DATE
    //사용하고 있는 규칙을 잘 준수해서 이름을 만들도록 한다.
    //LocalDateTime은 자동으로 맵핑해준다.
    private LocalDateTime orderDate;


    //꼭 STRING을 사용할 것
    @Enumerated(EnumType.STRING)
    private OrderStatus status;




}
