package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String s : beanDefinitionNames) {
            Object bean = ac.getBean(s);
            System.out.println("name = " + s + " object = " + bean);
        }
    }

    @Test
    @DisplayName("에플리케이션 빈 션력하기")
    void findApplicationAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String s : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(s);
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(s);
                System.out.println("name = " + s + " object =R " + bean);
            }

        }
    }
}
