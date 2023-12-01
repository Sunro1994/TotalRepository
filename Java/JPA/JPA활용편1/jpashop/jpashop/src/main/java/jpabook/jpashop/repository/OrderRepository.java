package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Order;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private  final EntityManager em;

    public void save(Order order) {
        em.persist(order);
    }

    public Order findOne(Long id){
        return em.find(Order.class, id);
    }

//    검색 로직 나중에 설명할 예정
    public List<Order> findAllByString(OrderSearch orderSerach){
        String jpql = "select o from Order o join o.member m";

        boolean isFirstCondition = true;
        //주문 상태 검색
        if (orderSerach.getOrderStatus() != null) {
            if (isFirstCondition) {
                jpql += "where";
                isFirstCondition = false;
            } else {
                jpql += "and";
            }
            jpql += "o.status = :status";
        }

        if (StringUtils.hasText(orderSerach.getMemberName())) {
            if (isFirstCondition) {
                jpql += "where";
                isFirstCondition = false;
            } else {
                jpql += "and";
            }
            jpql += "m.name like :name";
        }

        TypedQuery<Order> query = em.createQuery(jpql, Order.class).setMaxResults(1000);

        if (orderSerach.getOrderStatus() != null) {
            query = query.setParameter("status", orderSerach.getOrderStatus());
        }
        if (StringUtils.hasText(orderSerach.getMemberName())) {
            query = query.setParameter("name", orderSerach.getMemberName());
        }
        //첫번째방법
        //동적쿼리를 생성할떄 위처럼 매우 불편하다 그래서 마이바티스를 사용하기도 함


        return query.getResultList();



    }

    //JPQL을 자바 코드로 작성하게 표준으로 제공하는 방법 사용하기

    /**
     * JPA Criteria
     * 치명적인 단점이 존재해서 잘 쓰지 않는다.
     * 유지보수성이 0다. 가독성이 떨어짐
     * @return
     */
    public List<Order> findAllByCriteria(OrderSearch orderSearch) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Order> cq = cb.createQuery(Order.class);
        Root<Order> o = cq.from(Order.class);
        Join<Object, Object> m = o.join("member", JoinType.INNER);

        List<Predicate> criteria = new ArrayList<>();

        //주문 상태 검색
        if (orderSearch.getOrderStatus() != null) {
            Predicate status = cb.equal(o.get("status"), orderSearch.getOrderStatus());
            criteria.add(status);
        }

        if (StringUtils.hasText(orderSearch.getMemberName())) {
            Predicate name =
                    cb.like(m.get("name"), "%" + orderSearch.getMemberName() + "%");
            criteria.add(name);
        }

        cq.where(cb.and(criteria.toArray(new Predicate[criteria.size()])));
        TypedQuery<Order> query = em.createQuery(cq).setMaxResults(1000);
        return query.getResultList();
    }



}
