package jpabook.jpashop.domain;

import jpabook.jpashop.domain.item.Item;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "category_item",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id") //category_id에 들어가는 아이템을 맵핑해준다.
    )
    private List<Item> items = new ArrayList<>();


    //셀프로 양방향 엔티티 만들기
    //해당 카테고리의 하위 여러개 카테고리들을 아래와같이 나눠서 만들어줄수 있다.
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

}
