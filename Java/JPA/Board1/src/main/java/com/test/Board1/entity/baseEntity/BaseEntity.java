package com.test.Board1.entity.baseEntity;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
public class BaseEntity {
    public void setModfied_date() {
        this.modfied_date = LocalDateTime.now();
    }

    public BaseEntity() {
        this.wdate = LocalDateTime.now();
    }

    private String writer;
    private LocalDateTime wdate;

    private String modifier;
    private LocalDateTime modfied_date;

}
