package jpabook.jpashop.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jpabook.jpashop.domain.item.Item;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Or;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderItem {
    //롬복 어노테이션으로 막을 수 있음
//    protected OrderItem() {
//    }

    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;


    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="item_id")
    private Item item;


    @JsonIgnore
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice;
    private int count;

    //비즈니스 로직//
    public void cancel() {
        getItem().addStock(count);
    }

    //조회 로직//

    /**'
     * 주문상품 가격 전체 조회
     */
    public int getTotalPrice() {
        return getOrderPrice() * getCount();
    }


    //==생성==//
    public static OrderItem createOrederItem(Item item, int orderPrice, int count) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setOrderPrice(orderPrice);
        orderItem.setCount(count);

        item.removeStock(count);
        return orderItem;
    }

}
