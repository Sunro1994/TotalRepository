package jpabook.jpashop.service;

import jpabook.jpashop.domain.Delivery;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;
    /**
     *  주문
     */
    @Transactional
    public Long order(Long memberId, Long itemId, int count){
        //엔티티 조회
        Member member = memberRepository.find(memberId);
        Item item = itemRepository.findOne(itemId);

        //배송정보 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());

        //createOrderItem같은 로직을 하나 딱 정했을경우 다른 방식은 막아야한다.
        OrderItem orederItem = OrderItem.createOrederItem(item, item.getPrice(), count);

        //protected로 다른 로직을 생성할 수 없게 막아놓는 방법이다.
//        OrderItem orderitem1 = new OrderItem();
        //주문
        Order order = Order.createOrder(member, delivery, orederItem);

        //주문 저장
        //주문 상품 생성 OrderItem,Delievery는 오직 Order에서만 참조하기 때문에 이렇게 사용이 가능하다.
        //왜냐하면 cascade:all이 걸려있기 때문에 order만 영속성에 추가하면 연관적으로 생성이 가능하다.
        orderRepository.save(order);
        return order.getId();

    }

    /**
     * 취소
     */
    @Transactional
    public void cancleOrder(Long orderId) {
        //주문 엔터티 조회
        Order order = orderRepository.findOne(orderId);
        //주문 취소
        order.cancel();
        //Dirty Checking 변경내역 감지를 통해 JPA가 알아서 업데이트 쿼리를 날려준다.
    }

    //검색
//    public List<Order> findOrders(OrderSearch orderSearch) {
//        return orderRepository.
//    }
}
