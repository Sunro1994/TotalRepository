package study.jpa.queryDSL.domain.base;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class BaseEntity {

    /**
     * 작성자 및 작성일
     */
    private String createdBy;
    private LocalDateTime createdDate;

    /**
     * 수정자 와 수정일
     */
    private String lastModifedBy;
    private LocalDateTime lastModifedDate;


}
