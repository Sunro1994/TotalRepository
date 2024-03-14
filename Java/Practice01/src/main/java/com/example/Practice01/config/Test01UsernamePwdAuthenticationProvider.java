package com.example.Practice01.config;

import com.example.Practice01.model.User;
import com.example.Practice01.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Test01UsernamePwdAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private CustomerRepository cusotmRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        List<User> user = cusotmRepository.findByName(username);
        if (user.size() > 0) {
            if (passwordEncoder.matches(pwd, user.get(0).getPassword())) {
                List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority(user.get(0).getRole()));
                return new UsernamePasswordAuthenticationToken(username, pwd, authorities);
            }
            throw new BadCredentialsException("invalid password");
        } else {
            throw new BadCredentialsException("No user registered with this details!");
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
