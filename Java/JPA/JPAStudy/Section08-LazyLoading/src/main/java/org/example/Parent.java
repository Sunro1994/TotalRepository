package org.example;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Parent {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    //ALL로 설정하면 모든 연관관계에 있는 엔티티도 함께 영속성에 저장해준다.(영속성 전이)
    //parent만 child를 관리하고 있을때에는 사용해도 된다. 그런데 다른데서도 child와 연관괸계가 있으면 사용하면 안된다.
    // 단일 엔티티에 완전 종속적일때에는 사용해도 무방하다.
    //orphanRemoval 도 다른 곳에서 참조하지 않는 고아 객체로 보고 삭제하는 기능 (반드시 참조하는 곳이 하나일때 사용해야 함!)

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Child> childList = new ArrayList<>();

    public void addChild(Child child){
        childList.add(child);
        child.setParent(this);
    }
}
