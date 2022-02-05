package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StatelessServiceTest {

    static class TestConfig {
        @Bean
        public StatelessService statelessService() {
            return new StatelessService();
        }
    }

    @Test
    void statelessServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatelessService statefulService1 = ac.getBean("statelessService", StatelessService.class);
        StatelessService statefulService2 = ac.getBean("statelessService", StatelessService.class);

        //ThreadA: A사용자 10000원 주문
        int userA = statefulService1.order("userA", 10000);
        //ThreadB: B사용자 20000원 주문
        int userB = statefulService2.order("userB", 20000);

        //ThreadA: 사용자A 주문 금액 조회
        //ThreadA: 사용자A는 10000원을 기대했지만, 기대와 다르게 20000원 출력
        System.out.println("price = " + userA);

        assertThat(userA).isEqualTo(10000);
    }
}