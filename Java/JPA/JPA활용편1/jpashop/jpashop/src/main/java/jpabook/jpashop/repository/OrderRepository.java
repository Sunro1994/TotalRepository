package jpabook.jpashop.repository;

import jpabook.jpashop.api.OrderSimpleAPIController;
import jpabook.jpashop.domain.Order;
import lombok.Data;
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


    public List<Order> findWithMemberRepository() {
        return em.createQuery(
                        "select o from Order o" +
                                " join fetch o.member m" +
                                " join fetch o.delivery d", Order.class)
                .getResultList();
    }

    //되도록 로직은 한방향으로 향해야한다.
    public List<SimpleOrderQueryDTO> findOrderDTOs() {
        List<SimpleOrderQueryDTO> resultList = em.createQuery("select new jpabook.jpashop.repository.SimpleOrderQueryDTO(o.id, m.name, o.orderDate, o.status, d.address)" +
                        " from Order o " +
                        "join o.member m " +
                        "join o.delivery d", SimpleOrderQueryDTO.class)
                .getResultList();

        return resultList;

    }

    public List<Order> findAllWIthItem() {
        return em.createQuery(
                //JPA의 distinct는 DB의 distinct와 비슷하지만 한가지를 더 해준다.
                //Entity가 중복인 경우에 중복을 걸러서 컬렉션에 담아 준다.
                "select distinct o from Order  o " +
                        "join fetch  o.member " +
                        "join fetch  o.delivery " +
                        "join fetch  o.orderItems oi" +
                        " join fetch  oi.item i", Order.class)
                .setFirstResult(1)      //2023-12-05 02:02:34.105  WARN 9304 --- [nio-8080-exec-2] o.h.h.internal.ast.QueryTranslatorImpl   : HHH000104: firstResult/maxResults specified with collection fetch; applying in memory!
                .setMaxResults(100)    //메모리에서 페이징 처리를 한다는 뜻, 데이터에 있는 모든 데이터를 메모리에 올린다는 뜻. 만개면 만개를 다 올린다.
                .getResultList();       //1대 다에서 컬렉션 페치조인에서는 페이징을 함부로 사용해선 안된다.
                                        //또한 컬렉션 2개 이상에서 페치 조인을 하면 데이터가 부정합하게 조회된다.
    }

    public List<Order> findAllWIthMemberDelivery() {
        return em.createQuery(
                        //JPA의 distinct는 DB의 distinct와 비슷하지만 한가지를 더 해준다.
                        //Entity가 중복인 경우에 중복을 걸러서 컬렉션에 담아 준다.
                        "select distinct o from Order  o " +
                                "join fetch  o.member " +
                                "join fetch  o.delivery "
                               , Order.class)
                .setFirstResult(1)
                .setMaxResults(100)
                .getResultList();
    }

    public List<Order> findAllWIthMemberDelivery(int offset, int limit) {
        return em.createQuery(
                        //JPA의 distinct는 DB의 distinct와 비슷하지만 한가지를 더 해준다.
                        //Entity가 중복인 경우에 중복을 걸러서 컬렉션에 담아 준다.
                        "select distinct o from Order  o " +
                                "join fetch  o.member " +
                                "join fetch  o.delivery "
                        , Order.class)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }
}
