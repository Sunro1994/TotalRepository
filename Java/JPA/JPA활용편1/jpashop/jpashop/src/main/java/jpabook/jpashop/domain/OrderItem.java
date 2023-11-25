package jpabook.jpashop.domain;

import jpabook.jpashop.domain.item.Item;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "orderItem_id")
    private Long id;


    @ManyToOne
    @JoinColumn(name="item_id")
    private Item item;


    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice;
    private int count;

}
