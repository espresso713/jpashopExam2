package jpabook.jpashop.repository.custom;

import jpabook.jpashop.domain.Member;

import java.util.List;

/**
 * Created by hyun on 2017-01-18.
 */
public interface MemberRepositoryCustom {
    List<Member> findMemberCustom();
}
