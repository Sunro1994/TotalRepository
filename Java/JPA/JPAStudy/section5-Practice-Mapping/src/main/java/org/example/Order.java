package org.example;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name ="ORDERS") //예약어인 경우가 많아 ORDERS로 사용한다.
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

//    바람직한 연관관계를 위해 memberid는 주석처리하고 Member객체를 연관짓는다.
//    @Column(name = "MEMBER_ID")
//    private Long memberId;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID") //Member_ID 컬럼과 조인, reference 관계
    private Member member;


    //SpringBoot에서는 네이밍 관례를 변경할 수 있다. orderDate -> ORDER_DATE
    //사용하고 있는 규칙을 잘 준수해서 이름을 만들도록 한다.
    //LocalDateTime은 자동으로 맵핑해준다.
    private LocalDateTime orderDate;


    //꼭 STRING을 사용할 것
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    //주문서를 중심으로 어떤 주문을 했는지 알아야 할 필요가 있기 때문에 양방향 설계가 필요하다는 판단
    //외래키를 갖고 있는 대상의 변수이름을 넣어준다.
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();


    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);

    }
}
