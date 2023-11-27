package org.example.item;

import lombok.Data;
import org.example.domain.Category;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    //@JoinTable = 중간 테이블이 있어야 일대다 다대일로 풀어낼 수 있다.
    //실무에선 거의 이렇게 쓰지 않고 다대일 일대다로 분리해서 사용한다. 왜냐하면 컬럼테이블은 더 이상 생성이 불가하기 때문
    @ManyToMany(mappedBy = "items")
//    @JoinTable(name = "category_item")
    private List<Category> categories = new ArrayList<>();


}
