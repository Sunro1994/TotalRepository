package org.example.domain;

import lombok.Data;
import org.example.item.Item;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Data
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;


    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="item_id")
    private Item item;


    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice;
    private int count;

}
