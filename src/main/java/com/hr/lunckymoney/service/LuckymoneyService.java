package com.hr.lunckymoney.service;

import com.hr.lunckymoney.controller.LuckymoneyRepository;
import com.hr.lunckymoney.entity.Luckymoney;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class LuckymoneyService {

    @Autowired
    private LuckymoneyRepository repository;

    /**
     * 事务 指数据库的事务
     * 扣库存 > 创建订单
     */
    @Transactional
    public void createTwo(){
        Luckymoney lucky = new Luckymoney();
        lucky.setProducer("黄哈哈");
        lucky.setMoney(new BigDecimal("520"));
        repository.save(lucky);

        Luckymoney luckyTwo = new Luckymoney();
        luckyTwo.setProducer("黄哈哈");
        luckyTwo.setMoney(new BigDecimal("1314"));
        repository.save(luckyTwo);
    }
}
