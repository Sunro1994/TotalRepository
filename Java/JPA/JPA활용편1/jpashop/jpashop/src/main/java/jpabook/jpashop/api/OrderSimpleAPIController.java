package jpabook.jpashop.api;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderStatus;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.repository.OrderSearch;
import jpabook.jpashop.repository.SimpleOrderQueryDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * xToOne(ManyToOne, OneToOne) 성능 최적화
 * Order
 * Order -> Member
 * Order ->  Delivery
 */
@RestController
@RequiredArgsConstructor
public class OrderSimpleAPIController {
    private final OrderRepository orderRepository;

    @GetMapping("/api/v1/simple-orders")
    public List<Order> orderV1() {

        List<Order> all = orderRepository.findAllByString(new OrderSearch());
        for (Order order : all) {
            //order.getMember까지는 프록시객체지만 getName을 하는 순간 Lazy가 강제 초기화가 된다.
            order.getMember().getName();
            order.getDelivery().getAddress();
        }

        //이렇게 실행하면 무한 루프에 걸리게된다.
        //원인 : Order에서 Member에들어가거 Member에 있는 Order에 들어가며 오버스택플로우
        //해결법 : 한 쪽을 JsonIgnore로 해준다.
        return all;
    }


    //꼭 DTO로 변환해서 API를 사용할것
    //문제점 : LAZY로딩으로 결과적으로 3개의 테이블을 조회해야한다.
    // N + 1 문제점 발생 ==> 1+ N(멤버) + N(배송)
    @GetMapping("api/v2/simple-orders")
    public List<SimpleOrderDTO> oorderV2() {
        List<Order> order = orderRepository.findAllByString(new OrderSearch());
        List<SimpleOrderDTO> result = order.stream()
                .map(o -> new SimpleOrderDTO(o))
                .collect(Collectors.toList());

        return result;
    }

    //v3는 재사용성이 있다. 비즈니스 로직을 변경해서 데이터를 변경 가능
    //Entity 속성이 유지가 된다.
    @GetMapping("api/v3/simple-orders")
    public List<SimpleOrderDTO> oorderV3() {

        List<Order> orders = orderRepository.findWithMemberRepository();

        List<SimpleOrderDTO> result = orders.stream().map(o -> new SimpleOrderDTO(o))
                .collect(Collectors.toList());

        return result;
    }

    //v4는 재사용성이 없다. 해당 DTO로만 사용할 수 있기 때문 , 변경할 수 없음
    //이 코드는 API에 의존적이다. Entity의 순수함을 잃음
    // 성능은 조금 더 좋지만 v3와 크게 차이가 있지는 않다.
    //레포지터리는 순수한 객체를 조회하거나 삭제하는 정도로만 쓴다.
    @GetMapping("/api/v4/simple-orders")
    public List<SimpleOrderQueryDTO> ordersv4(){
        return  orderRepository.findOrderDTOs();
    }



    @Data
    @RequiredArgsConstructor

    public static class SimpleOrderDTO {

        private Long orderId;
        private String name;
        private LocalDateTime orderDate;
        private OrderStatus orderStatus;
        private Address address;

        public SimpleOrderDTO(Order o) {
            orderId = o.getId();
            name = o.getMember().getName(); //LAZY초기화 : 영속성 컨텍스트에서 찾아보고 없으면 DB를 찾는다.
            orderDate = o.getOrderDate();
            orderStatus = o.getStatus();
            address = o.getDelivery().getAddress();
        }

    }
}
