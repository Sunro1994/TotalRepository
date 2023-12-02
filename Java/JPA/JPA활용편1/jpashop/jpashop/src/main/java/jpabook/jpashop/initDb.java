package jpabook.jpashop;


import jpabook.jpashop.domain.*;
import jpabook.jpashop.domain.item.Book;
import lombok.RequiredArgsConstructor;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class initDb {

    private final InitService initService;
    @PostConstruct
    public void init(){
        initService.dbInit1();
        initService.dbInit2();
    }
    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService{

        private final EntityManager em;
        public void dbInit1(){
            Member member = new Member();
            member.setName("userA");
            member.setAddress(new Address("서울", "1", "1111"));
            em.persist(member);

            Book book = new Book();
            book.setName("JPA1 Book");
            book.setPrice(10000);
            book.setStockQuantity(100);
            em.persist(book);

            Book book2 = new Book();
            book2.setName("JPA1 Book");
            book2.setPrice(10000);
            book2.setStockQuantity(100);
            em.persist(book2);

            OrderItem orderItem = OrderItem.createOrederItem(book, 10000, 1);
            OrderItem orderItem2 = OrderItem.createOrederItem(book2, 10000, 1);

            Delivery delivery = new Delivery();
            delivery.setAddress(member.getAddress());
            Order order = Order.createOrder(member, delivery, orderItem, orderItem2);
            em.persist(order);

        }
        public void dbInit2(){
            Member member = new Member();
            member.setName("userB");
            member.setAddress(new Address("진주", "2", "1111"));
            em.persist(member);

            Book book = new Book();
            book.setName("Spring1 Book");
            book.setPrice(20000);
            book.setStockQuantity(200);
            em.persist(book);

            Book book2 = new Book();
            book2.setName("Spring2 Book");
            book2.setPrice(40000);
            book2.setStockQuantity(300);
            em.persist(book2);

            OrderItem orderItem = OrderItem.createOrederItem(book, 20000, 3);
            OrderItem orderItem2 = OrderItem.createOrederItem(book2, 40000, 4);

            Delivery delivery = new Delivery();
            delivery.setAddress(member.getAddress());
            Order order = Order.createOrder(member, delivery, orderItem, orderItem2);
            em.persist(order);

        }
    }
}
