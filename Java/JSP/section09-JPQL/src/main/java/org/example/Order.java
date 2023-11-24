package org.example;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private int orderAmount;


    @Embedded
    private Address address;

//    @ManyToOne
//    @JoinColumn(name = "member_id")
//    private Member member;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
