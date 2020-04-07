package com.daojia.study.spring;

import com.daojia.study.spring.service.TradeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xiachao
 * @date 2019/9/25 11:21
 */
public class SpringApplication {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        TradeService tradeService = applicationContext.getBean(TradeService.class);
        tradeService.createTrade();
    }
}
