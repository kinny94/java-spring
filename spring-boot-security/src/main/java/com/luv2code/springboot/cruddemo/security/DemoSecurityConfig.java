package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        // Use HTTP Basic authentication
        httpSecurity.httpBasic(Customizer.withDefaults());

        // Disable cross-site request forgery (CSRF)
        httpSecurity.csrf(AbstractHttpConfigurer::disable);

        // Define access rules
        httpSecurity.authorizeHttpRequests(configurer ->
                configurer.requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        );

        return httpSecurity.build();
    }
}
