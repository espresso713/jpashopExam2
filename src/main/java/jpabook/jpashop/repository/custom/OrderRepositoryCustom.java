package jpabook.jpashop.repository.custom;

import jpabook.jpashop.domain.Orders;
import jpabook.jpashop.searchDto.OrdersSearch;

import java.util.List;

/**
 * Created by hyun on 2017-01-18.
 */
public interface OrderRepositoryCustom {
    List<Orders> search(OrdersSearch ordersSearch);
}
