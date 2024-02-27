package com.eazybytes.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class CsrfCookieFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        //존재하는 Csrf토큰을 가져온다.
        CsrfToken csrfToken = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        //비어있지 않다면 응답 객체에 헤더와 토큰을 삽입한다.
        if(null != csrfToken.getHeaderName()){
            response.setHeader(csrfToken.getHeaderName(), csrfToken.getToken());
        }
        //filter에 요청과 응답 객체를 넣는다.
        filterChain.doFilter(request, response);

        //쿠키는?
        //개발자가 Csrf토큰을 생성해서 보내면 Security에서는 알아서 쿠키를 브라우저나 UI어플리케이션에 응답 보내느 것을 도와준다.
    }

}
