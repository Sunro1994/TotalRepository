package com.erp.ErpMaster.member.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "member_tb")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "member_login_id")
    private String loginId;

    @Column(name = "member_role")
    private String role;

    @Column(name = "member_name")
    private String name;

    @Column(name = "member_password")
    private String password;

    @Column(name = "member_email")
    private String email;

    @Column(name = "is_used")
    private String isUsed;

    @Column(name = "is_del")
    private  String isDel;

    @Column(name = "isrt_date")
    private LocalDateTime isrtDate;

    @Column(name = "updt_date")
    private LocalDateTime updtDate;
}
