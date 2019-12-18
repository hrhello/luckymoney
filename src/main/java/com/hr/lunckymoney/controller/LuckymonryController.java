package com.hr.lunckymoney.controller;

import com.hr.lunckymoney.entity.Luckymoney;
import com.hr.lunckymoney.service.LuckymoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class LuckymonryController {

    @Autowired
    private LuckymoneyRepository repository;

    @Autowired
    private LuckymoneyService luckymoneyService;
    /**
     * 获取红包列表
     */
    @GetMapping("/luckymoneys")
    public List<Luckymoney> list() {
        return repository.findAll();
    }

    /**
     * 创建红包(发红包)
     */
    @PostMapping("/createMoney")
    public Luckymoney createMoney(@RequestParam("producer") String producer,
                                  @RequestParam("money")BigDecimal money){
        Luckymoney luckymoney = new Luckymoney();
        luckymoney.setProducer(producer);
        luckymoney.setMoney(money);
        return  repository.save(luckymoney);
    }

    /**
     * 查询红包
     */
    @GetMapping("/findById/{id}")
    public Luckymoney findById(@PathVariable("id") Integer id){
        return repository.findById(id).orElse(null);
    }

    /**
     * 更新红包
     */
    @PostMapping("/update/{id}")
    public Luckymoney update(@PathVariable("id") Integer id,
                             @RequestParam("consumer") String consumer){
        Optional<Luckymoney> optional = repository.findById(id);
        if(optional.isPresent()){
            Luckymoney luckymoney = optional.get();
            luckymoney.setConsumer(consumer);
            return repository.save(luckymoney);
        }
        return null;
    }

    @PostMapping("/luckyMoneys/two")
    public void createTwo(){
        luckymoneyService.createTwo();
    }
}
