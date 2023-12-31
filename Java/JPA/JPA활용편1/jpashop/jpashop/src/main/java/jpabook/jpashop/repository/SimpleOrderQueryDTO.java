package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderStatus;
import lombok.Data;
import org.aspectj.weaver.ast.Or;

import java.time.LocalDateTime;

@Data
public class SimpleOrderQueryDTO {

    private  Long orderId;
    private  String name;
    private LocalDateTime orderDate;
    private OrderStatus orderStatus;
    private Address address;

    public SimpleOrderQueryDTO(Long orderId,String name, LocalDateTime orderDate, OrderStatus status, Address address) {
        this.orderId = orderId;
        this.name = name;
        this.orderDate = orderDate;
        this.orderStatus = status;
        this.address = address; 
    }
}
