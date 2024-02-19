package com.eazybytes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception { //거부패턴 : /myAccount/** 을 통해 아래 모든 경로도 지정 가능
        http.authorizeHttpRequests((requests) ->
                requests.requestMatchers("/myAccount/**","myBalance","/myLoans","myCards")
                        .authenticated()
                        .requestMatchers("/notices", "contact")
                        .permitAll()
        );
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }
}
