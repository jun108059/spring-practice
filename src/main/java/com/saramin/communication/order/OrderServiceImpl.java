package com.saramin.communication.order;

import com.saramin.communication.discount.DiscountPolicy;
import com.saramin.communication.discount.FixDiscountPolicy;
import com.saramin.communication.member.Member;
import com.saramin.communication.member.MemberRepository;
import com.saramin.communication.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}