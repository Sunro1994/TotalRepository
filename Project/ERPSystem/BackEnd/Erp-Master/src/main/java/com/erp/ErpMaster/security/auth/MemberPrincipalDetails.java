package com.erp.ErpMaster.security.auth;

import com.erp.ErpMaster.member.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//사용자를 담아둘 클래스
public class MemberPrincipalDetails implements UserDetails {

    // member패키지에 선언해놓은 member엔티티 사용
    private final Member member;

    public MemberPrincipalDetails(Member member) {
        this.member = member;
    }

    public Member getMember() {
        return member;
    }


    //member계정의 권한을 담아둠
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority((member.getRole())));
        return authorities;
    }

    //member계정의 비밀번호를 담아둠
    @Override
    public String getPassword() {
        return member.getPassword();
    }

    //member계정의 아이디를 담아둠
    @Override
    public String getUsername() {
        return member.getLoginId();
    }

    //계정이 만료되지 않았는지를 담아두기 위해(true: 만료안됨)
    @Override
    public boolean isAccountNonExpired() {
        return  true;
    }

    //계정이 잠겨있지 않는지 확인(true:잠겨있지 않음)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //계정의 비밀번호가 만료되었는지 확인(true:만료안됨)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //계정이 활성화되었는지 담아둠
    @Override
    public boolean isEnabled() {
        return true;
    }
}
