package com.example.Practice01.controller;

import com.example.Practice01.model.User;
import com.example.Practice01.model.UserRole;
import com.example.Practice01.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public ResponseEntity<?> hello(){
        return ResponseEntity.ok().body("ok");
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        User savedUser = null;
        ResponseEntity response = null;
        System.out.println("수행");
        try {
            String hasPwd = passwordEncoder.encode(user.getPassword());
            user.setPassword(hasPwd);
            user.setRole("USER");
            savedUser = customerRepository.save(user);
            if (savedUser.getId() > 0) {
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("가입이 완료되었습니다.");
            }
        } catch (Exception exception) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("가입 오류:" + exception.getMessage());
        }
        return response;
    }
}
