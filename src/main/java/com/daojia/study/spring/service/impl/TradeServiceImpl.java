package com.daojia.study.spring.service.impl;

import com.daojia.study.spring.service.TradeService;
import org.springframework.stereotype.Service;

/**
 * @author xiachao
 * @date 2019/10/14 11:26
 */
@Service
public class TradeServiceImpl implements TradeService {
    @Override
    public void createTrade() {
        System.out.println("create trade success");
    }

    @Override
    public void getTradeService() {
        System.out.println("get trade service");
    }
}
