package practice.basic.order;

import org.junit.jupiter.api.Assertions;
import practice.basic.AppConfig;
import practice.basic.member.Grade;
import practice.basic.member.Member;
import practice.basic.member.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    /**
     * 각 테스트 실행시 한번 씩 호출
     */
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }


    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertEquals(1000, order.getDiscount());
    }
}