package jpabook.jpashop.repository.custom;

import com.mysema.query.jpa.JPQLQuery;
import jpabook.jpashop.domain.Orders;
import jpabook.jpashop.domain.QMember;
import jpabook.jpashop.domain.QOrders;
import jpabook.jpashop.searchDto.OrdersSearch;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by hyun on 2017-01-18.
 */
public class OrderRepositoryImpl extends QueryDslRepositorySupport implements OrderRepositoryCustom {

    public OrderRepositoryImpl() {
        super(Orders.class);
    }

    public List<Orders> search(OrdersSearch ordersSearch) {

        QOrders order = QOrders.orders;
        QMember member = QMember.member;

        JPQLQuery query = from(order);

        if(StringUtils.hasText(ordersSearch.getMemberName())) {
            query.leftJoin(order.member, member)
                    .where(member.name.contains(ordersSearch.getMemberName()));
        }

        if(!StringUtils.isEmpty(ordersSearch.getOrderStatus())) {
            query.where(order.orderStatus.eq(ordersSearch.getOrderStatus()));
        }

        return query.list(order);
    }
}
