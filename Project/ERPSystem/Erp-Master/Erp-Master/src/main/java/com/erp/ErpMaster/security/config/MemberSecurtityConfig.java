package com.erp.ErpMaster.security.config;

import com.erp.ErpMaster.security.auth.MemberPrincipalDetailService;
import com.erp.ErpMaster.security.auth.MemberPrincipalDetails;
import com.erp.ErpMaster.security.provider.MemberAuthenticationProvider;
import com.querydsl.core.annotations.Config;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class MemberSecurtityConfig {
    /**
     * spring Security 5.7.0버전부터
     * WebSecurityConfiguraterAdapter가 deprecated되기 때문에
     * 아래와 같은 방법으로 구현된다.
     */

    //생성해둔 MemberAutenticationProvider를 주입받는다.
    //해당 클래스로 MemberPrincipalDetailsService내부 로직을 수행한다.
    //인증 처리도 같이 진행된다.
    @Autowired
    MemberAuthenticationProvider memberAuthenticationProvider;

    //로그인 기억을 위해 MemberAuthenticatorProvider 내부 MemberPrincipalDetailService선언
    @Autowired
    MemberPrincipalDetailService memberPrincipalDetailService;

    //in memory방식으로 인증 처리를 진행하기 위해 기존엔 Override하여 구현했지만
    //5.7.0버전 부터는 AuthenticationManagerBuilder를 직접 생성하여
    //AuthenticationManager를 생성해야 한다.

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(memberAuthenticationProvider);
    }

    //5.7.0부터 오버라이드 하지 않고 직접 FilterChain을 생성하여 구현
    //그 외 autherizeRequetst가 deprecated되었기 때문에
    //authorizerHttpRequests로 변경
    @Bean
    public SecurityFilterChain memberSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable());

        http.authorizeHttpRequests(authorize -> {
            try {
                authorize
                        .requestMatchers("/css/**", "/images/**", "/js/**", "member/attachment/**", "/member/files/**")
                        .permitAll()//해당 경로는 인증 없이 접근 가능
                        .requestMatchers("/member/**") //해당 경로는 인증이 필요
                        .hasRole("MEMBER"); //ROLE이 MEMBER가 포함된 경우에만 인증 가능

                http.formLogin(httpSecurityFormLoginConfigurer -> httpSecurityFormLoginConfigurer
                        .loginPage("/member/login/loginForm")
                        .loginProcessingUrl("/member/login/loginForm")
                        .loginProcessingUrl("/member/login/login")
                        .defaultSuccessUrl("/member/main")//로그인 성공 후 이동할 페이지
                        .failureHandler(new MemberAuthFailureHandler()).permitAll());

                http.logout(httpSecurityLogoutConfigurer -> httpSecurityLogoutConfigurer
                        .logoutUrl("/member/login/logout")//로그아웃 처리 URL 설정
                        .logoutSuccessUrl("/member/login/loginForm?loguout=1") //로그아웃 성공 후 이도 ㅇ페이지
                        .deleteCookies("JSESSIONID")); //로그아웃 후 쿠키 삭제)



                http.rememberMe(httpSecurityRememberMeConfigurer -> httpSecurityRememberMeConfigurer
                        .key("surno")//인증 토큰 생성시 사용할 키
                        .tokenValiditySeconds(60*60*24*7)   //인증 토큰 유효 시간
                        .userDetailsService(memberPrincipalDetailService)   //인증 토큰 생성 시 사용하 ㄹuserDetailService
                        .rememberMeParameter("remember-me"));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });



        return http.build();

    }
}


