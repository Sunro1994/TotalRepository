package org.domain;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ITEM_ID") //Column 이름은 DB이름과 일치시키도록 name 속성을 이용한다. 해당 속성은 연관관계에서도 사용
    private Long id;

    @Column(name = "ORDER_ID")
    private Long orderId;


    @Column(name = "ITEM_ID")
    private Long itemId;
}
