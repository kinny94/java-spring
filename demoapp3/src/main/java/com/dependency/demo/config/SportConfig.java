package com.dependency.demo.config;

import com.dependency.demo.common.Coach;
import com.dependency.demo.common.SwinCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("customSwimCoachId")
    public Coach swimCoach() {
        return new SwinCoach();
    }
}
