package com.eazybytes.filter;

import com.eazybytes.constants.SecurityConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class JWTTokenGeneratorFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        //인증된 계정을 가져온다.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (null != authentication) {
            //미리 만등러둔 SecurityConstants의 JWT_KEY를 이용하여 키를 생성한다.
            SecretKey key = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes(StandardCharsets.UTF_8));
            //jwt토큰을 생성하는데 발행자와 주제를 적는다. 이는 원하는대로 적어도 된다.
            String jwt = Jwts.builder().issuer("Eazy Bank").subject("JWT Token")
            //username
                    .claim("username", authentication.getName())
            //비밀번호
                    .claim("authorities", populateAuthorities(authentication.getAuthorities()))
            //발행일
                    .issuedAt(new Date())
            //만료일
                    .expiration(new Date((new Date()).getTime() + 30000))
            //디지털 서명
                    .signWith(key).compact();
            //응답의 헤더에 JWT헤더명을 가져와적고 jwt토큰과 함께 보낸다.
            //config.setExposedHeaders(Arrays.asList("Authorization")); COnfig의 이 메서드에 값이 들어가게 된다.
            response.setHeader(SecurityConstants.JWT_HEADER, jwt);
        }

        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {

        return !request.getServletPath().equals("/user"); //오로지 로그인 과정에서만 생성되어야 한다. /user인 경우(로그인 시도)에만 수행되도록
    }

    private String populateAuthorities(Collection<? extends GrantedAuthority> collection) {
        Set<String> authoritiesSet = new HashSet<>();
        for (GrantedAuthority authority : collection) {
            authoritiesSet.add(authority.getAuthority());
        }
        return String.join(",", authoritiesSet);
    }
}
