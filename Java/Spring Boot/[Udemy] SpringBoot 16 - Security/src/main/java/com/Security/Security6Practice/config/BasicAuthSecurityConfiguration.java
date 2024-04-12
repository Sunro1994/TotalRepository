package com.Security.Security6Practice.config;

import com.Security.Security6Practice.User.Roles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

//@Configuration
public class BasicAuthSecurityConfiguration {

    @Bean
    SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                (requests) ->
                        requests.anyRequest().authenticated()
        );
        //Always : 항상 세션 생성, never: 세션 생성하지않지만 이미 있는 경우 사용
        //if_required: 필요 시에만 세션 생성  , stateless : 사용 안함
        http.sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        http.csrf((csrf) -> csrf.disable());
        return http.build();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("*")
                        .allowedOrigins("http://localhost:3000");
            }
        };
    }

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource){
        //InMemoryUserDetailsManager는 UserDetailsManager의 비지속적 구현
        var user = User.withUsername("sunro")
//                .password("{noop}12345")
                .password("12345")
                .passwordEncoder(str-> passwordEncoder().encode(str))
                .roles(String.valueOf(Roles.USER))
                .build();
        var user2 = User.withUsername("daro")
                //                .password("{noop}12345")
                .password("12345")
                .passwordEncoder(str-> passwordEncoder().encode(str))
                .roles(String.valueOf(Roles.ADMIN))
                .build();

        var jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.updateUser(user);
        jdbcUserDetailsManager.updateUser(user2);
        return jdbcUserDetailsManager;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }




}
