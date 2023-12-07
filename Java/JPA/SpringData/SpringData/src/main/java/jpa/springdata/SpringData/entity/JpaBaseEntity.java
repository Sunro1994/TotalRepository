package jpa.springdata.SpringData.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
public class JpaBaseEntity {

    @Column(updatable = false)
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;

    @PrePersist
    public void prePersist(){
        LocalDateTime now = LocalDateTime.now();
        this.createdDate = now;
        updateDate = now; //최초등록시 그냥 초기화하기 위해 , null을 피하기 위해 그냥 넣어둠
    }

    @PreUpdate
    public void preUpdate(){
        updateDate = LocalDateTime.now();
    }
}
