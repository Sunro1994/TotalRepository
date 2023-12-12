package com.erp.ErpMaster.security.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import java.io.IOException;

//로그인 성공시 작동할 커스텀 핸들러
public class MemberAuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //로그인 서오시 이동할 페이지
        setDefaultTargetUrl("/member/main");

        //로그인 성공시 이동할 페이지로 이동
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
