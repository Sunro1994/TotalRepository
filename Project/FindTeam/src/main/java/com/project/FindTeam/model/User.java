package com.project.FindTeam.model;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.FetchType.*;

@Entity
@Data
@Table(name = "users")
@RequiredArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(unique = true, nullable = false)
    private String userId;

//    @Column(nullable = false)
    private String password;

//    @Column(nullable = false)
    private String name;

//    @Column(nullable = false)
    private int age;

//    @Column(unique = true, nullable = true)
    private String email;

    @Column
    private Boolean activated;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @ManyToOne(fetch = LAZY)
    private ProjectMember projectMember;


    public User(String name, int age, ProjectMember teamA) {
        this.name=name;
        this.age = age;
        this.projectMember= teamA;
    }


}
