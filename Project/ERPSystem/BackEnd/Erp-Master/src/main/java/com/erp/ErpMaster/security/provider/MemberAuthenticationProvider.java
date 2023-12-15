package com.erp.ErpMaster.security.provider;

import com.erp.ErpMaster.member.Member;
import com.erp.ErpMaster.security.auth.MemberPrincipalDetailService;
import com.erp.ErpMaster.security.auth.MemberPrincipalDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
//AuthenticationProvider를 구현한 클래스
public class MemberAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private MemberPrincipalDetailService memberPrincipalDetailService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName(); //사용자가 입력한 ID
        String password = (String) authentication.getCredentials(); //사용자가 입력한 패스워드

        //생성해둔 MemberPrincipalDetailService에서 loadUserByUsername메소드를 호출하여 사용자 정보를 가져온다.
        MemberPrincipalDetails memberPrincipalDetails = (MemberPrincipalDetails) memberPrincipalDetailService.loadUserByUsername(username);

        //=============비밀번호 비교하기====================
        //사용자가 입력한 pw와DB에 저장된pw를 비교

        //db에 저장된 pw
        String dbPassword = memberPrincipalDetails.getPassword();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        if (!passwordEncoder.matches(password, dbPassword)) {
            System.out.println("[사용자]비밀번호가 일치하지 않습니다.");
            throw new BadCredentialsException("[사용자]아이디 또는 비밀번호가 일치하지 않습니다.");
        }
        //============================================

        //사용자가 입력한 id와 pw가 일치하면 인증 성공
        //인증이 성공하면 MemberPrinciaplDetails객체를 반환
        Member member = memberPrincipalDetails.getMember();
        if (member == null || "N".equals(member.getIsUsed())) {
            System.out.println("[사용자] 사용할 수 없는 계정입니다.");
            throw new BadCredentialsException("[사용자] 사용할 수 없는 계정입니다.");
        }

        //인증이 성공하면 UsernamePasswordAuthenticationToken객체를 반환
        //해당 객체는 Authentication 객체로 추후 인증이 끝나고 SecurityContextHolder.getContext()에 저장된다.
        return new UsernamePasswordAuthenticationToken(memberPrincipalDetails, null, memberPrincipalDetails.getAuthorities());

    }

    @Override
    public boolean supports(Class<?> authentication) {

        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
