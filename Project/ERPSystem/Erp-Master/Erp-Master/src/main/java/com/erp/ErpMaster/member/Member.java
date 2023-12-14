package com.erp.ErpMaster.member;

import com.erp.ErpMaster.depart.Department;
import com.erp.ErpMaster.rank.RankEnum;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

    @Column(name = "member_password")
    private String password;

    @Column(name = "member_role")
    private String role;

    @Column(name = "member_name")
    private String name;


    @Column(name = "member_email")
    private String email;

    @Column(name = "member_age")
    private int age;

    @Column(name = "member_address")
    private String address;

    @Column(name = "member_pnum")
    private String pnum;

    @Column(name = "member_gender")
    @Enumerated(EnumType.STRING)
    private MemberGender gender;

    @Column(name = "member_birth")
    private LocalDateTime birth;

    @Column(name = "member_rank")
    @Enumerated(EnumType.STRING)
    private RankEnum rank;

    @Column(name = "member_annual_leave_days")
    private int annual_leave_days;

    @Column(name = "member_is_leave")
    private LeaveEnum isLeave;



    @Column(name = "is_used")
    private String isUsed;

    @Column(name = "is_del")
    private  String isDel;

    @Column(name = "isrt_date")
    private LocalDateTime isrtDate;

    @Column(name = "updt_date")
    private LocalDateTime updtDate;

    @OneToOne
    @JoinColumn(name = "dp_code")
    Department department;

    public void setPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(Integer.parseInt(password));
        this.password = encoder.toString();
    }
}
