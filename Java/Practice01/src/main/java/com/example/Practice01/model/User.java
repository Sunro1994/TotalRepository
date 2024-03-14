package com.example.Practice01.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@Entity

@Table(name = "user")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username")
    private String name;
    @Column(name = "user_pw")
    private String password;
    @Column(name= "user_email")
    private String email;
    @Column(name="user_role")
    private String role;



    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    @PrePersist //insert시작 시 동작 / 비영속 -> 영속
    public void onCreate() {
        this.createAt = LocalDateTime.now();

    }

    @PreUpdate //update시 동작
    public void onUpdate(){
        this.updateAt = LocalDateTime.now();
    }


}
