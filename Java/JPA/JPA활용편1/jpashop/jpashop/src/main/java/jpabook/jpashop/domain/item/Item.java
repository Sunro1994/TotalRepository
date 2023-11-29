package jpabook.jpashop.domain.item;

import jpabook.jpashop.domain.Category;
import jpabook.jpashop.exception.NotEnoughStockException;
import lombok.Data;

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

    //===비즈니스 로직===//
    //객체지향적인 코드를 짜기 위해 Item이 갖고 있는 stockQuantity의 증가/감소 로직은 해당 객체 안에서 해결한다.
    /**
     * stock 증가
     */
    public void addStock(int quantity){
        this.stockQuantity += quantity;
    }

    /**
     * stock감소
     * @param quantity
     */
    public void removeStock(int quantity) throws NotEnoughStockException {
        int restStock = this.stockQuantity - quantity;
        if (restStock < 0) {
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }


}
