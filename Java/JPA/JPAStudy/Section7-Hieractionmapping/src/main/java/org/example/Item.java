package org.example;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) //전략만 바꿔주면 테이블 전략이 바뀐다. (조인 싱글 테이블마다) 3가지로 전환이 가능
@DiscriminatorColumn(name="DIS_TYPE") //DTYPE이 아닌 다른 이름으로 사용할 수 있다.
public class Item {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private int price;
}
