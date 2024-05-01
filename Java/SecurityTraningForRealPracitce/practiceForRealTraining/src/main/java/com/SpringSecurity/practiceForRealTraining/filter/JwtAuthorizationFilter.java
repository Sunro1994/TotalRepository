package com.SpringSecurity.practiceForRealTraining.filter;

import com.SpringSecurity.practiceForRealTraining.ErrorCode;
import com.SpringSecurity.practiceForRealTraining.ProfileApplicationException;
import com.SpringSecurity.practiceForRealTraining.utils.TokenUtils;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.SignatureException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final UserDetailsService userDetailsService;



    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        //1. 토큰이 필요하지 않은 API URL에 대해 배열로 구성
        List<String> list = Arrays.asList(
                "/user/login",
                "/login",
                "/css/**"
                ,"/js/**"
                ,"/images/**"
        );

        //2. 토큰이 필요하지 않은 API URL의  경우 로직 처리 없이 다음 필터로 이동
        if (list.contains(request.getRequestURI())) {
            filterChain.doFilter(request, response);
            return;
        }

        //3. OPTIONS 요청일 경우 -> 로직 처리 없이 다음 필터로 이동
//
//        if (request.getMethod().equalsIgnoreCase("OPTIONS")) {
//            filterChain.doFilter(request,response);
//            return;
//        }

        //[step1] Client에서  API를 요청할때 쿠키를 확인
        Cookie[] cookies = request.getCookies();
        String token =null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("jwt".equals(cookie.getName())) {
                    token = cookie.getValue();
                    break;
                }
            }
        }

        try {
            //[step2] 쿠키 내에 토큰 존재 시
            if (token != null && !token.equalsIgnoreCase("")) {
                //[step2-1] 쿠키 내에 있는 토큰이 유효한지 여부 검사
                if (TokenUtils.isValidToken(token)) {

                    //[step2-2] 추출한 토큰 기반으로 사용자 아이디를 반환받음
                    String loginId = TokenUtils.getUserIdFromToken(token);
                    log.debug("[+]loginId Check : " + loginId);

                    //[Step 2-3] 사용자 아이디가 존재하는지 여부 체크
                    if (loginId != null && !loginId.equalsIgnoreCase("")) {
                        UserDetails userDetails = userDetailsService.loadUserByUsername(loginId);
                        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                        filterChain.doFilter(request, response);
                    } else {
                        throw new ProfileApplicationException(ErrorCode.USER_NOT_FOUND);
                    }
                    //토큰이 유효하지 않는 경우
                } else {
                    throw new ProfileApplicationException(ErrorCode.TOKEN_NOT_VALID);
                }
                //토큰이 존재 하지 않는 경우
            } else {
                throw new ProfileApplicationException(ErrorCode.TOKEN_NOT_FOUND);
            }
        } catch (Exception e) {
            String logMessage = jsonResponseWrapper(e).getString("message");
            log.error(logMessage, e);

            //클라이언트에게 전송할 고정 메시지
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");

            PrintWriter printWriter = response.getWriter();
            JSONObject jsonpObject = new JSONObject();
            try {
                jsonpObject.put("error", true);
                jsonpObject.put("message","로그인 에러");

                printWriter.print(jsonpObject);
                printWriter.flush();
                printWriter.close();
            } catch (JSONException ex) {
                throw new RuntimeException(ex);
            }


        }



    }

    /**
     * 토큰 관련 Exception 발생 시 예외 응답값 구성
     */
    private JSONObject jsonResponseWrapper(Exception e) {

        String resultMessage = "";
        // JWT 토큰 만료
        if (e instanceof ExpiredJwtException) {
            resultMessage = "TOKEN Expired";
        }
        // JWT 허용된 토큰이 아님
        else if (e instanceof SignatureException) {
            resultMessage = "TOKEN SignatureException Login";
        }
        // JWT 토큰내에서 오류 발생 시
        else if (e instanceof JwtException) {
            resultMessage = "TOKEN Parsing JwtException";
        }
        // 이외 JTW 토큰내에서 오류 발생
        else {
            resultMessage = "OTHER TOKEN ERROR";
        }

        HashMap<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("status", 401);
        jsonMap.put("code", "9999");
        jsonMap.put("message", resultMessage);
        jsonMap.put("reason", e.getMessage());
        JSONObject jsonObject = new JSONObject(jsonMap);
        log.error(resultMessage, e);
        return jsonObject;
    }
}
