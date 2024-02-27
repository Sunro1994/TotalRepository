package com.eazybytes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception { //거부패턴 : /myAccount/** 을 통해 아래 모든 경로도 지정 가능
        http.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable()).
                authorizeHttpRequests((requests) ->
                requests.requestMatchers("/myAccount/**","myBalance","/myLoans","myCards")
                        .authenticated()
                        .requestMatchers("/notices", "contact","/register")
                        .permitAll()
        );
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }
/*
*   JDBCUserDetailsManager를 사용하기 위해 주석처리함 더는 계정을 직접 등록하지 않음
* */
    /*@Bean
    public InMemoryUserDetailsManager userDetailService(){
        *//*
        * Approach I where we use withDefaultPasswordEncoder() method while creating the user details
        * *//*


        *//*UserDetails admin = User.withDefaultPasswordEncoder()
            .username("admin")
            .password("12345")
            .authorities("admin")
            .build();

    UserDetails user = User.withDefaultPasswordEncoder()
            .username("user")
            .password("12345")
            .authorities("user")
            .build();

    return new InMemoryUserDetailsManager(admin,user);
    }*//*

    *//*
     * Approach2
     * Where we use NoOpPasswordEncoder Bean while creating the user details
     * *//*

        UserDetails admin = User.withUsername("admin")
                .password("12345")
                .authorities("admin")
                .build();

        UserDetails user = User.withUsername("user")
                .password("12345")
                .authorities("user")
                .build();

        return new InMemoryUserDetailsManager(admin,user);
    }*/

    /**
     * NoOpPasswrodEncoder is not recommnded for production usage.
     * Use only for non-prod.
     *
     * @return PasswordEncoder
     */

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

   /* @Bean
    public UserDetailsService userDetailService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }*/
}
