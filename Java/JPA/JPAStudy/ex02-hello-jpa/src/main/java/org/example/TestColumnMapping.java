package org.example;

import javax.persistence.*;
import java.sql.Clob;
import java.util.Date;

@Entity

public class TestColumnMapping {

    public TestColumnMapping() {
    }

    @Id
    @Column(name = "id",insertable = true,updatable = false)
    private Long id;

    @Column(columnDefinition = "varchar2(100) default 'N'",nullable = false)
    private String username;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @Lob
    private String content;

    @Transient
    private String onlyForMemoryData;

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
