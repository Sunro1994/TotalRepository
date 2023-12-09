package study.jpa.queryDSL.domain.item;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("A")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
public class Album  extends  Item{

    private  String artist;

}
