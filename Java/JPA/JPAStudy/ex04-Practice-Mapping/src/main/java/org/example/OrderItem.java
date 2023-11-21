package org.example;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ITEM_ID") //Column 이름은 DB이름과 일치시키도록 name 속성을 이용한다. 해당 속성은 연관관계에서도 사용
    private Long id;

//    바람직한 연관관계 맵핑을 위해 주석
//    @Column(name = "ORDER_ID")
//    private Long orderId;
//
//
//    @Column(name = "ITEM_ID")
//    private Long itemId;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;



}
