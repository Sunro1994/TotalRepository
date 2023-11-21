package org.example;

import javax.persistence.*;

@Entity
@TableGenerator(
        name = "MEMBERA_SEQ_GENERATOR"
        ,table = "MY_SEQUENCE" //MY_SEQUENCE라는 이름의 테이블을 생성
        ,pkColumnName = "MEMBER_SEQ",allocationSize = 50)
public class TestPKMapping_Table {

    public TestPKMapping_Table() {
    }

    @Id //직접 할당 : 내가 직접 Id를 생성하는 로직을 만들었다면 직접 할당하는 @Id만 사용하면 된다.
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "MEMBERA_SEQ_GENERATOR")
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
