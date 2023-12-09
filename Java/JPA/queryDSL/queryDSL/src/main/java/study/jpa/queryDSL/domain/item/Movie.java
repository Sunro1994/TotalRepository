package study.jpa.queryDSL.domain.item;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
@DiscriminatorValue("M")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
public class Movie extends Item{

    private String director;
    private String actor;
}
