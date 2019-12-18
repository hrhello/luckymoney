package com.hr.lunckymoney.controller;


import com.hr.lunckymoney.entity.Luckymoney;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LuckymoneyRepository extends JpaRepository<Luckymoney,Integer> {
}
