package jpabook.jpashop.api;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;
import jpabook.jpashop.domain.OrderStatus;
import jpabook.jpashop.repository.OrderRepository;
import jpabook.jpashop.repository.OrderSearch;
import jpabook.jpashop.repository.order.query.OrderFlatDto;
import jpabook.jpashop.repository.order.query.OrderItemQueryDTO;
import jpabook.jpashop.repository.order.query.OrderQueryDTO;
import jpabook.jpashop.repository.order.query.OrderQueryRepository;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.stream.Collectors.*;


@RestController
@RequiredArgsConstructor
public class OrderApiController {

    private final OrderRepository orderRepository;
    private final OrderQueryRepository orderQueryRepository;


    //무한루프를 막기 위해 양방향에서 한쪽에 JSONIgnore를 적용해준다.
    //하지만 되도록 엔티티를 노출하는 로직은 사용하지 않는다.
    @GetMapping("api/v1/orders")
    public List<Order> ordersV1() {
        List<Order> all = orderRepository.findAllByString(new OrderSearch());
        for (Order order : all) {
            order.getMember().getName();            //지연 로딩 발생 - 프록시 객체 생성
            order.getDelivery().getAddress();       //자연 로딩 발생
            List<OrderItem> orderItems = order.getOrderItems();
            orderItems.stream().forEach(o -> o.getItem().getName());
        }
        return all;

    }

    //문제점 지연로딩으로 각 객체를 초기화 할때마다 쿼리문이 나간다.
    @GetMapping("api/v2/orders")
    public List<OrderDTO> ordersV2(){
        List<Order> orders = orderRepository.findAllByString(new OrderSearch());
        List<OrderDTO> collect = orders.stream()
                .map(OrderDTO::new)
                .collect(toList());

        return collect;
    }

    @GetMapping("api/v3/orders")
    public List<OrderDTO> ordersV3(){
        List<Order> orders = orderRepository.findAllWIthItem();
        List<OrderDTO> collect = orders.stream()
                .map(OrderDTO::new)
                .collect(toList());

        return collect;
    }

    @GetMapping("api/v3.1/orders")
    public List<OrderDTO> ordersV3_page( @RequestParam(value = "offset",defaultValue = "0")int offset,
                                         @RequestParam(value = "limit",defaultValue = "100")int limit
    ){
        List<Order> orders = orderRepository.findAllWIthMemberDelivery(offset,limit);
        List<OrderDTO> collect = orders.stream()
                .map(OrderDTO::new)
                .collect(toList());

        return collect;
    }

    @GetMapping("api/v4/orders")
    public List<OrderQueryDTO> ordersV4(){
        return orderQueryRepository.findOrderQueryDtos();

    }

    @Data
    public class OrderDTO {

        private Long orderId;
        private String name;
        private LocalDateTime orderDate;
        private OrderStatus orderStatus;
        private Address address;

        private List<OrderItemDTO> orderItems;


        public OrderDTO(Order o) {
            orderId = o.getId();
            name = o.getMember().getName();
            orderDate = o.getOrderDate();
            orderStatus = o.getStatus();
            address = o.getDelivery().getAddress();
            o.getOrderItems().stream().forEach(x -> x.getItem().getName());
            orderItems = o.getOrderItems().stream()
                    .map(orderItem -> new OrderItemDTO(orderItem))
                    .collect(toList());
        }
    }

    @Getter
    static class OrderItemDTO{

        private String itemName;
        private  int orderPrice;
        private  int count;

        public OrderItemDTO(OrderItem orderItem) {
            itemName = orderItem.getItem().getName();
            orderPrice = orderItem.getOrderPrice();
            count = orderItem.getCount();
        }
    }

    @GetMapping("/api/v6/orders")
    public List<OrderQueryDTO> ordersV6() {
        List<OrderFlatDto> flats = orderQueryRepository.findAllByDto_flat();
        return flats.stream()
                .collect(groupingBy(o -> new OrderQueryDTO(o.getOrderId(), o.getName(), o.getOrderDate(), o.getOrderStatus(), o.getAddress()),
                        mapping(o -> new OrderItemQueryDTO(o.getOrderId(),
                                o.getItemName(), o.getOrderPrice(), o.getCount()), toList())
                )).entrySet().stream()
                .map(e -> new OrderQueryDTO(e.getKey().getOrderId(), e.getKey().getName(), e.getKey().getOrderDate(), e.getKey().getOrderStatus(),
                        e.getKey().getAddress(), e.getValue()))
                .collect(toList());
    }
}

