package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Orders;
import jpabook.jpashop.repository.custom.OrderRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by hyun on 2017-01-15.
 */
public interface OrderRepository extends JpaRepository<Orders, Long>, JpaSpecificationExecutor<Orders>, OrderRepositoryCustom{

}
