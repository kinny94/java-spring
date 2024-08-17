package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails kevin = User.builder()
                .username("kevin")
                .password("{noop}durant")
                .roles("EMPLOYEE")
                .build();

        UserDetails lebron = User.builder()
                .username("lebron")
                .password("{noop}james")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails jalen = User.builder()
                .username("jalen")
                .password("{noop}brunson")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(kevin, lebron, jalen);
    }

}
