package jpabook.jpashop.spec;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.OrderStatus;
import jpabook.jpashop.domain.Orders;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;

/**
 * Created by hyun on 2017-01-18.
 */
public class OrderSpec {

    public static Specification<Orders> memberNameLike(final String memberName) {
        return new Specification<Orders>() {
            public Predicate toPredicate(Root<Orders> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {

                if( StringUtils.isEmpty(memberName) ) {
                    return null;
                }

                Join<Orders, Member> m = root.join("member", JoinType.INNER);

                return cb.like(m.<String>get("name"), "%" + memberName + "%");
            }
        };
    }

    public static Specification<Orders> orderStatusEq(final OrderStatus orderStatus){
        return new Specification<Orders>() {
            public Predicate toPredicate(Root<Orders> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {

                if( orderStatus == null ) return null;

                return cb.equal(root.get("orderStatus"), orderStatus);
            }
        };
    }

}
