package jpabook.jpashop.domain.item;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Book extends  Item{

    private String author;
    private int isbn;

}
