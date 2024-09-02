package com.aop.demo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements  TrafficeFortuneService {

    @Override
    public String getFortune() {

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Expect heavy traffic this morning";
    }

    @Override
    public String getFortune(boolean tripWire) {
        if (tripWire) {
            throw new RuntimeException("MAJOR ACCIDENT!!");
        }

        return getFortune();
    }
}
