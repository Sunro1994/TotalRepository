package study.jpa.queryDSL.domain.item;

import lombok.Data;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Data
@DiscriminatorColumn(name = "DTYPE")
public class Item {

    @Id @GeneratedValue
    @Column(name = "item_id")
    private  Long id;
    private String name;
    private int price;
}
