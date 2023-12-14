package com.test.Board1.entity;

import com.test.Board1.entity.baseEntity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;


@Entity
@Data
@ToString(of = {"userId","userPw"})
@NoArgsConstructor
public class Member extends BaseEntity {



    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name = "member_user_id")
    private String userId;

    @Column(name = "member_user_pw")
    private String userPw;

    public Member( String userId, String userPw){
        this.userId = userId;
        this.userPw = userPw;
    }





}
