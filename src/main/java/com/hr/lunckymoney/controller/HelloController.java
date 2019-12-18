package com.hr.lunckymoney.controller;

import com.hr.lunckymoney.entity.LimitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 创建springboot
 */
@RestController
public class HelloController {

    @Autowired
    private LimitConfig limitConfig;

    @GetMapping("/hello")
    public String key(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id){
        /*return "说明:" + limitConfig.getDescription();*/
        return  "id:" + id;
    }
}
