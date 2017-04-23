package jpabook.jpashop.searchDto;

import jpabook.jpashop.domain.OrderStatus;
import jpabook.jpashop.domain.Orders;
import org.springframework.data.jpa.domain.Specification;

import static jpabook.jpashop.spec.OrderSpec.memberNameLike;
import static jpabook.jpashop.spec.OrderSpec.orderStatusEq;
import static org.springframework.data.jpa.domain.Specifications.where;

/**
 * Created by hyun on 2017-01-15.
 */
public class OrdersSearch {

    private String memberName;

    private OrderStatus orderStatus;

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Specification<Orders> toSpecification() {
        return where(memberNameLike(memberName)).and(orderStatusEq(orderStatus));
    }
}
