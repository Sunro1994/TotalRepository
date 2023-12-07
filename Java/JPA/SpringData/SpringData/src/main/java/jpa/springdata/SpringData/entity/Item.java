package jpa.springdata.SpringData.entity;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Item implements Persistable<String> {

    @Id @GeneratedValue
    private  String id;

    @CreatedDate
    private LocalDateTime createDate;

    public Item(String a) {
        this.id = a;
    }


    @Override
    public boolean isNew() {
        return createDate == null;
    }
}
