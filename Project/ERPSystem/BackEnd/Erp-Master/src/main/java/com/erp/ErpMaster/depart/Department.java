package com.erp.ErpMaster.depart;

import com.erp.ErpMaster.member.Member;
import jakarta.persistence.*;

@Entity
public class Department {

    @Id
    @GeneratedValue
    @Column(name = "dp_code")
    public Long id;

    @Column(name = "dp_name")
    public String name;

    @OneToOne
    Member member;
}
