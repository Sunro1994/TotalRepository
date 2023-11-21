package org.example;

import javax.persistence.*;

@Entity
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "MEMBER_SEQ",
        initialValue = 1, allocationSize =50)
public class TestPKMapping_Sequence {

    public TestPKMapping_Sequence() {
    }

    @Id //직접 할당 : 내가 직접 Id를 생성하는 로직을 만들었다면 직접 할당하는 @Id만 사용하면 된다.
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_SEQ_GENERATOR") //자동 생성
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
