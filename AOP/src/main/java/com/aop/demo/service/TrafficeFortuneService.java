package com.aop.demo.service;

import org.springframework.stereotype.Service;

public interface TrafficeFortuneService {
    String getFortune();
    String getFortune(boolean tripWire);
}
