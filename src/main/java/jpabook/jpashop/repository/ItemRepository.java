package jpabook.jpashop.repository;

import jpabook.jpashop.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslPredicate;

/**
 * Created by hyun on 2017-01-15.
 */
public interface ItemRepository extends JpaRepository<Item, Long>, QueryDslPredicateExecutor<Item>{

}
