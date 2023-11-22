package org.example;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
public class Book extends  Item{

    private String author;
    private String isbn;
}
