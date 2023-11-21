package org.example;

import javax.persistence.*;

@Entity

public class TestPKMapping_Identity {

    public TestPKMapping_Identity() {
    }

    @Id //직접 할당 : 내가 직접 Id를 생성하는 로직을 만들었다면 직접 할당하는 @Id만 사용하면 된다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동 생성
    private Long id;

    @Column(columnDefinition = "varchar2(100) default 'N'",nullable = false)
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
